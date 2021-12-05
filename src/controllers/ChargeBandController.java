package controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ChargeBand;

public class ChargeBandController {
	
	public double getTotalCost(List<ChargeBand> chargeBands, LocalDate startDate, LocalDate endDate) {
		ChargeBand cb = getChargeBandReference(chargeBands, startDate);
		return getPrice(chargeBands, startDate, endDate)
				+ cb.getCleaningCharge()
				+ cb.getServiceCharge();
	}
	
	public ChargeBand getChargeBandReference(List<ChargeBand> chargeBands, LocalDate day) {
		for(ChargeBand cb : chargeBands) {
			if(day.isAfter(cb.getStartDate()) && day.isBefore(cb.getEndDate())
				|| day.isEqual(cb.getStartDate()) || day.isEqual(cb.getEndDate())) {
				return cb;
			}
		}
		return null;
	}
	
	public double getPrice(List<ChargeBand> chargeBands, LocalDate startDate, LocalDate endDate) {
		double price = 0.0;
		do {
			ChargeBand cb = getChargeBandReference(chargeBands, startDate);
			price += cb.getPricePerNight();
			startDate = startDate.plusDays(1);
		} while (startDate.isBefore(endDate));
		return price;
	}
	
	/**
	 * A method to get the next date,
	 * from the furthest date added to a property
	 * @return
	 */
	public LocalDate getNextDate(List<ChargeBand> chargeBands) {
		LocalDate last = chargeBands.get(0).getEndDate();
		for(ChargeBand cb : chargeBands) {
			if(cb.getEndDate().isAfter(last)) {
				last = cb.getEndDate();
			}
		}
		return last.plusDays(1);
	}
	
	public boolean chargeBandsOverlap(List<ChargeBand> chargeBands, ChargeBand newBand) {
		for(ChargeBand cb : chargeBands) {
			LocalDate date = newBand.getStartDate();
			do {
				if(date.isAfter(cb.getStartDate()) && date.isBefore(cb.getEndDate())
						|| date.isEqual(cb.getStartDate()) || date.isEqual(cb.getEndDate())) {
					return true;
				}
				date = date.plusDays(1);
			} while(date.isBefore(newBand.getEndDate()));
		}
		return false;
	}
	
	public boolean dayInChargeBands(LocalDate day, List<ChargeBand> chargeBands) {
		for(ChargeBand cb : chargeBands) {
			if(day.isAfter(cb.getStartDate()) && day.isBefore(cb.getEndDate())
					|| day.isEqual(cb.getStartDate()) || day.isEqual(cb.getEndDate())) {
				return true;
			}
		}
		return false;	
	}
	
	public boolean allDatesCovered(List<ChargeBand> chargeBands) {
		LocalDate today = LocalDate.now();
		while((today.isBefore(LocalDate.parse("2022-12-31")))) {
			if(!(dayInChargeBands(today, chargeBands))) {
				return false;
			}
			today = today.plusDays(1);
		}
		return true;
	}
		
	public List<ChargeBand> getChargeBandsByPropertyID(String propertyID){
		String query = "SELECT * FROM team023.`Charge Band` WHERE propertyID='" + String.valueOf(propertyID) + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		Date startDate;
		Date endDate;
		float pricePerNight;
		float seviceCharge;
		float cleaningCharge;
		
		List<ChargeBand> allChargeBands = new ArrayList<ChargeBand>();
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				results.getString(1);
				startDate = results.getDate(2);
				endDate = results.getDate(3);
				pricePerNight = results.getFloat(4);
				seviceCharge = results.getFloat(5);
				cleaningCharge = results.getFloat(6);
				
				
				ChargeBand chargeBand = new ChargeBand(startDate.toString(), endDate.toString(), pricePerNight, seviceCharge, cleaningCharge);
				allChargeBands.add(chargeBand);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return allChargeBands;	
	}
	
}

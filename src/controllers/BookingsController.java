package controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import model.Bathing;
import model.Kitchen;
import model.Living;
import model.Outdoor;
import model.Reservation;
import model.Sleeping;
import model.Utility;

public class BookingsController {

	public void acceptBooking(String uderID, int propertyID, String startDate, String endDate) {
		String query = "UPDATE `team023`.`Reservation` SET `accepted` = '1' WHERE userID='" + uderID + "' AND propertyID='" + propertyID + "' AND startDate='"+ startDate +"' AND endDate='"+ endDate+"';";
		DatabaseCommunication db = new DatabaseCommunication();
		
		try {
			db.updateExecute(query);
			rejectOverlappingBookings(propertyID, startDate, endDate);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
		}	
	}
	
	public void rejectBooking(String uderID, int propertyID, String startDate, String endDate) {
		String query = "DELETE FROM `team023`.`Reservation` WHERE userID='" + uderID + "' AND propertyID='" + propertyID + "' AND startDate='"+ startDate +"' AND endDate='"+ endDate+"';";
		DatabaseCommunication db = new DatabaseCommunication();
		
		try {
			db.updateExecute(query);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
		}	
	}
	
	public void rejectOverlappingBookings(int propertyID, String startDate, String endDate) {
		String query = "DELETE FROM `team023`.`Reservation` WHERE propertyID='" + propertyID + 
				"' AND accepted=0 AND ((startDate>='" + startDate + "' AND endDate<='" + endDate + "') OR "
				+ "(startDate>='" + startDate + "' AND startDate<='" + endDate + "') OR (startDate<='" + 
				startDate + "' AND endDate>='" + endDate + "') OR (endDate>='" + startDate + "' AND endDate<='" + endDate + "')) ;";
		DatabaseCommunication db = new DatabaseCommunication();
		try {
			db.updateExecute(query);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
		}
	}
	
	//Given the property, a start date and an end date, returns whether or not the property is available
	public boolean isPropertyAvailable(int propertyID, LocalDate start, LocalDate end) {
		String query = "SELECT startDate, endDate  FROM team023.`Reservation` WHERE (propertyID=" + propertyID + ") AND accepted=1;";
        DatabaseCommunication db = new DatabaseCommunication();
        ArrayList<LocalDate> startDates = new ArrayList<>();
        ArrayList<LocalDate> endDates = new ArrayList<>();
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				startDates.add(LocalDate.parse(results.getDate(1).toString()));
				endDates.add(LocalDate.parse(results.getDate(2).toString()));
					}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
		}
		
		if(start.isBefore(LocalDate.now()))
			return false;
		if(start.isAfter(end))
			return false;
				
		for (int i = 0; i < startDates.size(); i++) {
			//if any of the dates are equal with an existing reservation returns false
			if (start.isEqual(startDates.get(i)) || start.isEqual(endDates.get(i)) || end.isEqual(startDates.get(i)) || end.isEqual(endDates.get(i))) {
				return false;
			  //if the dates are between start and end date of an existing booking returns false
			} else if (start.isAfter(startDates.get(i)) && end.isBefore(endDates.get(i))) {
				return false;
			  //if start date is before the end date of an existing booking returns false
			} else if (start.isAfter(startDates.get(i)) && start.isBefore(endDates.get(i))) {
				return false;
			  //if the dates of an existing booking are between the given dates, returns false
			} else if (start.isBefore(startDates.get(i)) && end.isAfter(endDates.get(i))) {
				return false;
			  //if end date is after the starting date of an existing booking and before the ending date returns false
			} else if (end.isAfter(startDates.get(i)) && end.isBefore(endDates.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public Pair<ArrayList<Reservation>, ArrayList<ArrayList<String>>> getAllReservations(String userID) {
		String query = "SELECT propertyID, startDate, endDate, accepted FROM team023.Reservation WHERE userID='" + userID + "';";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		ArrayList<Reservation> allReservations = new ArrayList<>();
		ArrayList<ArrayList<String>> propertyInfo = new ArrayList<>();
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				String propertyQuery = "SELECT shortName, description, generalLocation FROM team023.Property WHERE propertyID='" + results.getInt(1) + "';";
				
				int propertyID = results.getInt(1);
				Date startDate = results.getDate(2);
				Date endDate = results.getDate(3);
				Boolean accepted = results.getBoolean(4);
				
				
				ResultSet pResults = db.queryExecute(propertyQuery);
				while (pResults.next()) {
					String shortNameString = pResults.getString(1);
					String description = pResults.getString(2);
					String generalLocation = pResults.getString(3);
					
					ArrayList<String> info = new ArrayList<>();
					info.add(shortNameString);
					info.add(description);
					info.add(generalLocation);
					
					propertyInfo.add(info);
				}
						
				Reservation reservation = new Reservation(userID, propertyID, startDate, endDate, accepted);
				allReservations.add(reservation);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		Pair<ArrayList<Reservation>, ArrayList<ArrayList<String>>> reservations = new Pair<ArrayList<Reservation>, ArrayList<ArrayList<String>>>(allReservations, propertyInfo);
	
		return reservations;
	}
	
}

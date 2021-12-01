package main;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Facilities.Bathing;
import Facilities.Kitchen;
import Facilities.Living;
import Facilities.Outdoor;
import Facilities.Sleeping;
import Facilities.Utility;

public class BookingsController {

	public void acceptBooking(String uderID, int propertyID, String startDate, String endDate) {
		String query = "UPDATE `team023`.`Reservation` SET `accepted` = '1' WHERE userID='" + uderID + "' AND propertyID='" + propertyID + "' AND startDate='"+ startDate +"' AND endDate='"+ endDate+"';";
		DatabaseCommunication db = new DatabaseCommunication();
		
		try {
			db.updateExecute(query);

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
	
	public boolean isPropertyAvailable(int propertyID, LocalDate start, LocalDate end) {
		String query = "SELECT startDate, endDate  FROM team023.`Reservation` WHERE (propertyID=" + propertyID + ");";
		
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
				
		for (int i = 0; i < startDates.size(); i++) {
			if (start.isEqual(startDates.get(i)) || start.isEqual(endDates.get(i)) || end.isEqual(startDates.get(i)) || end.isEqual(endDates.get(i))) {
				return false;
			} else if (start.isAfter(startDates.get(i)) && end.isBefore(endDates.get(i))) {
				return false;
			} else if (start.isAfter(startDates.get(i)) && start.isBefore(endDates.get(i))) {
				return false;
			} else if (start.isBefore(startDates.get(i)) && end.isAfter(endDates.get(i))) {
				return false;
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
	
	
	public static void main(String [] args) {
//		BookingsController bc = new BookingsController();
//		bc.acceptBooking("amatoli@email.com", 33);
//		System.out.println(bc.isPropertyAvailable(33, LocalDate.parse("2021-12-21"), LocalDate.parse("2021-12-31")));
//		System.out.println(bc.getAllReservations("amatoli@email.com").left.get(0).getPropertyID());
		
	}
}

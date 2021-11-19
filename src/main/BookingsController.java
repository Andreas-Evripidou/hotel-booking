package main;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookingsController {

	public void acceptBooking(String uderID, int propertyID) {
		String query = "UPDATE `team023`.`Reservation` SET `accepted` = '1' WHERE userID='" + uderID + "' AND propertyID='" + propertyID + "';";
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
		String query = "SELECT startDate, endDate  FROM team023.`Reservation` WHERE (propertyID=33);";
				
//				"AND startDate BETWEEN '" + start +"' AND '" + end + "') OR (propertyID=33 AND endDate BETWEEN '"+ start +"' AND '" + end + "');";
		
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
			} else if ( start.isAfter(startDates.get(i)) && end.isBefore(endDates.get(i))) {
				return false;
			} else if ( start.isAfter(startDates.get(i)) &&  start.isBefore(endDates.get(i))) {
				return false;
			} else if ( start.isBefore(startDates.get(i)) &&  end.isAfter(endDates.get(i))) {
				return true;
			} else if ( end.isAfter(startDates.get(i)) &&  end.isBefore(endDates.get(i))) {
				return false;
			}
		}
		
		
		return true;
	}
	
	public static void main(String [] args) {
		BookingsController bc = new BookingsController();
		bc.acceptBooking("amatoli@email.com", 33);
		System.out.println(bc.isPropertyAvailable(33,LocalDate.parse("2021-12-21"), LocalDate.parse("2021-12-31")));
		
	}
}

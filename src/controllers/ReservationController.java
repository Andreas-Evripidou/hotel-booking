package controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Facilities.Bathing;
import Facilities.Bathroom;
import main.DatabaseCommunication;
import main.Reservation;

public class ReservationController {
	public ArrayList<Reservation> getReservationsByPropertyID(String propertyID) {
		
		String query = "SELECT * FROM team023.Reservation WHERE propertyID='" + propertyID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		String userID;
		
		Date startDate;
		Date endDate;
		Boolean accepted;
		
		ArrayList<Reservation> reservations = new ArrayList<>();
		Reservation reservation = null;
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				userID = results.getString(1);
				results.getString(2);
				startDate = results.getDate(3);
				endDate = results.getDate(4);
				accepted = results.getBoolean(5);
				
				reservation = new Reservation(userID, propertyID, startDate, endDate, accepted);		
				reservations.add(reservation);
				}
			
			return reservations;
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return null;
		}
	
	}
	

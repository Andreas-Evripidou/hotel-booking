package controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Bathing;
import model.Bathroom;
import model.Property;
import model.Reservation;

public class ReservationController {
	
	public ArrayList<Reservation> getReservationsByHostID(String hostID) {
		
		PropertyController pc = new PropertyController();
		ArrayList<String> hostIDs= pc.getAllPropertIDByHostID(hostID);
		ArrayList<Reservation> reservations = new ArrayList<>();
		
		for (int i=0 ; i<hostIDs.size() ; i++) {
			String query = "SELECT * FROM team023.Reservation WHERE propertyID='" + hostIDs.get(i) + "'";
			DatabaseCommunication db = new DatabaseCommunication();
			
			String userID;
			int propertyID;
			Date startDate;
			Date endDate;
			Boolean accepted;
			
			
			Reservation reservation = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					userID = results.getString(1);
					propertyID = results.getInt(2);
					startDate = results.getDate(3);
					endDate = results.getDate(4);
					accepted = results.getBoolean(5);
					
					reservation = new Reservation(userID, propertyID, startDate, endDate, accepted);		
					reservations.add(reservation);
					}
				
				
				
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
				}
		}
		return reservations;
	}
	
	public ArrayList<Reservation> getAcceptedReservationsByHostID(String hostID) {
			
		PropertyController pc = new PropertyController();
		ArrayList<String> hostIDs= pc.getAllPropertIDByHostID(hostID);
		ArrayList<Reservation> reservations = new ArrayList<>();;
		
		for (int i=0 ; i<hostIDs.size() ; i++) {
			String query = "SELECT * FROM team023.Reservation WHERE propertyID='" + hostIDs.get(i) + "' AND accepted='1'";
			DatabaseCommunication db = new DatabaseCommunication();

			
			String userID;
			int propertyID;
			Date startDate;
			Date endDate;
			Boolean accepted;
			
			
			Reservation reservation = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					userID = results.getString(1);
					propertyID = results.getInt(2);
					startDate = results.getDate(3);
					endDate = results.getDate(4);
					accepted = results.getBoolean(5);
					
					reservation = new Reservation(userID, propertyID, startDate, endDate, accepted);		
					reservations.add(reservation);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
				}
		}

		return reservations;
	}
	
	public ArrayList<Reservation> getNotAcceptedReservationsByHostID(String hostID) {
			
		PropertyController pc = new PropertyController();
		ArrayList<String> propertiesIDs= pc.getAllPropertIDByHostID(hostID);
		ArrayList<Reservation> reservations = new ArrayList<>();
		
		for (int i = 0 ; i < propertiesIDs.size(); i++) {
			String query = "SELECT * FROM team023.Reservation WHERE propertyID='" + propertiesIDs.get(i) + "' AND accepted='0'";
			DatabaseCommunication db = new DatabaseCommunication();
			
			String userID;
			int propertyID;
			Date startDate;
			Date endDate;
			Boolean accepted;
			
			
			Reservation reservation = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					userID = results.getString(1);
					propertyID = results.getInt(2);
					startDate = results.getDate(3);
					endDate = results.getDate(4);
					accepted = results.getBoolean(5);
					reservation = new Reservation(userID, propertyID, startDate, endDate, accepted);		
					reservations.add(reservation);
					}
				
				
				
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
				}
			
		}
		
		return reservations;
	}
	
	public ArrayList<Reservation> getReservationsByPropertyID(int propertyID) {
		
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
	

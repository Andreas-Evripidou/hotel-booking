package controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Facilities.Bathing;
import Facilities.Bathroom;
import main.DatabaseCommunication;
import main.Property;
import main.Reservation;

public class ReservationController {
	
	public ArrayList<Reservation> getReservationsByHostID(String hostID) {
		
		PropertyController pc = new PropertyController();
		ArrayList<String> hostIDs= pc.getAllPropertIDByHostID(hostID);
		
		for (int i=0 ; i<hostIDs.size() ; i++) {
			String query = "SELECT * FROM team023.Reservation WHERE propertyID='" + hostIDs.get(i) + "'";
			DatabaseCommunication db = new DatabaseCommunication();
			
			String userID;
			String propertyID;
			Date startDate;
			Date endDate;
			Boolean accepted;
			
			ArrayList<Reservation> reservations = new ArrayList<>();
			Reservation reservation = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					userID = results.getString(1);
					propertyID = results.getString(2);
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
		}
		return null;
	}
	
	public ArrayList<Reservation> getAcceptedReservationsByHostID(String hostID) {
			
		PropertyController pc = new PropertyController();
		ArrayList<String> hostIDs= pc.getAllPropertIDByHostID(hostID);
		
		for (int i=0 ; i<hostIDs.size() ; i++) {
			String query = "SELECT * FROM team023.Reservation WHERE propertyID='" + hostIDs.get(i) + "' AND accepted='1'";
			DatabaseCommunication db = new DatabaseCommunication();
			
			String userID;
			String propertyID;
			Date startDate;
			Date endDate;
			Boolean accepted;
			
			ArrayList<Reservation> reservations = new ArrayList<>();
			Reservation reservation = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					userID = results.getString(1);
					propertyID = results.getString(2);
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
		}
		return null;
	}
	
	public ArrayList<Reservation> getNotAcceptedReservationsByHostID(String hostID) {
			
		PropertyController pc = new PropertyController();
		ArrayList<String> hostIDs= pc.getAllPropertIDByHostID(hostID);
		
		for (int i=0 ; i<hostIDs.size() ; i++) {
			String query = "SELECT * FROM team023.Reservation WHERE propertyID='" + hostIDs.get(i) + "' AND accepted='0'";
			DatabaseCommunication db = new DatabaseCommunication();
			
			String userID;
			String propertyID;
			Date startDate;
			Date endDate;
			Boolean accepted;
			
			ArrayList<Reservation> reservations = new ArrayList<>();
			Reservation reservation = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					userID = results.getString(1);
					propertyID = results.getString(2);
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
		}
		return null;
	}
	
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
	

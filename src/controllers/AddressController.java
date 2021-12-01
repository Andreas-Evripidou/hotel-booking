package controllers;

import java.sql.ResultSet;

import main.Address;
import main.DatabaseCommunication;

public class AddressController {
	
	public Address getAddress(String postcodeCPK, String houseCPK){
		String query = "SELECT * FROM team023.Address WHERE postcode='" + postcodeCPK + "' AND house='"+ houseCPK +"'";
		DatabaseCommunication db = new DatabaseCommunication();		
		
		String house;
		String postcode;
		String streetName;
		String placeName;
		
		
		Address address = null;
		try {
			
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				
				house = results.getString(1);
				postcode = results.getString(2);
				streetName = results.getString(3);
				placeName = results.getString(4);
				
				address = new Address(house, streetName, placeName, postcode);
			}
			
			
			return address;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return null;
	}
	
	public Address getAddressByPropertyID(String propertyID) {
		String queryProperty = "SELECT house, postcode FROM team023.Property WHERE propertyID='" + propertyID + "';";
		DatabaseCommunication db = new DatabaseCommunication();	
		String house = null;
		String postcode = null;
		try {
			
			ResultSet results = db.queryExecute(queryProperty);
			while (results.next()) {
				house = results.getString(1);
				postcode = results.getString(2);
			}
			return getAddress(postcode, house);
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return null;
	}
	
	public Address getAddressByUserID(String userID) {
		String queryProperty = "SELECT house, postcode FROM team023.Person WHERE userID='" + userID + "';";
		DatabaseCommunication db = new DatabaseCommunication();	
		String house = null;
		String postcode = null;
		try {
			
			ResultSet results = db.queryExecute(queryProperty);
			while (results.next()) {
				house = results.getString(1);
				postcode = results.getString(2);
			}
			return getAddress(postcode, house);
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return null;
	}
	
	public static void main (String [] args) {
		AddressController aController = new AddressController();
		System.out.println(aController.getAddressByUserID("moisis@gmaail.com").getPlaceName());
	}
}

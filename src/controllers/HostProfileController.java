package controllers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Facilities.*;
import main.Address;
import main.ChargeBand;
import main.ChargeBandController;
import main.DatabaseCommunication;
import main.Property;
import main.Review;

public class HostProfileController {
	
	public static ArrayList<Property> getPropertiesByHostID(String hostID) {
		String query = "SELECT * FROM team023.Property WHERE userID='" + hostID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		ChargeBandController cb = new ChargeBandController();
		FacilitiesController fc = new FacilitiesController();
		
		String propertyID;
		String userID;
		String shortName;
		String description;
		String generalLocation;
		Boolean isBreakfastOffered;
		int maximumGuest;
		String house;
		String postcode;
		
		ArrayList<Property> allProperties = new ArrayList<>();
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				propertyID = results.getString(1);
				userID = results.getString(2);
				shortName = results.getString(3);
				description = results.getString(4);
				generalLocation = results.getString(5);
				isBreakfastOffered = results.getBoolean(6);
				maximumGuest = results.getInt(7);
				house = results.getString(8);
				postcode = results.getString(9);
				
				Address address = getAddress(postcode, house);
				List<ChargeBand> chargeBands = cb.getChargeBandsByPropertyID(propertyID);
				Bathing bathingFac = fc.getBathingFacByPropertyID(propertyID);
				Sleeping sleepingFac = fc.getSleepingFacByPropertyID(propertyID);
				Kitchen kitchenFac = fc.getKitchenFacByPropertyID(propertyID);
				Living livingFac = fc.getLivingFacByPropertyID(propertyID);
				Outdoor outdoorFac = fc.getOutdoorFacByPropertyID(propertyID);
				Utility utilityFac = fc.getUtilityFacByPropertyID(propertyID);
				
				System.out.println("eimai dame");
				Property property = new Property(chargeBands, address, shortName, description, isBreakfastOffered, bathingFac, kitchenFac, livingFac, outdoorFac, sleepingFac, utilityFac);
				allProperties.add(property);
			}
			
			return allProperties;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return null;
	}
	
	public static Address getAddress(String postcodeCPK, String houseCPK){
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
				
				address = new Address(house, postcode, placeName, streetName);
			}
			
			
			return address;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return null;
	};
}

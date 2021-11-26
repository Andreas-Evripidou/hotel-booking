package controllers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Facilities.Bathing;
import Facilities.Kitchen;
import Facilities.Living;
import Facilities.Outdoor;
import Facilities.Sleeping;
import Facilities.Utility;
import main.Address;
import main.ChargeBand;
import main.ChargeBandController;
import main.DatabaseCommunication;
import main.Host;
import main.Person;
import main.Property;
import main.Reservation;

public class PropertyController {
	
	public ArrayList<Property> getPropertiesByHostID(String hostID) {
		String query = "SELECT * FROM team023.Property WHERE userID='" + hostID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		ChargeBandController cb = new ChargeBandController();
		FacilitiesController fc = new FacilitiesController();
		AddressController ac = new AddressController();
		
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
				
				Address address = ac.getAddress(postcode, house);
				List<ChargeBand> chargeBands = cb.getChargeBandsByPropertyID(propertyID);
				Bathing bathingFac = fc.getBathingFacByPropertyID(propertyID);
				Sleeping sleepingFac = fc.getSleepingFacByPropertyID(propertyID);
				Kitchen kitchenFac = fc.getKitchenFacByPropertyID(propertyID);
				Living livingFac = fc.getLivingFacByPropertyID(propertyID);
				Outdoor outdoorFac = fc.getOutdoorFacByPropertyID(propertyID);
				Utility utilityFac = fc.getUtilityFacByPropertyID(propertyID);
				
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
	
	public ArrayList<String> getAllPropertIDByHostID(String hostID) {
		String query = "SELECT propertyID FROM team023.Property WHERE userID='" + hostID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		String propertyID;
		
		ArrayList<String> allPropertyID = new ArrayList<>();
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				propertyID = results.getString(1);

				allPropertyID.add(propertyID);
			}
			
			return allPropertyID;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return null;
	}
	
	public String getPropertyNameByPropertyID(int i) {
		String query = "SELECT shortName FROM team023.Property WHERE propertyID='" + i + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		String shortName = null;
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				shortName = results.getString(1);

			}
			
			return shortName;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return null;
	}
	
	public String getPropertyDescriptionByPropertyID(int i) {
		String query = "SELECT description FROM team023.Property WHERE propertyID='" + i + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		String description = null;
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				description = results.getString(1);

			}
			
			return description;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return null;
	}
	
	public boolean offersBreakfast(String propertyID) {
		String query = "SELECT breakfast FROM team023.Property WHERE propertyID='" + propertyID + "';";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		boolean breakfast = false;
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				breakfast = results.getBoolean(1);
			}
			
			return breakfast;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return false;
	}
	
	public Pair<Property, Pair<Person, Host>> getPropertyAndHost(String propertyID) {
		FacilitiesController fController = new FacilitiesController();
		Bathing bathing = fController.getBathingFacByPropertyID(propertyID);
		Sleeping sleeping = fController.getSleepingFacByPropertyID(propertyID);
		Kitchen kitchen = fController.getKitchenFacByPropertyID(propertyID);
		Living living = fController.getLivingFacByPropertyID(propertyID);
		Outdoor outdoor = fController.getOutdoorFacByPropertyID(propertyID);
		Utility utility = fController.getUtilityFacByPropertyID(propertyID);
		
		ChargeBandController cbController = new ChargeBandController();
		List<ChargeBand> chargeBand = cbController.getChargeBandsByPropertyID(propertyID);
		
		AddressController aController = new AddressController();
		Address address = aController.getAddressByPropertyID(propertyID);
		
		boolean breakfast = offersBreakfast(propertyID);
		
		Property property = new Property(chargeBand, address, getPropertyNameByPropertyID(Integer.parseInt(propertyID)), getPropertyDescriptionByPropertyID(Integer.parseInt(propertyID)), breakfast, bathing, kitchen, living, outdoor, sleeping, utility);
		
		PersonController pController = new PersonController();
		Person person = pController.getPersonByPropertyID(propertyID);
		Host host = pController.getHostByPropertyID(propertyID);
		
		Pair<Property, Pair<Person, Host>> propertyPersonHost = new Pair<>(property, new Pair<Person, Host>(person, host));
		return propertyPersonHost;
	}
	
//	public static void main (String [] args) {
//		PropertyController pController = new PropertyController();
//		System.out.println(pController.getPropertyAndHost("33").left.getAddress());
//	}
	

}

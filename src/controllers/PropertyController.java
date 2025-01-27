package controllers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import model.Address;
import model.Bathing;
import model.ChargeBand;
import model.Host;
import model.Kitchen;
import model.Living;
import model.Outdoor;
import model.Person;
import model.Property;
import model.Sleeping;
import model.Utility;

public class PropertyController {
	
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
	

}

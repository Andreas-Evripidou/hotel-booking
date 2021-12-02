package controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class FacilitiesController {
	
	public Bathing getBathingFacByPropertyID(String propertyID){
		String query = "SELECT * FROM team023.`Bathing Facility` WHERE propertyID='" + propertyID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		String bathingFacilityID;
		boolean hasHairDryer;
		boolean hasShampoo;
		boolean hasToiletPaper;
		
		Bathing bathingFac = null;
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				bathingFacilityID = results.getString(1);
				results.getString(2);
				hasHairDryer = results.getBoolean(3);
				hasShampoo = results.getBoolean(4);
				hasToiletPaper = results.getBoolean(5);
				
				List<Bathroom> allBathrooms = getBathroomsByBathingFacilityID(bathingFacilityID);
				bathingFac = new Bathing(allBathrooms, hasHairDryer, hasShampoo, hasToiletPaper);		
				}
			
			return bathingFac;
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return null;	
	}
	
	public List<Bathroom> getBathroomsByBathingFacilityID(String bathingFacilityID){
		String query = "SELECT * FROM team023.Bathroom WHERE bathingFacilityID='" + bathingFacilityID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		boolean toilet;
		boolean bath;
		boolean shower;
		boolean shared;
		
		List<Bathroom> allBathrooms = new ArrayList<Bathroom>();
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				bathingFacilityID = results.getString(1);
				toilet = results.getBoolean(2);
				bath = results.getBoolean(3);
				shower = results.getBoolean(4);
				shared = results.getBoolean(5);
				
				Bathroom bathroom = new Bathroom(toilet, bath, shower, shared);
				
				allBathrooms.add(bathroom);
				}
			
			return allBathrooms;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return allBathrooms;
	}
	
	public Sleeping getSleepingFacByPropertyID(String propertyID){
		String query = "SELECT * FROM team023.`Sleeping Facility` WHERE propertyID='" + propertyID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		String sleepingFacilityID;
		boolean bedLiner;
		boolean towels;
		
		Sleeping sleepingFac = null;
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				sleepingFacilityID = results.getString(1);
				results.getString(2);
				bedLiner = results.getBoolean(3);
				towels = results.getBoolean(4);
				
				List<Bedroom> allBedrooms = getBedroomsBySleepingFacilityID(sleepingFacilityID);
				sleepingFac = new Sleeping(allBedrooms, bedLiner, towels);	
				}
			
			return sleepingFac;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return null;	
	}
	
	public List<Bedroom> getBedroomsBySleepingFacilityID(String sleepingFacilityID){
		String query = "SELECT * FROM team023.Bedroom WHERE sleepingFacilityID='" + sleepingFacilityID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		Bed bed1 = null;
		Bed bed2 = null;
		
		
		List<Bedroom> allBedrooms = new ArrayList<Bedroom>();
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				
				results.getInt(1);
				bed1 = Bed.stringToBed(results.getString(2));
				bed2 = Bed.stringToBed(results.getString(3));
				
				Bedroom bedroom = new Bedroom(bed1, bed2);
				
				allBedrooms.add(bedroom);
			}
			
			return allBedrooms;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return null;
	}
	
	public Kitchen getKitchenFacByPropertyID(String propertyID){
		String query = "SELECT * FROM team023.`Kitchen Facility` WHERE propertyID='" + propertyID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		boolean oven;
		boolean refrigerator;
		boolean microwave;
		boolean stove;
		boolean dishwasher;
		boolean tableware;
		boolean cookware;
		boolean basicProvisions;
		
		
		Kitchen kitchenFac = null;
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				results.getString(1);
				oven = results.getBoolean(2);
				refrigerator = results.getBoolean(3);
				microwave = results.getBoolean(4);
				stove = results.getBoolean(5);
				dishwasher = results.getBoolean(6);
				tableware = results.getBoolean(7);
				cookware = results.getBoolean(8);
				basicProvisions = results.getBoolean(9);
				
				kitchenFac = new Kitchen(refrigerator, microwave, oven, stove, dishwasher, tableware, cookware, basicProvisions);	
				}
			
			return kitchenFac;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return null;	
	}
	
	public Living getLivingFacByPropertyID(String propertyID){
		String query = "SELECT * FROM team023.`Kitchen Facility` WHERE propertyID='" + propertyID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		boolean hasWifi;
		boolean hasTV;
		boolean hasSatellite;
		boolean hasStreaming;
		boolean hasDVDPlayer;
		boolean hasBoardGames;
		
		Living livingFac = null;
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				results.getString(1);
				hasWifi = results.getBoolean(2);
				hasTV = results.getBoolean(3);
				hasSatellite = results.getBoolean(4);
				hasStreaming = results.getBoolean(5);
				hasDVDPlayer = results.getBoolean(6);
				hasBoardGames = results.getBoolean(7);
				
				livingFac = new Living( 
				 hasWifi,
				 hasTV,
				 hasSatellite,
				 hasStreaming,
				 hasDVDPlayer,
				 hasBoardGames
				 );	
				}
			
			return livingFac;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return null;	
	}
	
	public Outdoor getOutdoorFacByPropertyID(String propertyID){
		String query = "SELECT * FROM team023.`Outdoor Facility` WHERE propertyID='" + propertyID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		boolean freeOnSiteParking;
		boolean onRoadParking;
		boolean paidParking;
		boolean hasPatio;
		boolean hasBarbecue;
		
		Outdoor outdoorFac = null;
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				results.getString(1);
				freeOnSiteParking = results.getBoolean(2);
				onRoadParking = results.getBoolean(3);
				paidParking = results.getBoolean(4);
				hasPatio = results.getBoolean(5);
				hasBarbecue = results.getBoolean(6);
				
				
				outdoorFac = new Outdoor( 
					freeOnSiteParking,
					onRoadParking,
					paidParking,
					hasPatio,
					hasBarbecue
				 );	
				}
			
			return outdoorFac;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return null;	
	}
	
	public Utility getUtilityFacByPropertyID(String propertyID){
		String query = "SELECT * FROM team023.`Utility Facility` WHERE propertyID='" + propertyID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		
		boolean hasCentralHeating;
		boolean hasWashingMachine;
		boolean hasDryingMachine;
		boolean hasFireExtinguisher;
		boolean hasSmokeAlarm;
		boolean hasFirstAidKit;
		
		Utility utilityFac = null;
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				results.getString(1);
				hasCentralHeating = results.getBoolean(2);
				hasWashingMachine = results.getBoolean(3);
				hasDryingMachine = results.getBoolean(4);
				hasFireExtinguisher = results.getBoolean(5);
				hasSmokeAlarm = results.getBoolean(6);
				hasFirstAidKit = results.getBoolean(7);
				
				
				utilityFac = new Utility( 
					hasCentralHeating,
					hasWashingMachine,
					hasDryingMachine,
					hasFireExtinguisher,
					hasSmokeAlarm,
					hasFirstAidKit 
				 );	
				}
			
			return utilityFac;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		
		return null;	
	}
	
}

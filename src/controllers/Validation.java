package controllers;

import java.sql.*;

import model.Address;
import model.Bathroom;
import model.Bedroom;
import model.ChargeBand;
import model.Person;
import model.Property;

public class Validation {
	
	public boolean validateUser(String userID, String password, String whatUser) {
		if (whatUser != null) {
			String query = "SELECT userID, password FROM team023." + whatUser + " WHERE userID=?";
			DatabaseCommunication db = new DatabaseCommunication();
			String user = null;
			String pass = null;
			try {
				ResultSet results = db.getUserById(query, userID);
				
				while (results.next()) {
					user = results.getString(1);
					pass = results.getString(2);
				}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
				}
			PasswordHash ph = new PasswordHash();
			password = ph.hashPassword(password);
			return user != null && pass != null && user.equals(userID) && pass.equals(password);
		}
		return false;
	}
	
	
	public void validateProperty(Person user, Property p) {
		String insertBathing = "INSERT INTO `team023`.`Bathing Facility` (`propertyID`, `hairDryer`, `shampoo`, `toiletPaper`)"
				+ " VALUES (?, ?, ?, ?);";
		String insertKitchen = "INSERT INTO `team023`.`Kitchen Facility` (`propertyID`, `oven`, `refrigerator`, `microwave`, `stove`, "
				+ "`dishwasher`, `tableware`, `cookware`, `basicProvisions`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String insertLiving = "INSERT INTO `team023`.`Living Facility` (`propertyID`, `wifi`, `television`, `satelite`, `streaming`, "
				+ "`dvdplayer`, `boardGames`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		String insertOutdoor = "INSERT INTO `team023`.`Outdoor Facility` (`propertyID`, `freeOnSideParking`, `onRoadParking`, "
				+ "`paidCarPark`, `patio`, `barbeque`) VALUES (?, ?, ?, ?, ?, ?)";
		String insertSleeping = "INSERT INTO `team023`.`Sleeping Facility` (`propertyID`, `bedLiner`, `towels`)"
				+ "VALUES (?, ?, ?)";
		String insertUtility = "INSERT INTO `team023`.`Utility Facility` (`propertyID`, `heating`, `washingMashine`, `dryingMashine`,"
				+ " `fireExtinguisher`, `smokeAlarm`, `firstAidKit`) VALUES	(?, ?, ?, ?, ?, ?, ?)";
		
		String insertProperty = "INSERT INTO `team023`.`Property` (`userID`, `shortName`, `description`, `generalLocation`,"
				+ " `breakfast`, `maximumGuests`, `house`, `postcode`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		String insertBathroom = "INSERT INTO `team023`.`Bathroom` (`bathingFacilityID`, `toilet`, `bath`, `shower`, `shared`)"
				+ " VALUES (?, ?, ?, ?, ?)";
		String insertBedroom = "INSERT INTO `team023`.`Bedroom` (`sleepingFacilityID`, `bed1`, `bed2`) VALUES (?, ?, ?);";
		String insertChargeBand = "INSERT INTO `team023`.`Charge Band` (`propertyID`, `startDate`, `endDate`, `serviceCharge`, `cleaningCharge`, `pricePerNight`)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		String insertAddress = "INSERT INTO `team023`.`Address` (`house`, `postcode`, `streetName`, `placeName`) VALUES(?, ?, ?, ?)";
		
		DatabaseCommunication db = new DatabaseCommunication();
		try {
			db.addUserAddressInDatabase(p.getAddress(), insertAddress);
			
			db.addPropertyInDatabase(p, insertProperty, user.getEmail());
			int propertyID = db.getPropertyID(p.getPostCode());
			
			db.addBathingInDatabase(p.getBathing(), p, insertBathing, propertyID);
			int bathingFacilityID = db.getBathingFacilityID(propertyID);
			for(Bathroom b : p.getBathing().getBathrooms()) {
				db.addBathroomInDatabase(p, b, insertBathroom, bathingFacilityID);
			}
			db.addKitchenInDatabase(p.getKitchen(), p, insertKitchen, propertyID);
			db.addLivingInDatabase(p, insertLiving, propertyID);
			db.addOutdoorInDatabase(p, insertOutdoor, propertyID);
			db.addSleepingInDatabase(p, insertSleeping, propertyID);
			int sleepingFacilityID = db.getSleepingFacilityID(propertyID);
			for(Bedroom b : p.getSleeping().getBedrooms()) {
				db.addBedroomInDatabase(p, b, insertBedroom, sleepingFacilityID);
			}
			db.addUtilityInDatabase(p, insertUtility, propertyID);
			for(ChargeBand cb : p.getChargeBands()) {
				db.addChargeBandInDatabase(p, cb, insertChargeBand, propertyID);
			}
			System.out.println("Database updates finished.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
		}
	}
	
	public void validateUserRegistration(Person user, Address userAddress) {
		String insertPerson = "INSERT INTO `team023`.`Person` (`userID`, `password`, `title`, `name`, `surname`, `username`, `contactDetails`, `host`, `guest`, `house`, `postcode`) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		String insertAddress = "INSERT INTO `team023`.`Address` (`house`, `postcode`, `streetName`, `placeName`) VALUES(?, ?, ?, ?);";

		DatabaseCommunication db = new DatabaseCommunication();
		
		try {
			db.addUserAddressInDatabase(userAddress, insertAddress);
			db.addUserInDatabase(user, userAddress, insertPerson);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
		}
	}
	
	public boolean alreadyExcistsPerson(String userID) {
		String query = "SELECT COUNT(*) FROM team023.Person WHERE userID=?";
		DatabaseCommunication db = new DatabaseCommunication();
		int n = 0;
		try {
			ResultSet result = db.getUserById(query, userID);
			while (result.next()) {
				n = result.getInt(1);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return n > 0;
	}
	
	public boolean alreadyExcistsAddress( String houseName, String postcode) {
		String query = "SELECT COUNT(*) FROM team023.Person WHERE house=? AND postcode=?";
		DatabaseCommunication db = new DatabaseCommunication();
		int n = 0;
		try {
			ResultSet result = db.getAddress(query, houseName, postcode);
			while (result.next()) {
				n = result.getInt(1);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return n > 0;
	}
	
	public Boolean validEmail(String emailAddress) {
	    String eimailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	    return emailAddress.matches(eimailPattern);
	}
	
	public String isValidPassword(String password)
    {
            String validMsg = "";
            if (password.length() > 45 || password.length() < 8)
            	validMsg += "Password must be less than 45 and more than 8 characters in length. \n";
            
            String upperCaseChars = "(.*[A-Z].*)";
            if (!password.matches(upperCaseChars ))
            	validMsg +="Password must have atleast one uppercase character \n";
             
            String lowerCaseChars = "(.*[a-z].*)";
            if (!password.matches(lowerCaseChars ))
            	validMsg += "Password must have atleast one lowercase character \n";
                  
            String numbers = "(.*[0-9].*)";
            if (!password.matches(numbers ))
            	validMsg += "Password must have atleast one number \n";
            
            return validMsg; 
    }
	
	public String isValidPhoneNumber(String phoneNumber) {
		String msgString = "";
		
		if (!(phoneNumber.length()>=8 && phoneNumber.length()<=15))
			msgString += "Your phone number must be between 8 and 15 numbers long!. \n";
		
		String numbers = "(.*[0-9].*)";
		if (!phoneNumber.matches(numbers))
			msgString += "Phone number must only have numbers!";
			 
		return msgString;
	}
}

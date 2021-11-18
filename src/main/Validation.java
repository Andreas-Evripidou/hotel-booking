package main;

import java.sql.*;

import Facilities.Bathroom;
import Facilities.Bedroom;

public class Validation {
	
//	public boolean validateUser(String userID, String password, String whatUser) {
//		if (whatUser != null) {
//			String query = "SELECT * FROM team023." + whatUser + " WHERE userID='" + userID + "'";
//			DatabaseCommunication db = new DatabaseCommunication();
//			String user = null;
//			String pass = null;
//			try {
//				ResultSet results = db.queryExecute(query);
//				while (results.next()) {
//					user = results.getString(1);
//					pass = results.getString(2);
//				}
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
//				}
//			return user != null && pass != null && user.equals(userID) && pass.equals(password);
//		}
//		return false;
//	}
	
	public boolean validateUser(String userID, String password, String whatUser) {
		if (whatUser != null) {
			String query = "SELECT * FROM team023." + whatUser + " WHERE userID=?";
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
			return user != null && pass != null && user.equals(userID) && pass.equals(password);
		}
		return false;
	}
	
	
	public void validateProperty(Person user, Property p) {
		String insertBathing = "INSERT INTO `team023`. `Bathing Facility` (`propertyID`, `hairDryer`, `shampoo`, `toiletPaper`)"
				+ " VALUES (?, ?, ?, ?);";
		String insertKitchen = "INSERT INTO `team023`.`Kitchen Facility` (`propertyID`, `oven`, `refrigerator`, `microwave`, `stove`, "
				+ "`dishwasher`, `tableware`, `cookware`, `basicProvisions`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		String insertLiving = "INSERT INTO `team023`.`Living Facility` (`propertyID`, `wifi`, `television`, `satellite`, `streaming`, "
				+ "`boardGames`) VALUES (?, ?, ?, ?, ?, ?);";
		String insertOutdoor = "INSERT INTO `team023`.`Outdoor Facility` (`propertyID`, `freeOnSideParking_copy4`, `onRoadParking`, "
				+ "`paidCarPark`, `patio`, `barbecue`) VALUES (?, ?, ?, ?, ?, ?);";
		String insertSleeping = "INSERT INTO `team023`.`Sleeping Facility` (`propertyID`, `bedLiner`, `towels`)"
				+ "VALUES (?, ?, ?);";
		String insertUtility = "INSERT INTO `team023`.`Utility Facility` (`propertyID`, `heating`, `washingMachine`, `dryingMachine`,"
				+ " `fireExtinguisher`, `smokeAlarm`, `firstAidKit`) VALUES	(?, ?, ?, ?, ?, ?, ?);";
		
		String insertProperty = "INSERT INTO `team023`.`Property` (`userID`, `shortName`, `description`, `generalLocation`,"
				+ " `breakfast`, `maximumGuests`, `house`, `postcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		String insertBathroom = "INSERT INTO `team023`.`Bathroom` (`bathingFacilityID`, `toilet`, `bath`, `shower`, `shared`)"
				+ " VALUES (?, ?, ?, ?, ?);";
		String insertBedroom = "INSERT INTO `team023`.`Bedroom` (`sleepingFacilityID`, `bed1`, `bed2`) VALUES (?, ?, ?);";
		String insertChargeBand = "INSERT INTO `team023`.`Charge Band` (`propertyID`, `startDate`, `endDate`, `pricePerNight`)"
				+ " VALUES (?, ?, ?, ?);";
		
		DatabaseCommunication db = new DatabaseCommunication();
		try {
			//add the address ?
			
			
			db.addPropertyInDatabase(p, insertProperty, user.getEmail());
			
			
			db.addBathingInDatabase(p.getBathing(), p, insertBathing);
			for(Bathroom b : p.getBathing().getBathrooms()) {
				db.addBathroomInDatabase(p, b, insertBathroom);
			}
			
			db.addKitchenInDatabase(p.getKitchen(), p, insertKitchen);
			db.addLivingInDatabase(p, insertLiving);
			db.addOutdoorInDatabase(p, insertOutdoor);
			db.addSleepingInDatabase(p, insertSleeping);
			for(Bedroom b : p.getSleeping().getBedrooms()) {
				db.addBedroomInDatabase(p, b, insertBedroom);
			}
			db.addUtilityInDatabase(p, insertUtility);
			for(ChargeBand cb : p.getChargeBands()) {
				db.addChargeBandInDatabase(p, cb, insertChargeBand);
			}
			System.out.println("Database update successful");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
		}
	}
	
	public void validateUserRegistration(Person user, Address userAddress) {
		String insertPerson = "INSERT INTO `team023`.`Person` (`userID`, `password`, `title`, `name`, `surname`, `contactDetails`, `host`, `guest`, `house`, `postcode`) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
	
	public Person getUserById(String userID) {
		String query = "SELECT * FROM team023.Person WHERE userID=?";
		DatabaseCommunication db = new DatabaseCommunication();
		Person p = null;
		try {
			ResultSet result = db.getUserById(query, userID);
			while (result.next()) {
				String userId = result.getString(1);
				String password = result.getString(2);
				String title = result.getString(3);
				String forename = result.getString(4);
				String surname = result.getString(5);
				int contactDetails = Integer.parseInt(result.getString(6));
				int isGuest = Integer.parseInt(result.getString(7));
				int isHost = Integer.parseInt(result.getString(8));
				
				p = new Person(title, forename, surname, userId, contactDetails, isHost, isGuest, password);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return p;
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
}

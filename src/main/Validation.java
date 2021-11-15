package main;

import java.sql.*;

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
	
	String insertAddress = "INSERT INTO `team023`.`Address` (`house`, `postcode`, `streetName`, `placeName`) VALUES(?, ?, ?, ?);";
	
	public void validateProperty(Person user, Property p) {
		String insertBathing = "INSERT INTO `team023`. `Bathing Facility` (`bathingFacilityID`, `propertyID`, `hairDryer`, `shampoo`, `toiletPaper`)"
				+ " VALUES (?, ?, ?, ?, ?)";
		String insertKitchen = "INSERT INTO `team023`.`Kitchen Facility` (`propertyID`, `oven`, `refrigerator`, `microwave`, `stove`, "
				+ "`dishwasher`, `tableware`, `cookware`, `basicProvisions`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String insertLiving = "INSERT INTO `team023`.`Living Facility` (`propertyID`, `wifi`, `television`, `satellite`, `streaming`, "
				+ "`boardGames`) VALUES (?, ?, ?, ?, ?, ?)";
		String insertOutdoor = "INSERT INTO `team023`.`Outdoor Facility` (`propertyID`, `freeOnSideParking_copy4`, `onRoadParking`, "
				+ "`paidCarPark`, `patio`, `barbecue`) VALUES (?, ?, ?, ?, ?, ?)";
		String insertSleeping = "INSERT INTO `team023`.`Sleeping Facility` (`sleepingFacilityID`, `propertyID`, `bedLiner`, `towels`) "
				+ "VALUES (?, ?, ?, ?)";
		String insertUtility = "INSERT INTO `team023`.`Utility Facility` (`propertyID`, `heating`, `washingMachine`, `dryingMachine`,"
				+ " `fireExtinguisher`, `smokeAlarm`, `firstAidKit`) VALUES	(?, ?, ?, ?, ?, ?, ?)";
		
		String insertProperty = "INSERT INTO `team023`.`Property` (`userID`, `shortName`, `description`, `generalLocation`,"
				+ " `breakfast`, `maximumGuests`, `house`, `postcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		DatabaseCommunication db = new DatabaseCommunication();
		try {
			//add the address ?
			
			
			db.addPropertyInDatabase(p, insertProperty, user.getEmail());
			
			
			db.addBathingInDatabase(p.getBathing(), insertBathing);
			db.addKitchenInDatabase(p.getKitchen(), insertKitchen);
			db.addLivingInDatabase(p.getLiving(), insertLiving);
			db.addOutdoorInDatabase(p.getOutdoor(), insertOutdoor);
			db.addSleepingInDatabase(p.getSleeping(), insertSleeping);
			db.addUtilityInDatabase(p.getUtility(), insertUtility);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
		}
	}
	
	public void validateUserRegistration(Person user, Address userAddress) {
		String insertPerson = "INSERT INTO `team023`.`Person` (`userID`, `password`, `title`, `name`, `surname`, `contactDetails`, `host`, `guest`, `house`, `postcode`) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
}

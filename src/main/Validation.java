package main;

import java.sql.*;

public class Validation {
	
	public boolean validateUser(String userID, String password, String whatUser) {
		if (whatUser != null) {
			String query = "SELECT * FROM team023." + whatUser + " WHERE userID='" + userID + "'";
			DatabaseCommunication db = new DatabaseCommunication();
			String user = null;
			String pass = null;
			try {
				ResultSet results = db.queryExecute(query);
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
	
	public void validateUserRegistration(Person user, Address userAddress) {
		String insertAddress = "INSERT INTO `team023`.`Address` (`house`, `postcode`, `streetName`, `placeName`) VALUES(?, ?, ?, ?);";
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
	
	public boolean alreadyExcists(String userID) {
		String query = "SELECT COUNT(*) FROM team023.Person WHERE userID='" + userID + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		int n = 0;
		try {
			ResultSet result = db.queryExecute(query);
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
	
	public Boolean validPassword(String password) {
		String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\\\S+$).{8, 20}$";
		return password.matches(passwordPattern);
	}
}

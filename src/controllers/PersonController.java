package controllers;

import java.sql.ResultSet;

import model.Host;
import model.Person;

	public class PersonController {
		
		public Person getPersonByUserID(String userID) {
			String query = "SELECT * FROM team023.Person WHERE userID='" + userID + "'";
			DatabaseCommunication db = new DatabaseCommunication();
			
			Person p = null;
			 String title = null;
			 String forename = null;
			 String surname = null;
			 String username = null;
			 String emailAddress = null;
			 String phoneNumber = null;
			 int host = 0;
			 int guest = 0;
			 String password = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					emailAddress = results.getString(1);
					password = results.getString(2);
					title = results.getString(3);
					forename = results.getString(4);
					surname = results.getString(5);
					username = results.getString(6);
					phoneNumber = results.getString(7);
					host = results.getInt(8);
					guest = results.getInt(9);
					
				}
				
				p = new Person( title,  forename,  surname,  username, emailAddress,  phoneNumber,  host,  guest,  password);
				
				return p;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
				}
			return null;
		}
		
		public String getNameByUserID(String userID) {
			String query = "SELECT name FROM team023.Person WHERE userID='" + userID + "'";
			DatabaseCommunication db = new DatabaseCommunication();
			
			
			String name = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					name = results.getString(1);
	
				}
				
				return name;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
				}
			return null;
		}
		
		public String getContactNumberByUserID(String userID) {
			String query = "SELECT contactDetails FROM team023.Person WHERE userID='" + userID + "'";
				DatabaseCommunication db = new DatabaseCommunication();
				
				
				String contactDetails = null;
				
				try {
					ResultSet results = db.queryExecute(query);
					while (results.next()) {
						contactDetails = results.getString(1);
			
					}
					
					return contactDetails;
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
					}
				return null;
			}
		
		public String getUserIDByPropertyID(String propertyID) {
			String query = "SELECT userID FROM team023.Property WHERE propertyID='" + propertyID + "'";
			DatabaseCommunication db = new DatabaseCommunication();
			
			
			String userID = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					userID = results.getString(1);
		
				}
				
				return userID;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
				}
			return null;
		}
		
		public Person getPersonByPropertyID(String propertyID) {
			String userID = getUserIDByPropertyID(propertyID);
			String query = "SELECT title, name, surname, userID, contactDetails, host, guest, username FROM team023.Person WHERE userID='" + userID + "'";
			DatabaseCommunication db = new DatabaseCommunication();
			
			
			Person person = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					String title = results.getString(1);
					String forename = results.getString(2);
					String surnname = results.getString(3);
					String email = results.getString(4);
					String contactDetails = results.getString(5);
					int isHost = results.getInt(6);
					int isGuest = results.getInt(7);
					String username = results.getString(8);
					
					person = new Person(title, forename, surnname, username, email, contactDetails, isHost, isGuest, null);
				}
				
				return person;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
				}
			return null;
		}
		
		public Host getHostByPropertyID(String propertyID) {
			Person person = getPersonByPropertyID(propertyID);
			String query = "SELECT superhost FROM team023.Host WHERE userID='" + person.getEmail() + "'";
			DatabaseCommunication db = new DatabaseCommunication();
			
			
			Host host = null;
			
			try {
				ResultSet results = db.queryExecute(query);
				while (results.next()) {
					boolean superhost = results.getBoolean(1);
					
					host = new Host(person.getTitle(), person.getForename(), person.getSurname(), person.getUsername(), person.getEmail(), person.getPhoneNumber(), person.getHost(), person.getGuest(), null, person.getForename(), superhost);
				}
				
				return host;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
				}
			return null;
		}
		
		
		public static void main(String [] args) {
			PersonController pController = new PersonController();
			System.out.println(pController.getPersonByUserID("a@gmail.com").getForename());
			
		}
		
}

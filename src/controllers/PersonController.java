package controllers;

import java.sql.ResultSet;

import main.DatabaseCommunication;

	public class PersonController {
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
}

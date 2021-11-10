package main;

import java.sql.*;

public class DatabaseCommunication {
	
	private String SERVER = "jdbc:mysql://stusql.dcs.shef.ac.uk/team023";
	private String DBUSER = "team023";
	private String PASSWORD = "64783854";
	
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet res = null;
	

	public static void main(String [] args) {
//		try (Connection con = DriverManager.getConnection( "jdbc:mysql://stusql.dcs.shef.ac.uk/team023", "team023", "64783854")) {
//			// use the open connection // for one or more queries
//			try (Statement stmt = con.createStatement()) {
//				
//				ResultSet res = stmt.executeQuery("SELECT * FROM team023.Guest;");
//				
//				System.out.println(res);
//				
//				while (res.next()) {
//					String userID = res.getString(1);
//					System.out.println(userID);
//				}
//				
//			}
//			catch (SQLException ex) {
//				ex.printStackTrace();
//			}
//		}
//		catch (Exception ex) {
//			ex.printStackTrace();
//		}
		DatabaseCommunication db = new DatabaseCommunication();
		try {
			ResultSet results = db.openConnectionForQuery("SELECT * FROM team023.Guest;");
			while (results.next()) {
				String userID = results.getString(1);
				System.out.println(userID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			db.closeAll(db.res, db.stmt, db.con);
		}
		
	}
	
	public ResultSet openConnectionForQuery(String query) throws SQLException, Exception {
		
//		Connection con = null;
		
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
//			Statement stmt = null;
			try {
				stmt = con.createStatement();
//				ResultSet res = stmt.executeQuery(query);
				res = stmt.executeQuery(query);
				
				return res;
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void closeAll(ResultSet res, Statement stmt, Connection con) {
		
		if (res != null) {
			try {
	            if (!res.isClosed()) {
	            	res.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    if (stmt != null) {
	        try {
	            if (!stmt.isClosed()) {
	            	stmt.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    if (con != null) {
	        try {
	            if (!con.isClosed()) {
	            	con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	}
	
}

package main;

import java.sql.*;

public class DatabaseCommunication {
	
	private String SERVER = "jdbc:mysql://stusql.dcs.shef.ac.uk/team023";
	private String DBUSER = "team023";
	private String PASSWORD = "64783854";
	
	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet res = null;
	

	public static void main(String [] args) {
		DatabaseCommunication db = new DatabaseCommunication();
//		try {
//			ResultSet results = db.openConnectionForQuery("SELECT * FROM team023.Guest;");
//			while (results.next()) {
//				String userID = results.getString(1);
//				System.out.println(userID);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			db.closeAll(db.res, db.stmt, db.pstmt, db.con);
//		}
		
		Validation v = new Validation();
//		System.out.println(v.validateUser("malakas@email.com", "123456", "Host"));
//		db.closeAll(db.res, db.stmt, db.pstmt, db.con);
		
		Person m = new Person("am", "am", "am", "envlakas", 12343, 1, 0, "am");
		Address a = new Address("mddd", "am", "am", "am");
		
		if (!v.alreadyExcists(m.getEmail())) {
			v.validateUserRegistration(m, a);
			System.out.println("added user");
		} else {
			System.out.println("already excists");
		}
		
		
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public Statement getStatement() {
		return stmt;
	}
	
	public PreparedStatement getPreparedStatement() {
		return pstmt;
	}
	
	public ResultSet getResultSet() {
		return res;
	}
	
	public ResultSet queryExecute(String query) throws SQLException, Exception {
		
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
	
	public void addUserInDatabase(Person p, Address a, String statement) throws SQLException, Exception {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setString(1, p.getEmail());
				pstmt.setString(2, p.getPassword());
				pstmt.setString(3, p.getTitle());
				pstmt.setString(4, p.getForename());
				pstmt.setString(5, p.getSurname());
				pstmt.setInt(6, p.getPhoneNumber());
				pstmt.setInt(7, p.getHost());
				pstmt.setInt(8, p.getGuest());
				pstmt.setString(9, a.getHouse());
				pstmt.setString(10, a.getPostCode());
				
				pstmt.executeUpdate();
				
				if (p.getHost() == 1) {
					pstmt = con.prepareStatement("INSERT INTO `team023`.`Host` (`userID`, `password`, `superhost`) VALUES (?, ?, ?);");
					
					pstmt.setString(1, p.getEmail());
					pstmt.setString(2, p.getPassword());
					pstmt.setInt(3, 0);
					
					pstmt.executeUpdate();
				}
				
				if (p.getGuest() == 1) {
					pstmt = con.prepareStatement("INSERT INTO `team023`.`Guest` (`userID`, `password`) VALUES (?, ?);");
					
					pstmt.setString(1, p.getEmail());
					pstmt.setString(2, p.getPassword());
					
					pstmt.executeUpdate();
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeAll(res, stmt, pstmt, con);
		}
	}
	
	public void addUserAddressInDatabase(Address a, String statement) throws SQLException, Exception {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setString(1, a.getHouse());
				pstmt.setString(2, a.getPostCode());
				pstmt.setString(3, a.getStreetName());
				pstmt.setString(4, a.getPlaceName());
				
				pstmt.executeUpdate();
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeAll(res, stmt, pstmt, con);
		}
	}
	
	public void closeAll(ResultSet res, Statement stmt, PreparedStatement pstmt, Connection con) {
		
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
	    if (pstmt != null) {
	        try {
	            if (!pstmt.isClosed()) {
	            	pstmt.close();
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

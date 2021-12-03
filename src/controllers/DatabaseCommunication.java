package controllers;

import java.sql.*;

import model.*;

import controllers.*;
import views.AddPropertyPage;

public class DatabaseCommunication {
	
	public String SERVER = "jdbc:mysql://stusql.dcs.shef.ac.uk/team023";
	public String DBUSER = "team023";
	public String PASSWORD = "64783854";
	
	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet res = null;
	
	
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
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				stmt = con.createStatement();
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
	
	public int updateExecute(String updateQuery) throws SQLException, Exception {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				stmt = con.createStatement();
				int count = stmt.executeUpdate(updateQuery);
				
				return count;
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	
	public ResultSet getUserById(String query, String userId) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, userId);
				res = pstmt.executeQuery();
				
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
	
	
	
	public ResultSet getAddress(String query, String houseName, String postcode) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, houseName);
				pstmt.setString(2, postcode);
				res = pstmt.executeQuery();
				
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
				pstmt.setString(6, p.getUsername());
				pstmt.setString(7, p.getPhoneNumber());
				pstmt.setInt(8, p.getHost());
				pstmt.setInt(9, p.getGuest());
				pstmt.setString(10, a.getHouse());
				pstmt.setString(11, a.getPostCode());
				
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
	
	
	
	public ResultSet getReviewByIDs(String query, String userId, int propertyID) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, userId);
				pstmt.setInt(2, propertyID);
				res = pstmt.executeQuery();
				
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
	
	public void addReviewInDatabase(String guestID, int propertyID, Review review, String statement) throws SQLException, Exception {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setString(1, guestID);
				pstmt.setInt(2, propertyID);
				pstmt.setInt(3, review.getCleanlinessScore());
				pstmt.setInt(4, review.getCommunicationScore());
				pstmt.setInt(5, review.getCheckInScore());
				pstmt.setInt(6, review.getAccuracyScore());
				pstmt.setInt(7, review.getLocationScore());
				pstmt.setInt(8, review.getValueScore());
				pstmt.setString(9, review.getComments());
				
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

	public void addPropertyInDatabase(Property p, String statement, String userID) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setString(1, userID);
				pstmt.setString(2, p.getName());
				pstmt.setString(3, p.getDescription());
				pstmt.setString(4, p.getAddress().getPlaceName());
				if(p.getBreakfastOffered() == true) {
					pstmt.setInt(5, 1);
				} else { pstmt.setInt(5, 0); }
				pstmt.setInt(6, p.getSleeping().getTotalSleepers());
				pstmt.setString(7, p.getAddress().getHouse());
				pstmt.setString(8, p.getAddress().getPostCode());
				
				
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
	
	public int getPropertyID(String postCode) {
		//can change postcode to more relevant field if appropriate
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				String query = "SELECT propertyID FROM `team023`.`Property` WHERE postcode = ?;";
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, postCode);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					return rs.getInt(1);
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
		return 0;
	}
	
	public void addBathingInDatabase(Bathing b, Property p, String statement, int propertyID) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				
				
				pstmt.setInt(1, propertyID);
				pstmt.setInt(2, b.getHairDryer());
				pstmt.setInt(3, b.getShampoo());
				pstmt.setInt(4, b.getToiletPaper());
				
				
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

	public void addKitchenInDatabase(Kitchen k, Property p, String statement, int propertyID) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setInt(1, propertyID);
				pstmt.setInt(2, k.getOven());
				pstmt.setInt(3, k.getRefrigerator());
				pstmt.setInt(4, k.getMicrowave());
				pstmt.setInt(5, k.getStove());
				pstmt.setInt(6, k.getDishwasher());
				pstmt.setInt(7, k.getTableware());
				pstmt.setInt(8, k.getCookware());
				pstmt.setInt(9, k.getProvisions());
				
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

	public void addLivingInDatabase(Property p, String statement, int propertyID) {
		// TODO Auto-generated method stub
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setInt(1, propertyID);
				pstmt.setInt(2, p.getLiving().getWifi());
				pstmt.setInt(3, p.getLiving().getTV());
				pstmt.setInt(4, p.getLiving().getSatellite());
				pstmt.setInt(5, p.getLiving().getStreaming());
				pstmt.setInt(6, p.getLiving().getDVDPlayer());
				pstmt.setInt(7, p.getLiving().getBoardGames());
				
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

	public void addOutdoorInDatabase(Property p, String statement, int propertyID) {
		// TODO Auto-generated method stub
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setInt(1, propertyID);
				pstmt.setInt(2, p.getOutdoor().getFreeOnsiteParking());
				pstmt.setInt(3, p.getOutdoor().getOnRoadParking());
				pstmt.setInt(4, p.getOutdoor().getPaidParking());
				pstmt.setInt(5, p.getOutdoor().getPatio());
				pstmt.setInt(6, p.getOutdoor().getBarbecue());
				
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

	public void addSleepingInDatabase(Property p, String statement, int propertyID) {
		// TODO Auto-generated method stub
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setInt(1, propertyID);
				pstmt.setInt(2, p.getSleeping().getBedLinen());
				pstmt.setInt(3, p.getSleeping().getTowels());
				
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

	public void addUtilityInDatabase(Property p, String statement, int propertyID) {
		// TODO Auto-generated method stub
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setInt(1, propertyID);
				pstmt.setInt(2, p.getUtility().getCentralHeating());
				pstmt.setInt(3, p.getUtility().getWashingMachine());
				pstmt.setInt(4, p.getUtility().getDryingMachine());
				pstmt.setInt(5, p.getUtility().getFireExtinguisher());
				pstmt.setInt(6, p.getUtility().getSmokeAlarm());
				pstmt.setInt(7, p.getUtility().getFirstAidKit());
				
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

	public void addBathroomInDatabase(Property p, Bathroom b, String statement, int bathingFacilityID) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setInt(1, bathingFacilityID);
				pstmt.setInt(2, b.getToilet());
				pstmt.setInt(3, b.getBath());
				pstmt.setInt(4, b.getShower());
				pstmt.setInt(5, b.getShared());
				
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

	public void addBedroomInDatabase(Property p, Bedroom b, String statement, int sleepingFacilityID) {
		// TODO Auto-generated method stub
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setInt(1, sleepingFacilityID);
				pstmt.setString(2, b.getBed1());
				pstmt.setString(3, b.getBed2());
				
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
	
	public int getSleepingFacilityID(int propertyID) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				String query = "SELECT sleepingFacilityID FROM team023.`Sleeping Facility` WHERE propertyID = ?;";
				
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, propertyID);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					return rs.getInt(1);
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
		return 0;
	}
	
	public int getBathingFacilityID(int propertyID) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				String query = "SELECT bathingFacilityID FROM team023.`Bathing Facility` WHERE propertyID = ?;";
				
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, propertyID);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					return rs.getInt(1);
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
		return 0;
	}

	public void addChargeBandInDatabase(Property p, ChargeBand cb, String statement, int propertyID) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setInt(1, propertyID);
				pstmt.setDate(2, java.sql.Date.valueOf(cb.getStartDate()));
				pstmt.setDate(3, java.sql.Date.valueOf(cb.getEndDate()));
				pstmt.setDouble(4, cb.getPricePerNight());
				pstmt.setDouble(5, cb.getServiceCharge());
				pstmt.setDouble(6, cb.getCleaningCharge());
				
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

	public void addReservationInDatabase(Reservation reservation, String statement) {
		try {
			con = DriverManager.getConnection(SERVER, DBUSER, PASSWORD);
			try {
				pstmt = con.prepareStatement(statement);
				
				pstmt.setString(1, reservation.getUserID());
				pstmt.setInt(2, reservation.getPropertyID());
				pstmt.setDate(3, reservation.getStartDate());
				pstmt.setDate(4, reservation.getEndDate());
				if(reservation.getAccepted()) {
					pstmt.setInt(5, 1);
				} else {
					pstmt.setInt(5, 0);
				}
				
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
}

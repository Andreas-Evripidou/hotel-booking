package Facilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import main.DatabaseCommunication;

public class Sleeping {
	private List<Bedroom> bedrooms;
	private boolean hasBedLinen;
	private boolean hasTowels;
	
	public Sleeping(List<Bedroom> bedrooms,
			boolean hasBedLinem, boolean hasTowels) {
		this.bedrooms = bedrooms;
		this.hasBedLinen = hasBedLinen;
		this.hasTowels = hasTowels;
	}
	
	public List<Bedroom> getBedrooms() {
		return bedrooms;
	}
	
	public int getTotalSleepers() {
		int count = 0;
		for(Bedroom b : bedrooms) {
			count += b.getNumSleepers();
		}
		return count;
	}
	
	public boolean getBedLinen() {
		return hasBedLinen;
	}
	public boolean getTowels() {
		return hasTowels;
	}
	
	public String getSleepingFacilityID(String propertyID) {
		DatabaseCommunication dc = new DatabaseCommunication();
		
		Connection con = null;
		ResultSet res = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(dc.SERVER, dc.DBUSER, dc.PASSWORD);
			try {
				String query = "SELECT sleepingFacilityID FROM Sleeping Facility WHERE propertyID == " + propertyID;
				
				pstmt = con.prepareStatement(query);
				
				ResultSet rs = pstmt.executeQuery();
				return rs.getString(1);
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			dc.closeAll(res, stmt, pstmt, con);
		}
		return null;
	}
}

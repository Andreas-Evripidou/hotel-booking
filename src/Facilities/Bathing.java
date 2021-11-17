package Facilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import main.DatabaseCommunication;

public class Bathing {
	private List<Bathroom> bathrooms;
	private boolean hasHairDryer;
	private boolean hasShampoo;
	private boolean hasToiletPaper;
	
	public Bathing() {}
	public Bathing(List<Bathroom> bathrooms, 
			boolean hasHairDryer, boolean hasShampoo,
			boolean hasToiletPaper) {
		this.bathrooms = bathrooms;
		this.hasHairDryer = hasHairDryer;
		this.hasShampoo = hasShampoo;
		this.hasToiletPaper = hasToiletPaper;
	}
	
	public List<Bathroom> getBathrooms() {
		return bathrooms;
	}
	
	public boolean getHairDryer() {
		return hasHairDryer;
	}
	public boolean getShampoo() {
		return hasShampoo;
	}
	public boolean getToiletPaper() {
		return hasToiletPaper;
	}
	
	public String getBathingFacilityID(String propertyID) {
		DatabaseCommunication dc = new DatabaseCommunication();
		
		Connection con = null;
		ResultSet res = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(dc.SERVER, dc.DBUSER, dc.PASSWORD);
			try {
				String query = "SELECT bathingFacilityID FROM Bathing Facility WHERE propertyID == " + propertyID;
				
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

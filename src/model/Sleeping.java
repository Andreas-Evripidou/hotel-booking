package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import controllers.DatabaseCommunication;

public class Sleeping {
	private List<Bedroom> bedrooms;
	private boolean hasBedLinen;
	private boolean hasTowels;
	
	public Sleeping(List<Bedroom> bedrooms,
			boolean hasBedLinen, boolean hasTowels) {
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
	
	public int getBedLinen() {
		if(hasBedLinen) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getTowels() {
		if(hasTowels) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
}

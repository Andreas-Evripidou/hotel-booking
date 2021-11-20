package main;

import java.sql.Date;

public class Reservation {
	private String userID;
	private int propertyID;
	private Date startDate;
	private Date endDate;
	private Boolean accepted;

	
	public Reservation(String userID, int propertyID, Date startDate, Date endDate, Boolean accepted ) {
		this.userID = userID;
		this.propertyID = propertyID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.accepted = accepted;
	}
	
	public String getUserID() {
		return userID;
	}
	public int getPropertyID() {
		return propertyID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Boolean getAccepted() {
		return accepted;
	}
	
}

package main;

import java.util.Date;

public class ChargeBand {
	private Date startDate;
	private Date endDate;
	private double pricePerNight;
	private double serviceCharge;
	private double cleaningCharge;
	
	private void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	
	private void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	
	private void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	
	private void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public double getServiceCharge() {
		return serviceCharge;
	}
	
	private void setCleaningCharge(double cleaningCharge) {
		this.cleaningCharge = cleaningCharge;
	}
	public double getCleaningCharge() {
		return cleaningCharge;
	}
}

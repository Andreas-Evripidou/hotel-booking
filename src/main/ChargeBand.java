package main;

import java.util.Date;

public class ChargeBand {
	private String startDate;
	private String endDate;
	private double pricePerNight;
	private double serviceCharge;
	private double cleaningCharge;
	
	public ChargeBand(String startDate, String endDate, 
			double pricePerNight, double serviceCharge,
			double cleaningCharge) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.pricePerNight = pricePerNight;
		this.serviceCharge = serviceCharge;
		this.cleaningCharge = cleaningCharge;
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

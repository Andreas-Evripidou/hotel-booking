package model;

public class Outdoor {
	private boolean freeOnSiteParking;
	private boolean onRoadParking;
	private boolean paidParking;
	private boolean hasPatio;
	private boolean hasBarbecue;
	
	public Outdoor(boolean freeOnSiteParking, boolean onRoadParking,
			boolean paidParking, boolean hasPatio, boolean hasBarbecue) {
		this.freeOnSiteParking = freeOnSiteParking;
		this.onRoadParking = onRoadParking;
		this.paidParking = paidParking;
		this.hasPatio = hasPatio;
		this.hasBarbecue = hasBarbecue;
	}
	
	public int getFreeOnsiteParking() {
		if(freeOnSiteParking) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getOnRoadParking() {
		if(onRoadParking) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getPaidParking() {
		if(paidParking) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getPatio() {
		if(hasPatio) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getBarbecue() {
		if(hasBarbecue) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

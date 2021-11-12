package Facilities;

public class Outdoor {
	private boolean freeOnSiteParking;
	private boolean onRoadParking;
	private boolean paidParking;
	private boolean hasPatio;
	private boolean hasBarbecue;
	
	public Outdoor(boolean freeOnSiteParking, boolean onRoadParking,
			boolean paidParking, boolean hasPatio, boolean hasBarbecue) {
		this.freeOnSiteParking = freeOnSiteParking;
		this.paidParking = paidParking;
		this.hasPatio = hasPatio;
		this.hasBarbecue = hasBarbecue;
	}
}

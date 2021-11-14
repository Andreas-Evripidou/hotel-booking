package Facilities;

public class Bathroom {
	private boolean hasToilet;
	private boolean hasBath;
	private boolean hasShower;
	private boolean isShared;
	
	public Bathroom(boolean hasToilet, boolean hasBath, 
			boolean hasShower, boolean isShared) {
		this.hasToilet = hasToilet;
		this.hasBath = hasBath;
		this.hasShower = hasShower;
		this.isShared = isShared;
	}
}

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
	
	public int getToilet() {
		if(hasToilet) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getBath() {
		if(hasBath) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getShower() {
		if(hasShower) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getShared() {
		if(isShared) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

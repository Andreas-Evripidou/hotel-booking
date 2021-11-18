package Facilities;

public class Kitchen {
	private boolean hasRefrigerator;
	private boolean hasMicrowave;
	private boolean hasOven;
	private boolean hasStove;
	private boolean hasDishwasher;
	private boolean hasTableware;
	private boolean hasCookware;
	private boolean hasProvisions;
	
	public Kitchen() {}
	
	public Kitchen(boolean hasRefrigerator, boolean hasMicrowave,
			boolean hasOven, boolean hasStove, boolean hasDishwasher,
			boolean hasTableware, boolean hasCookware, boolean hasProvisions) {
		this.hasRefrigerator = hasRefrigerator;
		this.hasMicrowave = hasMicrowave;
		this.hasOven = hasOven;
		this.hasStove = hasStove;
		this.hasDishwasher = hasDishwasher;
		this.hasTableware = hasTableware;
		this.hasCookware = hasCookware;
		this.hasProvisions = hasProvisions;
	}
	
	public int getRefrigerator() {
		if(hasRefrigerator) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getMicrowave() {
		if(hasMicrowave) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getOven() {
		if(hasOven) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getStove() {
		if(hasStove) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getDishwasher() {
		if(hasDishwasher) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getTableware() {
		if(hasTableware) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getCookware() {
		if(hasCookware) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getProvisions() {
		if(hasProvisions) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

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
	
	public boolean getRefrigerator() {
		return hasRefrigerator;
	}
	public boolean getMicrowave() {
		return hasMicrowave;
	}
	public boolean getOven() {
		return hasOven;
	}
	public boolean getStove() {
		return hasStove;
	}
	public boolean getDishwasher() {
		return hasDishwasher;
	}
	public boolean getTableware() {
		return hasTableware;
	}
	public boolean getCookware() {
		return hasCookware;
	}
	public boolean getProvisions() {
		return hasProvisions;
	}
}

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
}

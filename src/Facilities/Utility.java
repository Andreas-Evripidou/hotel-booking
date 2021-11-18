package Facilities;


public class Utility {
	private boolean hasCentralHeating;
	private boolean hasWashingMachine;
	private boolean hasDryingMachine;
	private boolean hasFireExtinguisher;
	private boolean hasSmokeAlarm;
	private boolean hasFirstAidKit;
	
	public Utility(boolean hasCentralHeating, boolean hasWashingMachine,
			boolean hasDryingMachine, boolean hasFireExtinguisher,
			boolean hasSmokeAlarm, boolean hasFirstAidKit) {
		this.hasCentralHeating = hasCentralHeating;
		this.hasWashingMachine = hasWashingMachine;
		this.hasDryingMachine = hasDryingMachine;
		this.hasFireExtinguisher = hasFireExtinguisher;
		this.hasSmokeAlarm = hasSmokeAlarm;
		this.hasFirstAidKit = hasFirstAidKit;
	}
	
	public int getCentralHeating() {
		if(hasCentralHeating) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getWashingMachine() {
		if(hasWashingMachine) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getDryingMachine() {
		if(hasDryingMachine) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getFireExtinguisher() {
		if(hasFireExtinguisher) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getSmokeAlarm() {
		if(hasSmokeAlarm) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getFirstAidKit() {
		if(hasFirstAidKit) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

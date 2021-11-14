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
}

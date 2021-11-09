package main;

import java.util.List;

public class Property {
	private List<ChargeBand> chargeBands;
	private Address address;
	private String name;
	private String description;
	private boolean isBreakfastOffered;
	

	
	private void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	private void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
	private void setBreakfastOffered(boolean isBreakfastOffered) {
		this.isBreakfastOffered = isBreakfastOffered;
	}
	public boolean getBreakfastOffered() {
		return isBreakfastOffered;
	}
}

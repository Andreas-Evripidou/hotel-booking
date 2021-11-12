package main;

import java.util.List;

import Facilities.*;
import views.AddPropertyPage;

public class Property {
	//property charge bands, can have multiple for different dates
	private List<ChargeBand> chargeBands;
	
	private Address address;
	private String name;
	private String description;
	private boolean isBreakfastOffered;
	
	//the facilities of the property
	private Bathing bathing;
	private Kitchen kitchen;
	private Living living;
	private Outdoor outdoor;
	private Sleeping sleeping;
	private Utility utility;
	
	public Property() {}
	public Property(String name, Address address,
			String description, boolean isBreakfastOffered, Bathing bathing,
			Kitchen kitchen, Living living, Outdoor outdoor, Sleeping sleeping,
			Utility utility) {
		this.chargeBands = chargeBands;
		this.address = address;
		this.name = name;
		this.description = description;
		this.isBreakfastOffered = isBreakfastOffered;
		this.bathing = bathing;
		this.kitchen = kitchen;
		this.living = living;
		this.outdoor = outdoor;
		this.sleeping = sleeping;
		this.utility = utility;
	}

	
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

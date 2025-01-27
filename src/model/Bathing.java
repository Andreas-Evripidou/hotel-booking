package model;


import java.util.List;

public class Bathing {
	private List<Bathroom> bathrooms;
	private boolean hasHairDryer;
	private boolean hasShampoo;
	private boolean hasToiletPaper;
	
	public Bathing() {}
	public Bathing(List<Bathroom> bathrooms, 
			boolean hasHairDryer, boolean hasShampoo,
			boolean hasToiletPaper) {
		this.bathrooms = bathrooms;
		this.hasHairDryer = hasHairDryer;
		this.hasShampoo = hasShampoo;
		this.hasToiletPaper = hasToiletPaper;
	}
	
	public List<Bathroom> getBathrooms() {
		return bathrooms;
	}
	
	public int getHairDryer() {
		if(hasHairDryer) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getShampoo() {
		if(hasShampoo) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getToiletPaper() {
		if(hasToiletPaper) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
}

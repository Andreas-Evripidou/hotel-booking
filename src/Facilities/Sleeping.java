package Facilities;

import java.util.List;

public class Sleeping {
	private List<Bedroom> bedrooms;
	private boolean hasBedLinen;
	private boolean hasTowels;
	
	public Sleeping(List<Bedroom> bedrooms,
			boolean hasBedLinem, boolean hasTowels) {
		this.bedrooms = bedrooms;
		this.hasBedLinen = hasBedLinen;
		this.hasTowels = hasTowels;
	}
	
	public int getTotalSleepers() {
		int count = 0;
		for(Bedroom b : bedrooms) {
			count += b.getNumSleepers();
		}
		return count;
	}
}

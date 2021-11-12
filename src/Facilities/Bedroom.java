package Facilities;

public class Bedroom {
	Bed bed1;
	Bed bed2;
	
	public Bedroom(Bed bed1) {
		this.bed1 = bed1;
	}
	
	public Bedroom(Bed bed1, Bed bed2) {
		this.bed1 = bed1;
		this.bed2 = bed2;
	}
}

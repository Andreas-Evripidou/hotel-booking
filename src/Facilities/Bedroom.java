package Facilities;

public class Bedroom {
	Bed bed1;
	Bed bed2;
	
	public Bedroom(Bed bed1) {
		this.bed1 = bed1;
		this.bed2 = Bed.NO_BED;
	}
	
	public Bedroom(Bed bed1, Bed bed2) {
		this.bed1 = bed1;
		this.bed2 = bed2;
	}
	
	public int getNumSleepers() {
		int count = 0;
		
		if(bed1 == Bed.SINGLE) {
			count++;
		} else {
			count = count + 2;
		}
		if(bed2 == Bed.SINGLE) {
			count++;
		} else if(bed2 == null){
			count = count;
		} else {
			count = count + 2;
		}
		
		return count;
	}
	
	public String getBed1() {
		return Bed.bedToString(bed1);
	}
	public String getBed2() {
		return Bed.bedToString(bed2);
	}
}

package Facilities;

public enum Bed {
	SINGLE("single"),
	DOUBLE("double"),
	KING("king"),
	BUNK("bunk");
	
	private final String bedType;
	
	Bed(String bedType) { this.bedType = bedType; }
	
	public String getType() {
		return bedType;
	}
	
	public static Bed stringToBed(String bed) {
		if(bed=="Single Bed") return Bed.SINGLE;
		if(bed=="Double Bed") return Bed.DOUBLE;
		if(bed=="King Sized Bed") return Bed.KING;
		if(bed=="Bunk Bed") return Bed.BUNK;
		return null;
	}
}

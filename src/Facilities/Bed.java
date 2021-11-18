package Facilities;

public enum Bed {
	NO_BED("no bed"),
	SINGLE("single"),
	DOUBLE("double"),
	KING("king"),
	BUNK("bunk");
	
	private final String bedType;
	
	Bed(String bedType) { this.bedType = bedType; }
	
	public String getType() {
		return bedType;
	}
	
	public static String bedToString(Bed bed) {
		if(bed==Bed.NO_BED) return "no bed";
		if(bed==Bed.SINGLE) return "single";
		if(bed==Bed.DOUBLE) return "double";
		if(bed==Bed.KING) return "king";
		if(bed==Bed.BUNK) return "bunk";
		return "";
	}
	
	
	public static Bed stringToBed(String bed) {
		if(bed=="Single Bed") return Bed.SINGLE;
		if(bed=="Double Bed") return Bed.DOUBLE;
		if(bed=="King Sized Bed") return Bed.KING;
		if(bed=="Bunk Bed") return Bed.BUNK;
		return null;
	}
}

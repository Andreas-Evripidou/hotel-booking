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
		bed = bed.toLowerCase();
		if(bed=="single bed" || bed=="single") return Bed.SINGLE;
		if(bed=="double bed" || bed=="double") return Bed.DOUBLE;
		if(bed=="king sized bed" || bed=="king") return Bed.KING;
		if(bed=="bunk bed" || bed=="bunk") return Bed.BUNK;
		return null;
	}
}

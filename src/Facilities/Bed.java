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
}

package main;

public class Guest extends Person {
	public String guestName;
	
	private void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestName() {
		return guestName;
	}
}

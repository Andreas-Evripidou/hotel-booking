package model;

public class Address {
	private String house; //the name or number of the property
	private String streetName;
	private String placeName;
	private String postcode;
	
	public Address(String house, String streetName, String placeName, String postcode)  {
		this.house = house;
		this.streetName = streetName;
		this.placeName = placeName;
		this.postcode = postcode;
	}
	
	private void setHouse(String house) {
		this.house = house;
	}
	public String getHouse() {
		return house;
	}
	
	private void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetName() {
		return streetName;
	}
	
	private void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceName() {
		return placeName;
	}
	
	private void setPostCode(String postCode) {
		this.postcode = postCode;
	}
	public String getPostCode() {
		return postcode;
	}
}

package main;

public class Person {
	private String title;
	private String forename;
	private String surname;
	private String emailAddress;
	private int phoneNumber;
	private int host;
	private int guest;
	private String password;
	
	public Person() {}
	
	public Person(String title, String forename, String surname,
			String emailAddress, int phoneNumber, int host, int guest, String password) {
		this.title = title;
		this.forename = forename;
		this.surname = surname;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.host = host;
		this.guest = guest;
		this.password = password;
	}
	
	private void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
	private void setForename(String forename) {
		this.forename = forename;
	}
	public String getForename() {
		return forename;
	}
	
	private void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSurname() {
		return surname;
	}
	
	private void setEmail(String email) {
		this.emailAddress = email;
	}
	public String getEmail() {
		return emailAddress;
	}
	
	private void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	private void setHost(int host) {
		this.host = host;
	}
	public int getHost() {
		return host;
	}
	
	private void setGuest(int guest) {
		this.guest = guest;
	}
	public int getGuest() {
		return guest;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
}

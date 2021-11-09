package main;

public class Person {
	private String title;
	private String forename;
	private String surname;
	private String emailAddress;
	private String phoneNumber;
	
	public Person() {}
	
	public Person(String title, String forename, String surname,
			String emailAddress, String phoneNumber) {
		this.title = title;
		this.forename = forename;
		this.surname = surname;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
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
	
	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
}

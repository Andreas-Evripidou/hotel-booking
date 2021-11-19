package controllers;

import main.Host;
import main.Person;
import main.Property;

public class RequestController {
	private Property property;
	private Host host;
	private Person currentUser;
	
	public RequestController(Property property, Host host, Person currentUser) {
		this.property = property;
		this.host = host;
		this.currentUser = currentUser;
	}
	
	private void checkPropertyIsAvailable() {
		
	}
}

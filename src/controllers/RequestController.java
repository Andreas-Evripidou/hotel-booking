package controllers;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JOptionPane;

import model.Host;
import model.Person;
import model.Property;
import model.Reservation;

public class RequestController {
	DatabaseCommunication db = new DatabaseCommunication();
	
	private Reservation reservation;
	
	public RequestController(Reservation reservation) {
		this.reservation = reservation;
	}
	
	private boolean checkPropertyIsAvailable() {
		BookingsController bc = new BookingsController();
		return bc.isPropertyAvailable(reservation.getPropertyID(), Instant.ofEpochMilli(reservation.getStartDate().getTime())
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate()
				, Instant.ofEpochMilli(reservation.getEndDate().getTime())
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate());
	}
	
	public void makeRequest() {
		String statement = "INSERT INTO `team023`.`Reservation` (`userID`, `propertyID`, `startDate`, `endDate`, `accepted`) "
				+ "VALUES (?, ?, ?, ?, ?);";
		if(checkPropertyIsAvailable()) {
			db.addReservationInDatabase(reservation, statement);
		} else {
			JOptionPane.showMessageDialog(null, "Property unavailable for selected dates.", "Error", JOptionPane.WARNING_MESSAGE);
		}
		
	}
}

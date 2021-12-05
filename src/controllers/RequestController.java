package controllers;

import java.time.Instant;
import java.time.ZoneId;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null, "Your request has succesfully made, you can see your request the next time you login.", "Comfirmation", JOptionPane.OK_OPTION);
		} else {
			JOptionPane.showMessageDialog(null, "Property unavailable for selected dates.", "Error", JOptionPane.WARNING_MESSAGE);
		}
		
	}
}

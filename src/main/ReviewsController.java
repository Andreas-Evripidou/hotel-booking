package main;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ReviewsController {

	public ArrayList<Review> getAllReviewsOfProperty(int propertyID) {
		String query = "SELECT * FROM team023.Review WHERE propertyID='" + String.valueOf(propertyID) + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		int cleanlinessScore;
		int communicationScore;
		int checkInScore;
		int accuracyScore;
		int locationScore;
		int valueScore;
		String comments;
		ArrayList<Review> allReviews = new ArrayList<>();
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				results.getString(1);
				results.getInt(2);
				cleanlinessScore = results.getInt(3);
				communicationScore = results.getInt(4);
				checkInScore = results.getInt(5);
				accuracyScore = results.getInt(6);
				locationScore = results.getInt(7);
				valueScore = results.getInt(8);
				comments = results.getString(9);
				
				Review review = new Review(comments, cleanlinessScore, communicationScore, checkInScore, accuracyScore, locationScore, valueScore);
				allReviews.add(review);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return allReviews;
	}	
	
	public boolean alreadyExcistsReview(String userID, int propertyID) {
		String query = "SELECT COUNT(*) FROM team023.Review WHERE userID=? AND propertyID=?";
		DatabaseCommunication db = new DatabaseCommunication();
		int n = 0;
		try {
			ResultSet result = db.getReviewByIDs(query, userID, propertyID);
			while (result.next()) {
				n = result.getInt(1);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return n > 0;
	}
	
	public void writeReview(String guestID, int propertyID, Review review) {
		String insertReview = "INSERT INTO `team023`.`Review`(`userID`, `propertyID`, `cleanliness`, `communication`, `checkIn`, `accuracy`, `location`, `value`, `textDescription`) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		DatabaseCommunication db = new DatabaseCommunication();
		
		try {
			db.addReviewInDatabase(guestID, propertyID, review, insertReview);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
		}	
	}
	
	public static void main (String [] args) {
		ReviewsController rc = new ReviewsController();
		Review r = new Review("Skata!",5,5,5,5,5,5);
		
		if(!rc.alreadyExcistsReview("existing1@gmail.com", 1)) {
			rc.writeReview("existing1@gmail.com", 1, r);
			System.out.println("The review is successfully added");
		}
		else System.out.println("A user cannot review the same property more than once");
		
	}
}

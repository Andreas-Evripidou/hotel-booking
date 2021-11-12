package main;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ReviewsContoller {

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
}

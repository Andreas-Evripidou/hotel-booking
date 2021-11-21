package main;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import controllers.PersonController;


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
		String query = "SELECT COUNT(*) FROM team023.Review WHERE userID=? AND propertyID=?;";
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
	
	public boolean allowedToWriteReview(String userID, int propertyID, String endDate) {
		String query = "SELECT endDate FROM team023.Reservation WHERE userID='" + userID + "' AND propertyID='" + propertyID + "' AND endDate=' " + endDate + "';";
		DatabaseCommunication db = new DatabaseCommunication();
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				LocalDate today = LocalDate.now();
				LocalDate end = LocalDate.parse(results.getDate(1).toString());
				if (end.isBefore(today)) {
					return true;
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return false;
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
	
	public HashMap<String, Double> getAverageReviewScores(int propertyID) {
		String query = "SELECT cleanliness, communication, checkIn, accuracy, location, value FROM team023.Review WHERE propertyID='" + propertyID + "';";
		DatabaseCommunication db = new DatabaseCommunication();
		HashMap<String, Double> allScoresHashMap = new HashMap<>();
		double cleanliness = 0;
		double communication = 0;
		double checkIn = 0;
		double accuracy = 0; 
		double location = 0;
		double value = 0;

		int numberOfReviews = 0;
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				cleanliness += results.getDouble(1); 
				communication += results.getDouble(2); 
				checkIn += results.getDouble(3); 
				accuracy += results.getDouble(4); 
				location += results.getDouble(5); 
				value += results.getDouble(6); 
				numberOfReviews += 1;
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		double averageCleanliness = cleanliness / numberOfReviews;
		double averageCommunication = communication / numberOfReviews;
		double averageCheckIn = checkIn / numberOfReviews;
		double averageAccuracy = accuracy / numberOfReviews; 
		double averageLocation = location / numberOfReviews;
		double averageValue = value / numberOfReviews;
		double totalAverage = (cleanliness + communication + checkIn + accuracy + location + value) / 6 / numberOfReviews;
		
		allScoresHashMap.put("cleanliness", averageCleanliness);
		allScoresHashMap.put("communication", averageCommunication);
		allScoresHashMap.put("checkIn", averageCheckIn);
		allScoresHashMap.put("accuracy", averageAccuracy);
		allScoresHashMap.put("location", averageLocation);
		allScoresHashMap.put("value", averageValue);
		allScoresHashMap.put("total", totalAverage);
		
		return allScoresHashMap;
	}
	
	public boolean getSuperhostStatus(String userID) {
		String query = "SELECT propertyID FROM team023.Property WHERE userID='" + userID + "';";
		DatabaseCommunication db = new DatabaseCommunication();
		ArrayList<Integer> propertyIDS = new ArrayList<>();
		double averageScore = 0;
		int numberOfReviews = 0;
		try {
			ResultSet result = db.queryExecute(query);
			while (result.next()) {
				int n = result.getInt(1);
				propertyIDS.add(n);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		if (propertyIDS.size() > 0) {
			double total = 0;
			for (int id : propertyIDS) { 
				double score = getAverageReviewScores(id).get("total");
				if(!Double.isNaN(score))  {
					total += score;
					numberOfReviews += 1;
				}		
			}
			
			averageScore = total / numberOfReviews;
		}
		return averageScore >= 4.7;
	}
	
	public void updateSuperHostStatus(int propertyID) {
		PersonController pc = new PersonController();
		String userID = pc.getUserIDByPropertyID(String.valueOf(propertyID));
		int superhost = 0;
		if (getSuperhostStatus(userID)) {
			superhost = 1;
		}
		
		 
		String update  = "UPDATE `team023`.`Host` SET `superhost` = '" + superhost + "' WHERE userID='" + userID + "';";
		DatabaseCommunication db = new DatabaseCommunication();
		
		try {
			db.updateExecute(update);

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
		
		System.out.println(rc.allowedToWriteReview("amatoli@email.com", 33, "2021-11-26"));
//		System.out.println(rc.getAverageReviewScores(33).get("total"));
		System.out.println(rc.getSuperhostStatus("amatoli@email.com"));
		rc.updateSuperHostStatus(33);
		
	}
}

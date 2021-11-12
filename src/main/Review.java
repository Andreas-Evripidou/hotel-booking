package main;

public class Review {
	private int cleanlinessScore;
	private int communicationScore;
	private int checkInScore;
	private int accuracyScore;
	private int locationScore;
	private int valueScore;
	private String comments;
	
	public Review(String comments, int cleanlinessScore, int communicationScore, int checkInScore, int accuracyScore, int locationScore, int valueScore) {
		this.comments = comments;
		this.cleanlinessScore = communicationScore;
		this.communicationScore = communicationScore;
		this.checkInScore = checkInScore;
		this.accuracyScore = accuracyScore;
		this.locationScore = locationScore;
		this.valueScore = valueScore;
	}
	
	public int getCleanlinessScore() {
		return cleanlinessScore;
	}
	public int getCommunicationScore() {
		return communicationScore;
	}
	public int getCheckInScore() {
		return checkInScore;
	}
	public int getAccuracyScore() {
		return accuracyScore;
	}
	public int getLocationScore() {
		return locationScore;
	}
	public int getValueScore() {
		return valueScore;
	}
	public String getComments() {
		return comments;
	}
	
	private int addScores() {
		return cleanlinessScore +
				communicationScore +
				checkInScore +
				accuracyScore +
				locationScore +
				valueScore;
	}
	
	public double getAverageScore() {
		return ((double)addScores() / 6);
	}
	
	
}

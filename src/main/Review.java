package main;

public class Review {
	private int cleanlinessScore;
	private int communicationScore;
	private int checkInScore;
	private int accuracyScore;
	private int locationScore;
	private int valueScore;
	
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

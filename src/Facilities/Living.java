package Facilities;

public class Living {
	private boolean hasWifi;
	private boolean hasTV;
	private boolean hasSatellite;
	private boolean hasStreaming;
	private boolean hasDVDPlayer;
	private boolean hasBoardGames;
	
	public Living(boolean hasWifi, boolean hasTV, boolean hasSatellite,
			boolean hasStreaming, boolean hasDVDPlayer, boolean hasBoardGames) {
		this.hasWifi = hasWifi;
		this.hasTV = hasTV;
		this.hasSatellite = hasSatellite;
		this.hasDVDPlayer = hasDVDPlayer;
		this.hasBoardGames = hasBoardGames;
	}
	
	public int getWifi() {
		if(hasWifi) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getTV() {
		if(hasTV) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getSatellite() {
		if(hasSatellite) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getStreaming() {
		if(hasStreaming) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getDVDPlayer() {
		if(hasDVDPlayer) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getBoardGames() {
		if(hasBoardGames) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

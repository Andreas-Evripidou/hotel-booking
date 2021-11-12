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
}

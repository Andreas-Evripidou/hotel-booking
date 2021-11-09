package main;

public class Host extends Person {
	public String hostName;
	public boolean isSuperHost;
	
	private void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getHostName() {
		return hostName;
	}
	
	private void setIsSuperHost(boolean isSuperHost) {
		this.isSuperHost = isSuperHost;
	}
	public boolean getIsSuperHost() {
		return isSuperHost;
	}
}

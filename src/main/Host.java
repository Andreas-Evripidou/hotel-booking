package main;

public class Host extends Person {
	public String hostName;
	public boolean isSuperHost;
	
	public Host(String title, String forename, String surname,
			String emailAddress, int phoneNumber, int host, int guest, String password,
			String hostName, boolean isSuperHost) {
		super(title, forename, surname, emailAddress, phoneNumber, host, guest, password);
		this.hostName = hostName;
		this.isSuperHost = isSuperHost;
	}
	
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

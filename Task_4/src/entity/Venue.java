package entity;

public class Venue {
	
	private String venueName;
    private String address;
    
	public Venue() {
		this.venueName = "Unknown Venue";
        this.address = "Unknown Address";
	}
	
	public Venue(String venueName, String address) {
		this.venueName = venueName;
		this.address = address;
	}
    
	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Display venue details
    public void displayVenueDetails() {
        System.out.println("\nVenue Details:");
        System.out.println("Venue Name: " + venueName);
        System.out.println("Address: " + address);
    }

}

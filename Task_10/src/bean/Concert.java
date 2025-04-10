package bean;

public class Concert extends Event{
	
	    private String artist;
	    private String type; 
	    public Concert() {}

	    public Concert(String eventName, String eventDate, String eventTime, Venue venue, int totalSeats, double ticketPrice, String eventType, String artist, String type) {
	        super(eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, eventType);
	        this.artist = artist;
	        this.type = type;
	    }
	    
	    public String getArtist() {
			return artist;
		}

		public void setArtist(String artist) {
			this.artist = artist;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@Override
	    public void displayEventDetails() {
	        System.out.println("Concert: " + getEventName() + " | Type: " + type + ", Artist: " + artist);
	        System.out.println("Date: " + getEventDate() + ", Time: " + getEventTime());
	        getVenue().displayVenueDetails();
	        System.out.println("Tickets: " + getAvailableSeats() + "/" + getTotalSeats());
	    }

}


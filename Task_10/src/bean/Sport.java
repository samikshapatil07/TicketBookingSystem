package bean;

public class Sport extends Event{
	
	    private String sportName;
	    private String teamsName;

	    public Sport() {}

	    public Sport(String eventName, String eventDate, String eventTime, Venue venue, int totalSeats, double ticketPrice, String eventType, String sportName, String teamsName) {
	        super(eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, eventType);
	        this.sportName = sportName;
	        this.teamsName = teamsName;
	    }
	    
	    public String getSportName() {
			return sportName;
		}

		public void setSportName(String sportName) {
			this.sportName = sportName;
		}

		public String getTeamsName() {
			return teamsName;
		}

		public void setTeamsName(String teamsName) {
			this.teamsName = teamsName;
		}

		@Override
	    public void displayEventDetails() {
	        System.out.println("Sports Event: " + getEventName() + " | Sport: " + sportName + " | Match: " + teamsName);
	        System.out.println("Date: " + getEventDate() + ", Time: " + getEventTime());
	        getVenue().displayVenueDetails();
	        System.out.println("Tickets: " + getAvailableSeats() + "/" + getTotalSeats());
	    }


}

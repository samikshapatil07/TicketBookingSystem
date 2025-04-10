package bean;

public abstract class Event {
	
	private String eventName;
    private String eventDate;
    private String eventTime;
    private Venue venue;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private String eventType;

	    public Event() {}

	    public Event(String eventName, String eventDate, String eventTime, Venue venue, int totalSeats, double ticketPrice, String eventType) {
	        this.eventName = eventName;
	        this.eventDate = eventDate;
	        this.eventTime = eventTime;
	        this.venue = venue;
	        this.totalSeats = totalSeats;
	        this.availableSeats = totalSeats; // available = total at start
	        this.ticketPrice = ticketPrice;
	        this.eventType = eventType;
	    }
	    
	    public String getEventDate() {
			return eventDate;
		}

		public void setEventDate(String eventDate) {
			this.eventDate = eventDate;
		}

		public String getEventTime() {
			return eventTime;
		}

		public void setEventTime(String eventTime) {
			this.eventTime = eventTime;
		}

		public Venue getVenue() {
			return venue;
		}

		public void setVenue(Venue venue) {
			this.venue = venue;
		}

		public int getTotalSeats() {
			return totalSeats;
		}

		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}

		public double getTicketPrice() {
			return ticketPrice;
		}

		public void setTicketPrice(double ticketPrice) {
			this.ticketPrice = ticketPrice;
		}

		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}

		public void setEventName(String eventName) {
			this.eventName = eventName;
		}

		public void setAvailableSeats(int availableSeats) {
			this.availableSeats = availableSeats;
		}

		public int getAvailableSeats() { return availableSeats; }

	    public void bookTickets(int num) {
	        if (availableSeats >= num) availableSeats -= num;
	        else System.out.println("Not enough seats.");
	    }

	    public void cancelBooking(int num) {
	        availableSeats += num;
	    }

	    public double calculateTotalRevenue() {
	        return (totalSeats - availableSeats) * ticketPrice;
	    }

	    public int getBookedNoOfTickets() {
	        return totalSeats - availableSeats;
	    }

	    public abstract void displayEventDetails();

	    public String getEventName() {
	        return eventName;
	    }

}

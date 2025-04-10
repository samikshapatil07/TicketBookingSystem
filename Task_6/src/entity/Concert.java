package entity;

public class Concert extends Event{
	
	private String artist;
    private String type;

    public Concert(String eventName, String eventDate, String eventTime, String venueName, int totalSeats, double ticketPrice,
                   String artist, String type) {
        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, "Concert");
        this.artist = artist;
        this.type = type;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("Concert: " + eventName);
        System.out.println("Artist: " + artist );
        System.out.println("Type: " + type);
        System.out.println("Date: " + eventDate);
        System.out.println("Time: " + eventTime);
        System.out.println("Venue: " + venueName);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Ticket Price: " + ticketPrice);
    }

}

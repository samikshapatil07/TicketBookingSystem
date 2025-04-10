package entity;

public class Movie extends Event{
	
	private String genre;
    private String actorName;
    private String actressName;

    public Movie(String eventName, String eventDate, String eventTime, String venueName, int totalSeats, double ticketPrice,
                 String genre, String actorName, String actressName) {
        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, "Movie");
        this.genre = genre;
        this.actorName = actorName;
        this.actressName = actressName;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("Movie: " + eventName + " | Genre: " + genre );
        System.out.println("Actor: " + actorName + " | Actress: " + actressName);
        System.out.println("Date: " + eventDate + " | Time: " + eventTime);
        System.out.println("Venue: " + venueName);
        System.out.println("Available Seats: " + availableSeats + " | Ticket Price: " + ticketPrice);
    }

}

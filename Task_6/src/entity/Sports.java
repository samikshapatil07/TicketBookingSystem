package entity;

public class Sports extends Event{
	
	private String sportName;
    private String teamsName;

    public Sports(String eventName, String eventDate, String eventTime, String venueName, int totalSeats, double ticketPrice,
                  String sportName, String teamsName) {
        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, "Sports");
        this.sportName = sportName;
        this.teamsName = teamsName;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("Sport Event: " + eventName);
        System.out.println( "Game: " + sportName + " | Teams: " + teamsName);
        System.out.println("Date: " + eventDate + " | Time: " + eventTime);
        System.out.println( "Venue: " + venueName);
        System.out.println("Available Seats: " + availableSeats + " | Ticket Price: " + ticketPrice);
    }

}

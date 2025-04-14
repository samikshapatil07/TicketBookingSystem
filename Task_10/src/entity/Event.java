package entity;

public class Event {
    private String eventName;
    private String eventDate;
    private String eventTime;
    private Venue venue;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private String eventType;

    public Event(String eventName, String eventDate, String eventTime, Venue venue, int totalSeats, double ticketPrice, String eventType) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venue = venue;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public Venue getVenue() {
        return venue;
    }

    public void bookTickets(int count) {
        availableSeats -= count;
    }

    public void cancelTickets(int count) {
        availableSeats += count;
    }

    public void displayEventDetails() {
        System.out.println("Event: " + eventName + ", Type: " + eventType + ", Date: " + eventDate + ", Time: " + eventTime);
        System.out.println("Venue: " + venue.getVenueName());
        System.out.println("Tickets: " + availableSeats + "/" + totalSeats + ", Price: ₹" + ticketPrice);
    }
}

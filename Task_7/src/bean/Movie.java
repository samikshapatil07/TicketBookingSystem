package bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movie extends Event {
    public Movie(String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue,
                 int totalSeats, double ticketPrice) {
        super(eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, "Movie");
    }

    @Override
    public void displayEventDetails() {
        System.out.println("[Movie] " + eventName + " at " + venue.getVenueName() + " on " + eventDate + " " + eventTime);
        System.out.println("Seats Available: " + availableSeats + "/" + totalSeats);
        System.out.println("Price: ₹" + ticketPrice);
    }
}

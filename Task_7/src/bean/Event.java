package bean;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Event {
    protected String eventName;
    protected LocalDate eventDate;
    protected LocalTime eventTime;
    protected Venue venue;
    protected int totalSeats;
    protected int availableSeats;
    protected double ticketPrice;
    protected String eventType;

    public Event() {}

    public Event(String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue,
                 int totalSeats, double ticketPrice, String eventType) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venue = venue;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
    }

    public abstract void displayEventDetails();

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getBookedNoOfTickets() {
        return totalSeats - availableSeats;
    }

    public double calculateTotalRevenue() {
        return getBookedNoOfTickets() * ticketPrice;
    }

    public void bookTickets(int numTickets) {
        if (availableSeats >= numTickets) {
            availableSeats -= numTickets;
        } else {
            System.out.println("Not enough seats available.");
        }
    }

    public void cancelBooking(int numTickets) {
        if ((availableSeats + numTickets) <= totalSeats) {
            availableSeats += numTickets;
        } else {
            System.out.println("Cancellation failed. Exceeds total seats.");
        }
    }

    public String getEventName() {
        return eventName;
    }
}

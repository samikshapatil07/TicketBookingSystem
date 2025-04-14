package model;

import java.sql.Date;
import java.sql.Time;

public class Event {
    private int eventId;
    private String eventName;
    private Date eventDate;
    private Time eventTime;
    private int venueId;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private String eventType;
    private int bookingId;

    public Event(String eventName, Date eventDate, Time eventTime, int venueId,
                 int totalSeats, int availableSeats, double ticketPrice,
                 String eventType, int bookingId) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venueId = venueId;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
        this.bookingId = bookingId;
    }

    // Getters
    public String getEventName() { return eventName; }
    public Date getEventDate() { return eventDate; }
    public Time getEventTime() { return eventTime; }
    public int getVenueId() { return venueId; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }
    public double getTicketPrice() { return ticketPrice; }
    public String getEventType() { return eventType; }
    public int getBookingId() { return bookingId; }
}

package entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
	
	private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String venueName;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private String eventType;
    
	public Event() {
		this.eventName = "Unknown Event";
        this.eventDate = LocalDate.now();
        this.eventTime = LocalTime.now();
        this.venueName = "Unknown Venue";
        this.totalSeats = 0;
        this.availableSeats = 0;
        this.ticketPrice = 0.0;
        this.eventType = "Movie";
	}
	
	public Event(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName, int totalSeats, double ticketPrice, String eventType) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venueName = venueName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; 
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
    }
	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public LocalTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
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

    // Method to get booked tickets
    public int getBookedNoOfTickets() {
        return totalSeats - availableSeats;
    }
    
 // Method to calculate total revenue
    public double calculateTotalRevenue() {
        return getBookedNoOfTickets() * ticketPrice;
    }

    // Method to book tickets
    public boolean bookTickets(int numTickets) {
        if (numTickets <= availableSeats) {
            availableSeats -= numTickets;
            System.out.println(numTickets + " tickets booked successfully!");
            return true;
        } else {
            System.out.println("Not enough tickets available.");
            return false;
        }
    }

    // Method to cancel booking
    public void cancelBooking(int numTickets) {
        if ((availableSeats + numTickets) <= totalSeats) {
            availableSeats += numTickets;
            System.out.println(numTickets + " tickets canceled successfully!");
        } else {
            System.out.println("Invalid cancellation request.");
        }
    }

    public void displayEventDetails() {
        System.out.println("\nEvent Details:");
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + eventDate);
        System.out.println("Time: " + eventTime);
        System.out.println("Venue: " + venueName);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Ticket Price: Rs." + ticketPrice);
        System.out.println("Event Type: " + eventType);
    }


}

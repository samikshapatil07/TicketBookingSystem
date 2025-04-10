package bean;

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
		super();
	}
	
	public Event(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
            int totalSeats, double ticketPrice, String eventType) {
       this.eventName = eventName;
       this.eventDate = eventDate;
       this.eventTime = eventTime;
       this.venueName = venueName;
       this.totalSeats = totalSeats;
       this.availableSeats = totalSeats; // Initially, all seats are available
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
    
	// Book Tickets
    public boolean bookTickets(int numTickets) {
        if (numTickets > availableSeats) {
            System.out.println("Not enough tickets available!");
            return false;
        }
        availableSeats -= numTickets;
        System.out.println(numTickets + " tickets booked successfully!");
        return true;
    }
    
    // Calculate Total Revenue
    public double calculate_total_revenue() {
        int bookedTickets = getBookedNoOfTickets();
        return bookedTickets * ticketPrice;
    }

    // Get Number of Booked Tickets
    public int getBookedNoOfTickets() {
        return totalSeats - availableSeats;
    }

    // Cancel Booking
    public void cancelBooking(int numTickets) {
        if (numTickets > (totalSeats - availableSeats)) {
            System.out.println("Cannot cancel more tickets than booked!");
            return;
        }
        availableSeats += numTickets;
        System.out.println(numTickets + " tickets canceled successfully!");
    }

    // Display Event Details 
    public void display_event_details() {
        System.out.println("Event name: " + eventName );
        System.out.println("Event Type: " + eventType);
        System.out.println("Date: " + eventDate + " | Time: " + eventTime);
        System.out.println("Venue: " + venueName);
        System.out.println("Available Seats: " + availableSeats );
        System.out.println("Ticket Price:Rs." + ticketPrice);
        System.out.println("----------------------------");
    }
	
}

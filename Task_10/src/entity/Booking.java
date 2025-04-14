package entity;

import java.time.LocalDateTime;
import java.util.List;

import service.IBookingService;

public class Booking {
    private static int bookingCounter = 1;
    private int bookingId;
    private List<Customer> customers;
    private Event event;
    private int numTickets;
    private double totalCost;
    private LocalDateTime bookingDate;

    public Booking(List<Customer> customers, Event event, int numTickets) {
        this.bookingId = bookingCounter++;
        this.customers = customers;
        this.event = event;
        this.numTickets = numTickets;
        this.totalCost = event.getTicketPrice() * numTickets;
        this.bookingDate = LocalDateTime.now();
    }

    public int getBookingId() {
        return bookingId;
    }

    public void displayBookingDetails() {
        System.out.println("Booking ID: " + bookingId);
        event.displayEventDetails();
        for (Customer c : customers) {
            c.displayCustomerDetails();
        }
        System.out.println("Tickets: " + numTickets + ", Total Cost: ₹" + totalCost + ", Date: " + bookingDate);
    }

	public IBookingService getEvent() {
		// TODO Auto-generated method stub
		return null;
	}
}

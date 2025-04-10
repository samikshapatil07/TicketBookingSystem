package bean;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

public class Booking {
    private static int counter = 1;
    private int bookingId;
    private Set<Customer> customers;
    private Event event;
    private double totalCost;
    private LocalDateTime bookingDate;

    public Booking(Event event, Set<Customer> customers) {
        this.bookingId = counter++;
        this.event = event;
        this.customers = new HashSet<>(customers); 
        this.totalCost = event.getTicketPrice() * customers.size();
        this.bookingDate = LocalDateTime.now();
        event.bookTickets(customers.size());
    }

    public int getBookingId() {
        return bookingId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void cancelBooking() {
        event.cancelBooking(customers.size());
    }

    public void displayBookingDetails() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Event: " + event.getEventName());
        System.out.println("Tickets: " + customers.size());
        System.out.println("Total Cost: ₹" + totalCost);
        System.out.println("Booking Date: " + bookingDate);
        for (Customer c : customers) {
            c.displayCustomerDetails();
        }
    }
}

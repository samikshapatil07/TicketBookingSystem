package bean;

import java.time.LocalDateTime;

public class Booking {
    private static int counter = 1;
    private int bookingId;
    private Customer[] customers;
    private Event event;
    private int numTickets;
    private double totalCost;
    private LocalDateTime bookingDate;

    public Booking(Event event, Customer[] customers) {
        this.bookingId = counter++;
        this.event = event;
        this.customers = customers;
        this.numTickets = customers.length;
        this.totalCost = event.ticketPrice * numTickets;
        this.bookingDate = LocalDateTime.now();
        event.bookTickets(numTickets);
    }

    public int getBookingId() {
        return bookingId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void cancelBooking() {
        event.cancelBooking(numTickets);
    }

    public void displayBookingDetails() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Event: " + event.getEventName());
        System.out.println("Tickets: " + numTickets);
        System.out.println("Total Cost: ₹" + totalCost);
        System.out.println("Booking Date: " + bookingDate);
        for (Customer c : customers) {
            c.displayCustomerDetails();
        }
    }
}

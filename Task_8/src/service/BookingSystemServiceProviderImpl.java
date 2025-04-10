package service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bean.Booking;
import bean.Customer;
import bean.Event;

public class BookingSystemServiceProviderImpl extends EventServiceProviderImpl implements IBookingSystemServiceProvider{
	
	private static List<Booking> bookings = new ArrayList<>();

    @Override
    public double calculateBookingCost(int numTickets, double ticketPrice) {
        return numTickets * ticketPrice;
    }

    @Override
    public void bookTickets(String eventName, int numTickets, Customer[] customers) {
        Event selectedEvent = null;
        for (Event e : events) {
            if (e.getEventName().equalsIgnoreCase(eventName)) {
                selectedEvent = e;
                break;
            }
        }

        if (selectedEvent == null) {
            System.out.println("Event not found.");
            return;
        }

        if (selectedEvent.getAvailableSeats() < numTickets) {
            System.out.println("Not enough seats available!");
            return;
        }

        selectedEvent.bookTickets(numTickets);
        double totalCost = calculateBookingCost(numTickets, selectedEvent.getTicketPrice());
        Booking booking = new Booking(customers, selectedEvent, numTickets, totalCost, LocalDateTime.now());
        bookings.add(booking);

        System.out.println("Booking successful! Booking ID: " + booking.getBookingId());
    }

    @Override
    public void cancelBooking(int bookingId) {
        Booking toCancel = null;
        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {
                toCancel = b;
                break;
            }
        }

        if (toCancel == null) {
            System.out.println("Booking ID not found.");
            return;
        }

        toCancel.getEvent().cancelBooking(toCancel.getNumTickets());
        bookings.remove(toCancel);
        System.out.println("Booking cancelled successfully.");
    }

    @Override
    public void getBookingDetails(int bookingId) {
        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {
                b.displayBookingDetails();
                return;
            }
        }
        System.out.println("Booking ID not found.");
    }

}

package service;

import bean.*;
import exception.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Event> events = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void createEvent(String name, String date, String time, int seats, double price, String type, Venue venue) {
        Event event = null;
        LocalDate eventDate = LocalDate.parse(date);
        LocalTime eventTime = LocalTime.parse(time);

        switch (type.toLowerCase()) {
            case "movie":
                event = new Movie();
                break;
            case "concert":
                event = new Concert();
                break;
            case "sport":
                event = new Sport();
                break;
            default:
                System.out.println("Invalid event type.");
                return;
        }

        events.add(event);
    }

    public void bookTickets(String eventName, Customer[] customers) throws EventNotFoundException {
        for (Event e : events) {
            if (e.getEventName().equalsIgnoreCase(eventName)) {
                Booking booking = new Booking();
                bookings.add(booking);
                System.out.println("✅ Booking successful! Booking ID: " + booking.getBookingId() +
                        " | Total Cost: ₹" + booking.getTotalCost());
                return;
            }
        }
        throw new EventNotFoundException("Event '" + eventName + "' not found.");
    }

    public void cancelBooking(int bookingId) throws InvalidBookingIDException {
        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {
                b.cancelBooking();
                bookings.remove(b);
                System.out.println("✅ Booking ID " + bookingId + " cancelled successfully.");
                return;
            }
        }
        throw new InvalidBookingIDException("Booking ID " + bookingId + " not found.");
    }

    public void getAvailableSeats(String eventName) throws EventNotFoundException {
        for (Event e : events) {
            if (e.getEventName().equalsIgnoreCase(eventName)) {
                System.out.println("Available Seats for '" + eventName + "': " + e.getAvailableSeats());
                return;
            }
        }
        throw new EventNotFoundException("Event '" + eventName + "' not found.");
    }

    public void getEventDetails() {
        if (events.isEmpty()) {
            System.out.println("No events created yet.");
            return;
        }
        for (Event e : events) {
            e.displayEventDetails();
        }
    }

    public void getBookingDetails() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }
        for (Booking b : bookings) {
            b.displayBookingDetails();
        }
    }
}

package service;

import bean.*;
import exception.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class BookingSystem {
    private Map<String, Event> events = new TreeMap<>();
    private Map<Integer, Booking> bookings = new HashMap<>();

    public void createEvent(String name, String date, String time, int seats, double price, String type, Venue venue) {
        Event event;
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

        events.putIfAbsent(name.toLowerCase(), event);
    }

    public void bookTickets(String eventName, Set<Customer> customers) throws EventNotFoundException {
        Event event = events.get(eventName.toLowerCase());
        if (event == null) {
            throw new EventNotFoundException("Event '" + eventName + "' not found.");
        }

        Booking booking = new Booking(event, customers);
        bookings.put(booking.getBookingId(), booking);
        System.out.println("✅ Booking successful! Booking ID: " + booking.getBookingId() +
                " | Total Cost: ₹" + booking.getTotalCost());
    }

    public void cancelBooking(int bookingId) throws InvalidBookingIDException {
        Booking b = bookings.get(bookingId);
        if (b == null) {
            throw new InvalidBookingIDException("Booking ID " + bookingId + " not found.");
        }
        b.cancelBooking();
        bookings.remove(bookingId);
        System.out.println("✅ Booking ID " + bookingId + " cancelled successfully.");
    }

    public void getAvailableSeats(String eventName) throws EventNotFoundException {
        Event e = events.get(eventName.toLowerCase());
        if (e == null) {
            throw new EventNotFoundException("Event '" + eventName + "' not found.");
        }
        System.out.println("Available Seats for '" + eventName + "': " + e.getAvailableSeats());
    }

    public void getEventDetails() {
        if (events.isEmpty()) {
            System.out.println("No events created yet.");
            return;
        }

        events.values().stream()
                .sorted(Comparator
                    .comparing(Event::getEventName)
                    .thenComparing(e -> e.venue.getVenueName()))
                .forEach(Event::displayEventDetails);
    }

    public void getBookingDetails() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }
        bookings.values().forEach(Booking::displayBookingDetails);
    }
}

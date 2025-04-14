package dao;

import bean.Booking;
import bean.Event;
import exception.EventNotFoundException;
import exception.InvalidBookingIDException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingSystemService {
    private final List<Event> events = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();
    private int bookingIdCounter = 1;

    public BookingSystemService() {
        events.add(new Event("Concert Night", 50));
        events.add(new Event("Comedy Show", 30));
    }

    public List<Event> getAllEvents() {
        return events;
    }

    public Booking bookTickets(String eventName, int numTickets) throws EventNotFoundException {
        Optional<Event> optionalEvent = events.stream()
                .filter(e -> e.getEventName().equalsIgnoreCase(eventName))
                .findFirst();

        if (optionalEvent.isEmpty()) {
            throw new EventNotFoundException("Event not found: " + eventName);
        }

        Event event = optionalEvent.get();
        if (numTickets > event.getAvailableTickets()) {
            throw new IllegalArgumentException("Not enough tickets. Only " + event.getAvailableTickets() + " available.");
        }

        event.reduceTickets(numTickets);
        Booking booking = new Booking(bookingIdCounter++, eventName, numTickets);
        bookings.add(booking);
        return booking;
    }

    public void cancelBooking(int bookingId) throws InvalidBookingIDException {
        Optional<Booking> optionalBooking = bookings.stream()
                .filter(b -> b.getBookingId() == bookingId)
                .findFirst();

        if (optionalBooking.isEmpty()) {
            throw new InvalidBookingIDException("Booking ID not found: " + bookingId);
        }

        Booking booking = optionalBooking.get();
        events.stream()
                .filter(e -> e.getEventName().equalsIgnoreCase(booking.getEventName()))
                .findFirst()
                .ifPresent(e -> e.reduceTickets(-booking.getNumTickets())); // Add tickets back

        bookings.remove(booking);
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}

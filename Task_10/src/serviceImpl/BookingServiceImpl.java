package serviceImpl;

import entity.*;
import service.IBookingService;

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    private Map<String, Event> eventMap = new HashMap<>();
    private Map<Integer, Booking> bookingMap = new HashMap<>();

    @Override
    public Event createEvent(String name, String date, String time, int seats, double price, String type, Venue venue) {
        Event event = new Event(name, date, time, venue, seats, price, type);
        eventMap.put(name.toLowerCase(), event);
        return event;
    }

    @Override
    public void bookTickets(String eventName, int ticketCount, List<Customer> customers) {
        Event event = eventMap.get(eventName.toLowerCase());
        if (event != null && event.getAvailableSeats() >= ticketCount) {
            event.bookTickets(ticketCount);
            Booking booking = new Booking(customers, event, ticketCount);
            bookingMap.put(booking.getBookingId(), booking);
            System.out.println("Booking successful. ID: " + booking.getBookingId());
        } else {
            System.out.println("Event not found or not enough tickets.");
        }
    }

    @Override
    public void cancelTickets(int bookingId) {
        Booking booking = bookingMap.remove(bookingId);
        if (booking != null) {
            booking.getEvent().cancelTickets(booking.getBookingId());
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("Invalid booking ID.");
        }
    }

    @Override
    public void displayEventDetails() {
        for (Event e : eventMap.values()) {
            e.displayEventDetails();
        }
    }
}

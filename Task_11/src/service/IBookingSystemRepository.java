package service;

import bean.*;
import java.util.List;

public interface IBookingSystemRepository {
    Event createEvent(Event event);
    List<Event> getEventDetails();
    int getAvailableNoOfTickets(String eventName);
    double calculateBookingCost(int numTickets, double pricePerTicket);
    Booking bookTickets(String eventName, int numTickets, List<Customer> customers);
    boolean cancelBooking(int bookingId);
    Booking getBookingDetails(int bookingId);
}

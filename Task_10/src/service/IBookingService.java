package service;

import entity.Customer;
import entity.Event;
import entity.Venue;

import java.util.List;

public interface IBookingService {
    Event createEvent(String name, String date, String time, int seats, double price, String type, Venue venue);
    void bookTickets(String eventName, int ticketCount, List<Customer> customers);
    void cancelTickets(int bookingId);
    void displayEventDetails();
}

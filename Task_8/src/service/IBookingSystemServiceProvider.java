package service;
import bean.Customer;

public interface IBookingSystemServiceProvider {
	
	    double calculateBookingCost(int numTickets, double ticketPrice);
	    void bookTickets(String eventName, int numTickets, Customer[] customers);
	    void cancelBooking(int bookingId);
	    void getBookingDetails(int bookingId);

}
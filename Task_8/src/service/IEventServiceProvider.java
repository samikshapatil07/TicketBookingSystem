package service;
import bean.Event;
import bean.Venue;

public interface IEventServiceProvider {
	
	Event createEvent(String eventName, String date, String time, int totalSeats, double ticketPrice, String eventType, Venue venue);
    Event[] getEventDetails();
    int getAvailableNoOfTickets();

}

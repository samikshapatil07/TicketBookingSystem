package service;

import java.util.ArrayList;
import java.util.List;

import bean.Event;
import bean.Sport;
import bean.Venue;
import bean.Movie;
import bean.Concert;

public class EventServiceProviderImpl implements IEventServiceProvider{
	
	protected static List<Event> events = new ArrayList<>();

    @Override
    public Event createEvent(String eventName, String date, String time, int totalSeats, double ticketPrice, String eventType, Venue venue) {
        Event event = null;

        switch (eventType.toLowerCase()) {
            case "movie":
                event = new Movie(eventName, date, time, venue, totalSeats, ticketPrice, "Movie", "Action", "Shah Rukh", "Deepika");
                break;
            case "concert":
                event = new Concert(eventName, date, time, venue, totalSeats, ticketPrice, "Concert", "Arijit Singh", "Rock");
                break;
            case "sports":
                event = new Sport(eventName, date, time, venue, totalSeats, ticketPrice, "Sports", "Cricket", "India vs Australia");
                break;
            default:
                System.out.println("Invalid event type.");
        }

        if (event != null) {
            events.add(event);
            System.out.println("Event created successfully!");
        }

        return event;
    }

    @Override
    public Event[] getEventDetails() {
        return events.toArray(new Event[0]);
    }

    @Override
    public int getAvailableNoOfTickets() {
        int totalAvailable = 0;
        for (Event e : events) {
            totalAvailable += e.getAvailableSeats();
        }
        return totalAvailable;
    }
	

	    


}

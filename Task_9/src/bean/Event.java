package bean;

public class Event {
    private String eventName;
    private int availableTickets;

    public Event(String eventName, int availableTickets) {
        this.eventName = eventName;
        this.availableTickets = availableTickets;
    }

    public String getEventName() {
        return eventName;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void reduceTickets(int count) {
        this.availableTickets -= count;
    }

    public void displayEventDetails() {
        System.out.println("Event: " + eventName + ", Tickets Left: " + availableTickets);
    }
}


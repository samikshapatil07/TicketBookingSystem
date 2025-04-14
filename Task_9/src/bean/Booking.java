package bean;

public class Booking {
    private int bookingId;
    private String eventName;
    private int numTickets;

    public Booking(int bookingId, String eventName, int numTickets) {
        this.bookingId = bookingId;
        this.eventName = eventName;
        this.numTickets = numTickets;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getEventName() {
        return eventName;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId + ", Event: " + eventName + ", Tickets: " + numTickets);
    }
}

package bean;
import java.time.LocalDateTime;
import exception.InvalidBookingIDException;
import exception.EventNotFoundException;

public class Booking {
	
	    private static int bookingCounter = 1000;

	    private int bookingId;
	    private Customer[] customers;
	    private Event event;
	    private int numTickets;
	    private double totalCost;
	    private LocalDateTime bookingDate;

	    public Booking() {
	        this.bookingId = bookingCounter++;
	        this.bookingDate = LocalDateTime.now();
	    }

	    public Booking(Customer[] customers, Event event, int numTickets, double totalCost) {
	        this();
	        this.customers = customers;
	        this.event = event;
	        this.numTickets = numTickets;
	        this.totalCost = totalCost;
	    }
	    
	    public Booking(Customer[] customers, Event event, int numTickets, double totalCost, LocalDateTime bookingDate) {
	        this.bookingId = ++Booking.bookingCounter;
	        this.customers = customers;
	        this.event = event;
	        this.numTickets = numTickets;
	        this.totalCost = totalCost;
	        this.bookingDate = bookingDate;
	    }


	    public int getBookingId() {
	        return bookingId;
	    }

	    public Customer[] getCustomers() {
	        return customers;
	    }

	    public Event getEvent() {
	        return event;
	    }

	    public int getNumTickets() {
	        return numTickets;
	    }

	    public double getTotalCost() {
	        return totalCost;
	    }

	    public LocalDateTime getBookingDate() {
	        return bookingDate;
	    }

	    public void setCustomers(Customer[] customers) {
	        this.customers = customers;
	    }

	    public void setEvent(Event event) {
	        this.event = event;
	    }

	    public void setNumTickets(int numTickets) {
	        this.numTickets = numTickets;
	    }

	    public void setTotalCost(double totalCost) {
	        this.totalCost = totalCost;
	    }

	    public void displayBookingDetails() {
	        System.out.println("Booking ID: " + bookingId);
	        System.out.println("Booking Date: " + bookingDate);
	        System.out.println("Number of Tickets: " + numTickets);
	        System.out.println("Total Cost: ₹" + totalCost);
	        System.out.println("Event Booked:");
	        event.displayEventDetails();
	        System.out.println("Customer Details:");
	        for (Customer customer : customers) {
	            customer.displayCustomerDetails();
	            System.out.println("---");
	        }
	    }
//cancelticket
		public void cancelBooking() {
			Booking target = null;
		    for (Booking b : bookings) {
		        if (b.getBookingId() == bookingId) {
		            target = b;
		            break;
		        }
		    }

		    if (target == null) {
		        throw new InvalidBookingIDException("Booking ID " + bookingId + " not found.");
		    }

		    target.cancelBooking();
		    bookings.remove(target);
		    System.out.println("✅ Booking ID " + bookingId + " cancelled successfully.");			
		}
		//booktickets
		public void bookTickets(String eventName, Customer[] customers) throws EventNotFoundException {
		    Event found = null;
		    for (Event e : events) {
		        if (e.getEventName().equalsIgnoreCase(eventName)) {
		            found = e;
		            break;
		        }
		    }

		    if (found == null) {
		        throw new EventNotFoundException("Event '" + eventName + "' not found.");
		    }

		    Booking booking = new Booking(found, customers);
		    bookings.add(booking);
		    System.out.println("✅ Booking successful! Booking ID: " + booking.getBookingId() + " | Total Cost: ₹" + booking.getTotalCost());
		}

}


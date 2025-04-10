package app;
	import java.util.Scanner;

	import bean.Customer;
	import bean.Event;
	import bean.Venue;
	import service.BookingSystemServiceProviderImpl;

	public class TicketBookingSystem {
		
		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        BookingSystemServiceProviderImpl system = new BookingSystemServiceProviderImpl();

	        while (true) {
	            System.out.println("\n----- Ticket Booking System Menu -----");
	            System.out.println("1. Create Event");
	            System.out.println("2. Book Tickets");
	            System.out.println("3. Cancel Tickets");
	            System.out.println("4. Get Available Seats");
	            System.out.println("5. Get Event Details");
	            System.out.println("6. Get Booking Details");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {

	                case 1:
	                    System.out.print("Enter event name: ");
	                    String eventName = sc.nextLine();

	                    System.out.print("Enter event date (YYYY-MM-DD): ");
	                    String date = sc.nextLine();

	                    System.out.print("Enter event time (HH:MM): ");
	                    String time = sc.nextLine();

	                    System.out.print("Enter venue name: ");
	                    String venueName = sc.nextLine();

	                    System.out.print("Enter venue address: ");
	                    String address = sc.nextLine();

	                    System.out.print("Enter total seats: ");
	                    int totalSeats = sc.nextInt();

	                    System.out.print("Enter ticket price: ");
	                    double ticketPrice = sc.nextDouble();

	                    sc.nextLine(); // consume newline
	                    System.out.print("Enter event type (Movie/Sports/Concert): ");
	                    String eventType = sc.nextLine();

	                    Venue venue = new Venue(venueName, address);
	                    system.createEvent(eventName, date, time, totalSeats, ticketPrice, eventType, venue);
	                    break;

	                case 2:
	                    System.out.print("Enter event name to book: ");
	                    String bookEvent = sc.nextLine();

	                    System.out.print("Enter number of tickets: ");
	                    int numTickets = sc.nextInt();
	                    sc.nextLine(); // consume newline

	                    Customer[] customers = new Customer[numTickets];
	                    for (int i = 0; i < numTickets; i++) {
	                        System.out.println("Enter details for Customer " + (i + 1));
	                        System.out.print("Name: ");
	                        String name = sc.nextLine();
	                        System.out.print("Email: ");
	                        String email = sc.nextLine();
	                        System.out.print("Phone: ");
	                        String phone = sc.nextLine();
	                        customers[i] = new Customer(name, email, phone);
	                    }

	                    system.bookTickets(bookEvent, numTickets, customers);
	                    break;

	                case 3:
	                    System.out.print("Enter booking ID to cancel: ");
	                    int bookingId = sc.nextInt();
	                    system.cancelBooking(bookingId);
	                    break;

	                case 4:
	                    int availableSeats = system.getAvailableNoOfTickets();
	                    System.out.println("Total Available Tickets: " + availableSeats);
	                    break;

	                case 5:
	                    bean.Event[] events = system.getEventDetails();
	                    if (events.length == 0) {
	                        System.out.println("No events found.");
	                    } else {
	                        for (Event e : events) {
	                            e.displayEventDetails();
	                        }
	                    }
	                    break;

	                case 6:
	                    System.out.print("Enter booking ID: ");
	                    int id = sc.nextInt();
	                    system.getBookingDetails(id);
	                    break;

	                case 7:
	                    System.out.println("Exiting Ticket Booking System. Thank you!");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	}

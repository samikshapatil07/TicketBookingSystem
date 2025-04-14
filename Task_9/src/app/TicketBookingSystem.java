package app;

import dao.BookingSystemService;
import bean.Booking;
import bean.Event;
import exception.EventNotFoundException;
import exception.InvalidBookingIDException;

import java.util.List;
import java.util.Scanner;

public class TicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingSystemService service = new BookingSystemService();

        while (true) {
            displayMenu();
            try {
				try {
				    int choice = Integer.parseInt(scanner.nextLine());
				    switch (choice) {
				        case 1 -> handleBooking(scanner, service);
				        case 2 -> handleCancellation(scanner, service);
				        case 3 -> showEvents(service.getAllEvents());
				        case 4 -> showBookings(service.getAllBookings());
				        case 5 -> {
				            System.out.println("Exiting system. Goodbye!");
				            return;
				        }
				        default -> System.out.println("Invalid option.");
				    }
				} catch (EventNotFoundException | InvalidBookingIDException e) {
				    System.out.println(e.getMessage());
				} catch (IllegalArgumentException e) {
				    System.out.println(e.getMessage());
				} catch (Exception e) {
				    System.out.println("Unexpected Error: " + e.getMessage());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Ticket Booking System ---");
        System.out.println("1. Book Tickets");
        System.out.println("2. Cancel Booking");
        System.out.println("3. Show Events");
        System.out.println("4. Show All Bookings");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private static void handleBooking(Scanner scanner, BookingSystemService service) throws EventNotFoundException {
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();

        System.out.print("Enter number of tickets: ");
        int numTickets = Integer.parseInt(scanner.nextLine());

        Booking booking = service.bookTickets(eventName, numTickets);
        System.out.println("Booking successful!");
        booking.displayBooking();
    }

    private static void handleCancellation(Scanner scanner, BookingSystemService service) throws InvalidBookingIDException {
        System.out.print("Enter booking ID: ");
        int bookingId = Integer.parseInt(scanner.nextLine());

        service.cancelBooking(bookingId);
        System.out.println("Booking cancelled successfully.");
    }

    private static void showEvents(List<Event> events) {
        System.out.println("\nAvailable Events:");
        events.forEach(Event::displayEventDetails);
    }

    private static void showBookings(List<Booking> bookings) {
        System.out.println("\nAll Bookings:");
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            bookings.forEach(Booking::displayBooking);
        }
    }
}

package client;

import entity.Event;
import entity.Customer;
import entity.Venue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Booking {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Venue venue = new Venue("Stadium Arena", "123 Main Street");

        Event event = new Event("Rock Concert", LocalDate.of(2025, 6, 15), LocalTime.of(19, 30), venue.getVenueName(), 100, 50.0, "Concert");

        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Your Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Your Phone Number: ");
        String phone = sc.nextLine();
        
        Customer customer = new Customer(name, email, phone);
        
        // Display details
        venue.displayVenueDetails();
        event.displayEventDetails();
        customer.displayCustomerDetails();

        // Book tickets
        System.out.print("\nEnter Number of Tickets to Book: ");
        int numTickets = sc.nextInt();
        event.bookTickets(numTickets);
        event.displayEventDetails();
        
        // Canceling Tickets
        System.out.print("\nEnter number of tickets to cancel: ");
        int cancelTickets = sc.nextInt();
        event.cancelBooking(cancelTickets);
        event.displayEventDetails();

        // Display revenue
        System.out.println("\nTotal Revenue Generated: Rs." + event.calculateTotalRevenue());

        sc.close();
    }

}

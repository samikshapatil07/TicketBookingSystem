package app;
import bean.*;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketBookingSystem {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        Event movie = new Movie("Avengers: Endgame", LocalDate.of(2025, 5, 10), LocalTime.of(18, 30),
                                "Cineplex", 100, 15.0, "Action", "Robert Downey Jr.", "Scarlett Johansson");

        Event concert = new Concert("Coldplay Live", LocalDate.of(2025, 6, 20), LocalTime.of(20, 00),
                                    "Stadium X", 200, 50.0, "Coldplay", "Rock");

        Event sports = new Sports("Football Match", LocalDate.of(2025, 7, 5), LocalTime.of(19, 00),
                                  "National Stadium", 150, 30.0, "Football", "Brazil vs Argentina");

        while (true) {
            System.out.println("\nTICKET BOOKING SYSTEM");
            System.out.println("1️.View Events");
            System.out.println("2️.Book Tickets");
            System.out.println("3️.Cancel Tickets");
            System.out.println("4️.Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                movie.display_event_details();
                concert.display_event_details();
                sports.display_event_details();
            } else if (choice == 2) {
                System.out.print("Enter event type (Movie/Concert/Sports): ");
                scanner.nextLine();
                String type = scanner.nextLine();
                System.out.print("Enter number of tickets: ");
                int numTickets = scanner.nextInt();

                if (type.equalsIgnoreCase("Movie")) movie.bookTickets(numTickets);
                else if (type.equalsIgnoreCase("Concert")) concert.bookTickets(numTickets);
                else if (type.equalsIgnoreCase("Sports")) sports.bookTickets(numTickets);
            } else if (choice == 3) {
                System.out.print("Enter number of tickets to cancel: ");
                int numTickets = scanner.nextInt();
                movie.cancelBooking(numTickets);
            } else if (choice == 4) {
                System.out.println("Exiting system...");
                break;
            }
        }
        scanner.close();
	}

}

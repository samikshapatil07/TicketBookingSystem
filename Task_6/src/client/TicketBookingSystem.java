package client;
import java.util.ArrayList;
import java.util.Scanner;

import entity.BookingSystem;
import entity.Concert;
import entity.Event;
import entity.Movie;
import entity.Sports;

public class TicketBookingSystem extends BookingSystem{

	private final ArrayList<Event> events = new ArrayList<>();
	static TicketBookingSystem system = new TicketBookingSystem();
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        String opt;
        do {
            handleMenu();
            System.out.println("Press 'y' to continue:");
            opt = scan.next();
        } while (opt.charAt(0) == 'Y' || opt.charAt(0) == 'y');

        System.out.println("Thank you for using the system!");
    }
    
    public static void handleMenu() {
        System.out.println("\n--- Ticket Booking System Menu ---");
        System.out.println("1. Create Event");
        System.out.println("2. Book Tickets");
        System.out.println("3. Cancel Tickets");
        System.out.println("4. Get Available Seats");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        int menuOpt = scan.nextInt();
        scan.nextLine(); 
        switch (menuOpt) {
            case 1:
                system.createEvent();
                break;
            case 2:
                system.bookTickets();
                break;
            case 3:
                system.cancelTickets();
                break;
            case 4:
                system.getAvailableSeats();
            case 5:
                system.exit();
                break;
            default:
                System.out.println("Invalid menu option.");
        }
    }

	@Override
    public void createEvent() {
        System.out.println("Enter event type (Movie, Concert, Sports): ");
        String type = scan.nextLine();

        System.out.println("Event Name: ");
        String name = scan.nextLine();
        System.out.println("Date (YYYY-MM-DD): ");
        String date = scan.nextLine();
        System.out.println("Time (HH:MM): ");
        String time = scan.nextLine();
        System.out.println("Venue Name: ");
        String venue = scan.nextLine();
        System.out.println("Total Seats: ");
        int seats = scan.nextInt();
        System.out.println("Ticket Price: ");
        double price = scan.nextDouble();
        scan.nextLine(); 
        
        switch (type.toLowerCase()) {
            case "movie":
                System.out.println("Genre: ");
                String genre = scan.nextLine();
                System.out.println("Actor Name: ");
                String actor = scan.nextLine();
                System.out.println("Actress Name: ");
                String actress = scan.nextLine();
                events.add(new Movie(name, date, time, venue, seats, price, genre, actor, actress));
                break;
            case "concert":
                System.out.println("Artist: ");
                String artist = scan.nextLine();
                System.out.println("Type: ");
                String concertType = scan.nextLine();
                events.add(new Concert(name, date, time, venue, seats, price, artist, concertType));
                break;
            case "sports":
                System.out.println("Sport Name: ");
                String sport = scan.nextLine();
                System.out.println("Teams (Team1 vs Team2): ");
                String teams = scan.nextLine();
                events.add(new Sports(name, date, time, venue, seats, price, sport, teams));
                break;
            default:
                System.out.println("Invalid event type.");
        }
    }

    @Override
    public void bookTickets() {
        displayAllEvents();
        System.out.println("Select event index to book tickets: ");
        int index = scan.nextInt();
        System.out.println("Enter number of tickets: ");
        int num = scan.nextInt();
        events.get(index).bookTickets(num);
    }

    @Override
    public void cancelTickets() {
        displayAllEvents();
        System.out.println("Select event index to cancel tickets: ");
        int index = scan.nextInt();
        System.out.println("Enter number of tickets: ");
        int num = scan.nextInt();
        events.get(index).cancelTickets(num);
    }

    @Override
    public void getAvailableSeats() {
        displayAllEvents();
    }

    public void displayAllEvents() {
        for (int i = 0; i < events.size(); i++) {
            System.out.println("[" + i + "]");
            events.get(i).displayEventDetails();
            System.out.println("---------------");
        }
    }
    
    public void exit() {
		System.out.println("Exiting the system.");
	}
}

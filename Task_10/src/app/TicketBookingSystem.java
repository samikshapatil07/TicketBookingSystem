package app;

import bean.*;
import service.BookingSystem;
import exception.*;

import java.util.*;

public class TicketBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingSystem system = new BookingSystem();
        boolean running = true;

        while (running) {
            System.out.println("\n----------------------------------------------------");
            System.out.println("          Welcome to the Ticket Booking System");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Create Event");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Tickets");
            System.out.println("4. Get Available Seats");
            System.out.println("5. Get Event Details");
            System.out.println("6. Get Booking Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter Event Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Event Date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        System.out.print("Enter Event Time (HH:MM): ");
                        String time = sc.nextLine();
                        System.out.print("Enter Total Seats: ");
                        int seats = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Ticket Price: ");
                        double price = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter Event Type (movie/concert/sport): ");
                        String type = sc.nextLine();
                        System.out.print("Enter Venue Name: ");
                        String vName = sc.nextLine();
                        System.out.print("Enter Venue Address: ");
                        String vAddr = sc.nextLine();
                        Venue venue = new Venue(vName, vAddr);
                        system.createEvent(name, date, time, seats, price, type, venue);
                        break;

                    case 2:
                        System.out.print("Enter Event Name to Book: ");
                        String eName = sc.nextLine();
                        System.out.print("Enter Number of Tickets: ");
                        int num = Integer.parseInt(sc.nextLine());
                        Set<Customer> customers = new HashSet<>();
                        for (int i = 0; i < num; i++) {
                            System.out.println("Customer " + (i + 1) + ":");
                            System.out.print("Name: ");
                            String cname = sc.nextLine();
                            System.out.print("Email: ");
                            String email = sc.nextLine();
                            System.out.print("Phone: ");
                            String phone = sc.nextLine();
                            customers.add(new Customer(cname, email, phone));
                        }
                        system.bookTickets(eName, customers);
                        break;

                    case 3:
                        System.out.print("Enter Booking ID to Cancel: ");
                        int cancelId = Integer.parseInt(sc.nextLine());
                        system.cancelBooking(cancelId);
                        break;

                    case 4:
                        System.out.print("Enter Event Name to Check Seats: ");
                        String evName = sc.nextLine();
                        system.getAvailableSeats(evName);
                        break;

                    case 5:
                        system.getEventDetails();
                        break;

                    case 6:
                        system.getBookingDetails();
                        break;

                    case 7:
                        System.out.println("\n👋 Exiting Ticket Booking System. Thank you!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (EventNotFoundException | InvalidBookingIDException e) {
                System.out.println("❌ " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("⚠️ Null input encountered. Please check your fields.");
            } catch (Exception e) {
                System.out.println("⚠️ Unexpected error: " + e.getMessage());
            }
        }
        sc.close();
    }
}

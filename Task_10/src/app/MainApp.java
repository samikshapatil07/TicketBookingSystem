package app;

import entity.Customer;
import entity.Venue;
import serviceImpl.BookingServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        BookingServiceImpl system = new BookingServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Event\n2. Book Tickets\n3. Cancel Tickets\n4. Show Events\n5. Exit");
            System.out.print("Enter option: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Event Name: ");
                    String name = sc.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Time (HH:MM): ");
                    String time = sc.nextLine();
                    System.out.print("Total Seats: ");
                    int seats = sc.nextInt();
                    System.out.print("Ticket Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();  
                    System.out.print("Type (Movie/Sports/Concert): ");
                    String type = sc.nextLine();
                    System.out.print("Venue Name: ");
                    String vname = sc.nextLine();
                    System.out.print("Venue Address: ");
                    String address = sc.nextLine();

                    Venue venue = new Venue(vname, address);
                    system.createEvent(name, date, time, seats, price, type, venue);
                    break;

                case 2:
                    System.out.print("Enter Event Name: ");
                    String ename = sc.nextLine();
                    System.out.print("Number of Tickets: ");
                    int tickets = sc.nextInt();
                    sc.nextLine();
                    List<Customer> customers = new ArrayList<>();
                    for (int i = 0; i < tickets; i++) {
                        System.out.print("Customer " + (i + 1) + " Name: ");
                        String cname = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Phone: ");
                        String phone = sc.nextLine();
                        customers.add(new Customer(cname, email, phone));
                    }
                    system.bookTickets(ename, tickets, customers);
                    break;

                case 3:
                    System.out.print("Enter Booking ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    system.cancelTickets(id);
                    break;

                case 4:
                    system.displayEventDetails();
                    break;

                case 5:
                    System.out.println("Exiting.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

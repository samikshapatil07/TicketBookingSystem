package ticketbooking;
import java.util.Scanner;

public class TicketBookingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of available tickets: ");
        int availableTickets = scanner.nextInt();

        System.out.print("Enter number of tickets to book: ");
        int noOfBookingTicket = scanner.nextInt();

        if (availableTickets >= noOfBookingTicket) {
            int remainingTickets = availableTickets - noOfBookingTicket;
            System.out.println("Booking Successful!");
            System.out.println("Remaining Tickets: " + remainingTickets);
        } else {
            System.out.println("Ticket Unavailable! Not enough tickets to fulfill your booking.");
        }

        scanner.close();
    }
}

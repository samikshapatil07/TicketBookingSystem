package ticketbookingested;

import java.util.Scanner;

public class TicketBookingNested {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Ticket Categories:");
        System.out.println("1. Silver - ₹300");
        System.out.println("2. Gold   - ₹500");
        System.out.println("3. Diamond - ₹800");

        System.out.print("Enter ticket category (Silver/Gold/Diamond): ");
        String ticketType = scanner.nextLine().toLowerCase();

        System.out.print("Enter number of tickets: ");
        int numberOfTickets = scanner.nextInt();

        int basePrice = 0;

        if (numberOfTickets > 0) {
            if (ticketType.equals("silver")) {
                basePrice = 300;
            } else if (ticketType.equals("gold")) {
                basePrice = 500;
            } else if (ticketType.equals("diamond")) {
                basePrice = 800;
            } else {
                System.out.println("Invalid ticket category selected!");
                return;
            }

            int totalCost = basePrice * numberOfTickets;
            System.out.println("Total cost for " + numberOfTickets + " " + ticketType + " ticket(s): ₹" + totalCost);
        } else {
            System.out.println("Invalid number of tickets.");
        }

        scanner.close();
    }
}


package entity;

import java.util.Scanner;

public class TicketBookingWithLoop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice;

        System.out.println("Welcome to the Ticket Booking System!");
        System.out.println("Available Ticket Categories:");
        System.out.println("1. Silver - ₹300");
        System.out.println("2. Gold   - ₹500");
        System.out.println("3. Diamond - ₹800");

        while (true) {
            System.out.print("\nEnter ticket category (Silver/Gold/Diamond) or type 'exit' to quit: ");
            userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("exit")) {
                System.out.println("Thank you for using the Ticket Booking System!");
                break;
            }

            int basePrice;

            if (userChoice.equals("silver")) {
                basePrice = 300;
            } else if (userChoice.equals("gold")) {
                basePrice = 500;
            } else if (userChoice.equals("diamond")) {
                basePrice = 800;
            } else {
                System.out.println("Invalid ticket category. Please try again.");
                continue; 
            }

            System.out.print("Enter number of tickets to book: ");
            int numberOfTickets;

            try {
                numberOfTickets = Integer.parseInt(scanner.nextLine());

                if (numberOfTickets <= 0) {
                    System.out.println("Number of tickets must be greater than 0.");
                    continue;
                }

                int totalCost = basePrice * numberOfTickets;
                System.out.println("Booking Successful!");
                System.out.println("Total cost for " + numberOfTickets + " " + userChoice + " ticket(s): ₹" + totalCost);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input for number of tickets. Please enter a number.");
            }
        }

        scanner.close();
    }
}

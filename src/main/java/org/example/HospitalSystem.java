package org.example;

import java.util.*;

public class HospitalSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Setup objects we need
        // patient & service maybe?

        while (true) {
            // Main Menu
            System.out.println("\n=== Hospital Billing System ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Service");
            System.out.println("3. Compute Bill");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // --- Register Patient ---
                    break;

                case 2:
                    // --- Add Service ---

                    break;

                case 3:
                    // --- Compute Bill ---

                    break;

                case 4:
                    // --- Exit ---
                    System.out.println("Thank you for using the Hospital Billing System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
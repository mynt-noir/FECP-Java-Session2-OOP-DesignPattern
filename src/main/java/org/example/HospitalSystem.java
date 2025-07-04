package org.example;

import java.util.*;

public class HospitalSystem {

    // findServicePrice Handler
    private static Object findServicePrice(ArrayList<Service> services, String serviceName) {
        for (Service service : services) {
            if (service.getServiceName().equals(serviceName)) {
                return service.getServicePrice();
            }
        }
        return null;
    }

    // findPatient Handler
    private static Object findPatient(ArrayList<Patient> patients, String patientId) {
        // get name or get bill
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                return patient.getName();
            }
        }
        return null;
    }

    private static ArrayList<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Service> services = new ArrayList<>();
        services.add(new Service("X-Ray", 500));
        services.add(new Service("Surgery", 12000));
        services.add(new Service("Consultation", 700));



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
                    System.out.println("\n--- Register Patient ---");
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient ID: ");
                    String patientId = scanner.nextLine();

                    Service selectedService = null;
                    while (selectedService == null) {
                        System.out.println("\nAvailable Services:");
                        for (int i = 0; i < services.size(); i++) {
                            Service s = services.get(i);
                            System.out.println((i + 1) + ". " + s.getServiceName() + " (Price: " + s.getServicePrice() + ")");
                        }
                        System.out.print("Select a service by number: ");
                        int serviceChoiceNum = -1;
                        try {
                            serviceChoiceNum = scanner.nextInt();
                            scanner.nextLine();
                            if (serviceChoiceNum > 0 && serviceChoiceNum <= services.size()) {
                                selectedService = services.get(serviceChoiceNum - 1);
                            } else {
                                System.out.println("Invalid service number. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine(); // Clear invalid input
                        }
                    }

                    Patient newPatient = new Patient(patientName, patientId, new Service[]{selectedService});
                    patients.add(newPatient); // Add patient to the list

                    System.out.println("\nPatient registered: " + patientName + " (ID: " + patientId + ")");
                    System.out.println("Service availed: " + selectedService.getServiceName());
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
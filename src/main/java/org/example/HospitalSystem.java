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

    // findPatient Handler (returns the patient object)
    private static Patient findPatientObject(ArrayList<Patient> patients, String patientId) {
        // get name or get bill
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                return patient;
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

                    // create a new patient without any initial services.

                    Patient newPatient = new Patient(patientName, patientId, services);

                    patients.add(newPatient); // Add patient to the list

                    System.out.println("\nPatient registered: " + patientName + " (ID: " + patientId + ")");
                    // remove service availed, moved to case 2.
                    break;

                case 2:
                    System.out.println("\n--- Add Service ---");
                    System.out.print("Enter patient ID to add service to: ");
                    patientId = scanner.nextLine();

                    Patient patientToUpdate = findPatientObject(patients, patientId);

                    if (patientToUpdate != null) {
                        Service selectedService = null;
                        while (selectedService == null) {
                            System.out.println("\nAvailable Services:");
                            for (int i = 0; i < services.size(); i++) {
                                Service s = services.get(i);
                                System.out.println((i + 1) + ". " + s.getServiceName() + " (Price: " + String.format("%.2f", s.getServicePrice()) + ")");
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
                                scanner.nextLine();
                            }
                        }
                        patientToUpdate.addService(selectedService);
                        System.out.println("Service '" + selectedService.getServiceName() + "' added to patient '" + patientToUpdate.getName() + "'.");
                    } else {
                        System.out.println("Patient with ID '" + patientId + "' not found.");
                    }
                    break;

                case 3:
                    // --- Compute Bill ---

                    System.out.println("\n--- Compute Bill ---");
                    System.out.print("Enter patient ID to compute bill for: ");
                    patientId = scanner.nextLine();
                    double finalBill = 0;

                    Patient patientForBill = findPatientObject(patients, patientId); // Corrected to findPatient

                    if (patientForBill != null) {
                        System.out.println("\n--- Bill for Patient: " + patientForBill.getName() + " (ID: " + patientForBill.getId() + ") ---");
                        patientForBill.printServices();

                        double billNoDiscount = patientForBill.getTotalBill();
                        System.out.printf("Total Bill (without discount): %.2f\n", billNoDiscount); //maybe we have to delete this later once we add discounted price/

                        // Get insurance type
                        String insuranceType = "";
                        while (true) {
                            System.out.print("Enter insurance type (HMO, Senior, Cash): ");
                            insuranceType = scanner.nextLine().trim().toLowerCase(); // Read input and normalize
                            if (insuranceType.equals("hmo") || insuranceType.equals("senior") || insuranceType.equals("cash")) {
                                PaymentType paymentType = PaymentTypeFactory.getService(type) ;
                                finalBill = paymentType.getCost(billNoDiscount);
                                System.out.println("Invalid insurance type. Please enter 'HMO', 'Senior', or 'Cash'.");
                            }
                        }

                        // Empty switch case for insurance types
                        switch (insuranceType) {
                            case "hmo":
                                // Logic for HMO discount will go here
                                System.out.println("Applying HMO discount...");
                                break;
                            case "senior":
                                // Logic for Senior discount will go here
                                System.out.println("Applying Senior discount...");
                                break;
                            case "cash":
                                // Logic for Cash payment (no discount) will go here
                                System.out.println("Processing Cash payment...");
                                break;
                            default:
                                // This case should ideally not be reached due to the while loop validation
                                System.out.println("An unexpected error occurred with insurance type.");
                                break;
                        }
                        // The final bill calculation based on the discount will follow here later
                        System.out.printf("Final Bill: %.2f\n", finalBill); // This will be added later
                    } else {
                        System.out.println("Patient with ID '" + patientId + "' not found.");

                    }
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
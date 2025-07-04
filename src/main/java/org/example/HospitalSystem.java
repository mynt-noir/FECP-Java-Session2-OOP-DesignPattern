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

                    // create a new patient without any initial services.

                    Patient newPatient = new Patient(patientName, patientId, services);

                    patients.add(newPatient); // Add patient to the list

                    System.out.println("\nPatient registered: " + patientName + " (ID: " + patientId + ")");
                    // remove service availed, moved to case 2.
                    break;

                case 2:
                    // --- Add Service ---
                    System.out.print("Patient ID: ");
                    String id = scanner.nextLine();
                    boolean isPatientIdExisting = patients.stream().anyMatch(patient -> patient.getId().equals(id));
                    if(!isPatientIdExisting){
                        System.out.println("Patient ID does not exist");
                        return;
                    }
                    System.out.print("Select service to add: ");
                    String serviceToAdd = scanner.nextLine();
                    //get price of service
                    HospitalService service = ServiceFactory.getService(serviceToAdd);
                    double serviceCost = service != null ? service.getCost() : 0;
                    if(serviceCost != 0){
                        System.out.println("Service added to patient bill.");
                    }
                    //add serviceCost to total cost
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
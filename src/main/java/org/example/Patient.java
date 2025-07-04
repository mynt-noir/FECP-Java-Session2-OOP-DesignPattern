package org.example;

import java.util.*; // Keep both util imports for List and ArrayList

public class Patient {
    private String name;
    private String id;

    private List<Service> services = new ArrayList<>(); 

    private ArrayList<Service> services;

    public Patient (String name, String id, ArrayList<Service> services) {
        this.name = name;
        this.id = id;
    }


    public Patient (String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public void addService(Service service) {
        this.services.add(service);
    }


    // New method: printServices
    public void printServices() {
        if (services.isEmpty()) {
            System.out.println("    No services availed.");
        } else {
            System.out.println("    Availed Services:");
            for (Service service : services) {
                // Assuming Service class has getServiceName() and getServicePrice()
                System.out.printf("    - %s (Price: %.2f)\n", service.getServiceName(), service.getServicePrice());
            }
        }
    }

    // You might also want a method to calculate total bill, if not already present
    public double getTotalBill() {
        double total = 0;
        for (Service service : services) {
            total += service.getServicePrice();
        }
        return total;
    }


}


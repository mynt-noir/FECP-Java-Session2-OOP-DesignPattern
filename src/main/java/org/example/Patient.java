package org.example;

import java.util.*;

public class Patient {
    private String name;
    private String id;
    private ArrayList<Service> services;

    public Patient (String name, String id, ArrayList<Service> services) {
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

}

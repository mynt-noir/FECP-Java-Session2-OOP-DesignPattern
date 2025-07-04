package org.example;

public class Patient {
    private String name;
    private String id;
    private Service[] services;

    private Patient (String name, String id, Service[] services) {
        this.name = name;
        this.id = id;
        this.services = services;
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

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }
}

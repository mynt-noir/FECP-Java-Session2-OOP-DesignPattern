package org.example;

import java.util.*;
import java.util.List;

public class Patient {
    private String name;
    private String id;
    private List<Service> services = new ArrayList<>();

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

    public void addService(Service service) {
        this.services.add(service);
    }

    //redo print services.
}

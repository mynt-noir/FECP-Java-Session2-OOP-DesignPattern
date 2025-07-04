package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HospitalSystemTest {

    private ArrayList<Patient> patients;
    private ArrayList<Service> services;

    @BeforeEach
    void setUp() {
        patients = new ArrayList<>();
        services = new ArrayList<>();
        services.add(new Service("X-Ray", 500));
        services.add(new Service("Surgery", 12000));
        services.add(new Service("Consultation", 700));
    }

    @AfterEach
    void tearDown() {
        patients.clear();
        services.clear();
    }

    @Test
    void registerPatientValid() {
        Patient patient = new Patient("Alice", "P101");

        assertEquals("P101", patient.getId());
        assertEquals("Alice", patient.getName());
        assertNull(patient.getServices());
    }

    @Test
    void addServiceValidService() {
        Patient patient = new Patient("Bob", "P102");


    }


    @Test
    void addServiceInvalidService() {
        Patient patient = new Patient("Charlie", "P103");


    }

    @Test
    void computeBillHmo() {



    }

    @Test
    void computeBillCash() {

    }

    @Test
    void computeBillSenior() {

    }

    @Test
    void validateServiceCost() {
//        s.getServiceName.equals("X-Ray")
//                assert.equals(s.getServicePrice, 500);
    }

}
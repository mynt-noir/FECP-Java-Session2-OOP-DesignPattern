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

    }


    @Test
    void addServiceInvalidService() {

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
        Service xRay = services.getFirst();
        assertEquals("X-Ray", xRay.getServiceName());
        assertEquals(500, xRay.getServicePrice(), 0.001);

        Service surgery = services.get(1);
        assertEquals("Surgery", surgery.getServiceName());
        assertEquals(12000, surgery.getServicePrice(), 0.001);

        Service consultation = services.get(2);
        assertEquals("Consultation", consultation.getServiceName());
        assertEquals(700, consultation.getServicePrice(), 0.001);

        Service newTestService = new Service("Blood Test", 250);
        assertEquals("Blood Test", newTestService.getServiceName());
        assertEquals(250, newTestService.getServicePrice(), 0.001);
    }

}
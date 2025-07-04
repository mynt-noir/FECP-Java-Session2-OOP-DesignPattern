package org.example;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalSystemTest {

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
    public void registerPatientValidName() {

    }

    @Test
    public void registerPatientValidId() {

    }

    @Test
    public void registerPatientInvalidName() {

    }

    @Test
    void registerPatientInvalidId() {

    }

    @Test
    public void addServiceValidService() {

        patients.add;
    void addServiceValidService() {
        Patient patient = new Patient("Bob", "P102");
        patient.addService(new Service("X-Ray", 500));


    }


    @Test
    public void addServiceInvalidService() {

    void addServiceInvalidService() {
        Patient patient = new Patient("Charlie", "P103");
        patient.addService(new Service("Invalid Service", 500));
    }

    @Test
    void computeBillHmo() {
        Patient patient = new Patient("Delta", "P104");



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
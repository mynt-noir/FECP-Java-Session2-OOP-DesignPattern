package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void registerPatientValid() {
        Patient patient = new Patient("Alice", "P101");

        assertEquals("P101", patient.getId());
        assertEquals("Alice", patient.getName());
        assertEquals(0, patient.getServices().size());
    }


    @Test
    public void addServiceValidService() {
        Patient patient = new Patient("Bob", "P102");
        patient.addService(new Service("X-Ray", 500));
    }

    @Test
    public void computeBillHmo() {
        Patient patient = new Patient("Bob", "P102");
        patient.addService(new Service("X-Ray", 500));
        double expected = 500 * 0.60;
        PaymentType paymentType = PaymentTypeFactory.getService("hmo");
        assertNotNull(paymentType);
        assertEquals(expected, paymentType.getCost(patient.getTotalBill()), 0.001);
    }

    @Test
    public void computeBillCash() {
        Patient patient = new Patient("Bob", "P102");
        patient.addService(new Service("X-Ray", 500));
        double expected = 500;
        PaymentType paymentType = PaymentTypeFactory.getService("cash");
        assertNotNull(paymentType);
        assertEquals(expected, paymentType.getCost(patient.getTotalBill()), 0.001);
    }

    @Test
    public void computeBillSenior() {
        Patient patient = new Patient("Bob", "P102");
        patient.addService(new Service("X-Ray", 500));
        double expected = 500 * 0.80;
        PaymentType paymentType = PaymentTypeFactory.getService("senior");
        assertNotNull(paymentType);
        assertEquals(expected, paymentType.getCost(patient.getTotalBill()), 0.001);
    }

    @Test
    public void validateServiceCost() {
        assertNotNull(services, "Services list should not be null after setUp()");
        assertEquals(3, services.size(), "Services list should contain 3 elements");

        Service xRay = services.get(0); // Assuming order is X-Ray, Surgery, Consultation
        assertEquals("X-Ray", xRay.getServiceName());
        assertEquals(500, xRay.getServicePrice(), 0.001);

        Service surgery = services.get(1);
        assertEquals("Surgery", surgery.getServiceName());
        assertEquals(12000, surgery.getServicePrice(), 0.001);

        Service consultation = services.get(2);
        assertEquals("Consultation", consultation.getServiceName());
        assertEquals(700, consultation.getServicePrice(), 0.001);
    }
}
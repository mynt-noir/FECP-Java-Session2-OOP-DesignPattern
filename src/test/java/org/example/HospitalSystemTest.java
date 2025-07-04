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

    }


    @Test
    public void addServiceInvalidService() {

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
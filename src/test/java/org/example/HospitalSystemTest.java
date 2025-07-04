package org.example;

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
    void registerPatientValidName() {

    }

    @Test
    void registerPatientValidId() {

    }

    @Test
    void registerPatientInvalidName() {

    }

    @Test
    void registerPatientInvalidId() {

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
//        s.getServiceName.equals("X-Ray")
//                assert.equals(s.getServicePrice, 500);
    }

}
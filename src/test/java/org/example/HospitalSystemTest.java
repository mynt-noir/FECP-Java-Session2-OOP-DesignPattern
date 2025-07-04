package org.example;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HospitalSystemTest {

    private ArrayList<Patient> patients;

    @BeforeEach
    void setUp() {
        patients = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        patients.clear();
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

    }






}
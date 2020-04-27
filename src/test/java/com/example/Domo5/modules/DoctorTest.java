package com.example.Domo5.modules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    Doctor doctor;

    @BeforeEach
    void setUp() {

        doctor = new Doctor();
    }

    @Test
    void getFirstName() {

        String fName = "lior";
        doctor.setFirstName(fName);

        assertEquals(fName, doctor.getFirstName());
    }
}
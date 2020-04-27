package com.example.Domo5.repositories;

import com.example.Domo5.modules.Doctor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DoctorRepositoryTest {

    @Autowired
    DoctorRepository doctorRepository;

    @Before
    public void setUp() throws Exception {

        Doctor doctor = new Doctor();
        doctor.setId(1L);
        doctor.setFirstName("lior");
        doctorRepository.save(doctor);
    }

    @Test
    public void findByFirstName() {
        Optional<Doctor> doctor = doctorRepository.findByFirstName("lior");
        Assert.assertEquals("lior", doctor.get().getFirstName());
    }
}

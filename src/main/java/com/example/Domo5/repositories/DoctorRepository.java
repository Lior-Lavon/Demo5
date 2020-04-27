package com.example.Domo5.repositories;

import com.example.Domo5.modules.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    Optional<Doctor> findByFirstName(String fname);
}

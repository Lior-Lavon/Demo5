package com.example.Domo5.services;

import com.example.Domo5.modules.Doctor;
import com.example.Domo5.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {

//    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Set<Doctor> findAll() {

        Set<Doctor> doctorSet = new HashSet<>();
        doctorRepository.findAll().forEach(doctorSet::add);
        return doctorSet;
    }

    @Override
    public Doctor findById(Long aLong) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(aLong);
        if(optionalDoctor.isPresent())
            return optionalDoctor.get();
        else
            return null;
    }

    @Override
    public Doctor save(Doctor object) {
        Doctor savedDoctor = doctorRepository.save(object);
        return savedDoctor;
    }

    @Override
    public void delete(Doctor object) {

        doctorRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

        doctorRepository.deleteById(aLong);
    }
}

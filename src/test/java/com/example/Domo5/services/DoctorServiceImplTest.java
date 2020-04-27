package com.example.Domo5.services;

import com.example.Domo5.modules.Doctor;
import com.example.Domo5.repositories.DoctorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DoctorServiceImplTest {

    @Mock
    DoctorRepository doctorRepository;

    DoctorServiceImpl doctorService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        doctorService = new DoctorServiceImpl(doctorRepository);

        Doctor doc = new Doctor();
        doc.setId(1L);
        doc.setFirstName("lior");
        doctorService.save(doc);
    }

    @Test
    public void getDoctors() {

        // Create test set
        Doctor doctor = new Doctor();
        Set<Doctor> recipeData = new HashSet();
        recipeData.add(doctor);

        // tell mockito -> when 'recipeRepository.findAll()' is called -> Then -> return 'recipeData'
        when(doctorRepository.findAll()).thenReturn(recipeData);

        // call recipeService.getRecipes that will call behind to recipeRepository.findAll()
        Set<Doctor> recipes = doctorService.findAll();

        assertEquals(recipes.size(), 1);

        // make sure that the recipeRepository.findAll was called once and only once
        verify(doctorRepository, times(1)).findAll();
    }
}
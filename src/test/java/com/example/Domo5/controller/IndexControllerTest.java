package com.example.Domo5.controller;

import com.example.Domo5.modules.Doctor;
import com.example.Domo5.services.DoctorService;
import com.example.Domo5.services.DoctorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

    IndexController indexController;

    @Mock
    DoctorServiceImpl doctorService;
    @Mock
    Model model;

    @BeforeEach
    void setUp() {

        // create mockito mock
        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(doctorService);

    }

    @Test
    public void testMockMVC() throws Exception {

        // build Mock Mvc from indexController
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }

    @Test
    void getIndexPage() {

        //given
        Set<Doctor> recipes = new HashSet<>();
        Doctor rec1 = new Doctor();
        rec1.setId(1L);
        rec1.setFirstName("aaaa");
        recipes.add(rec1);

        Doctor rec2 = new Doctor();
        rec2.setFirstName("bbbb");
        recipes.add(rec2);

        when(doctorService.findAll()).thenReturn(recipes);

        // when
        // test that indexController.getIndexPage returns an "Index"
        String retValue = indexController.getIndexPage(model);

        // Create capture for return content of Set type
        ArgumentCaptor<Set<Doctor>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        // then
        assertEquals(retValue, "index");
        // verify that recipeService.getRecipes() runs exactly one time
        verify(doctorService, times(1)).findAll();
        // test that model.addAttribute() runs once, and:
        // addAttribute values are equal to "recipes" and anySet                          // capture what is pass into argumentCaptor
        verify(model, times(1)).addAttribute( eq("recipes"), argumentCaptor.capture());

        // test the return content in argumentCaptor.capture()
        Set<Doctor> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());

    }
}
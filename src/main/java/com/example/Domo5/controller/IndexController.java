package com.example.Domo5.controller;

import com.example.Domo5.services.DoctorService;
import com.example.Domo5.services.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private DoctorService doctroService;

    @Autowired
    public IndexController(DoctorService recipeService) {
        this.doctroService = recipeService;
    }

    @RequestMapping({"", "/"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", doctroService.findAll());

        return "index";
    }

}

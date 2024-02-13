package com.demo_bank_v1.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {


    @GetMapping("/")
    public ModelAndView getIndex(){ //for ModelAndView replace String with Model and View
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle","Home");
        System.out.println("In Index Controller");
        return getIndexPage;
    }
}

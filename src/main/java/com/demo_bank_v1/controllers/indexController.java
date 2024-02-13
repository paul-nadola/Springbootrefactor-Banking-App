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

    @GetMapping("/login")
    public ModelAndView getLogin(){
        ModelAndView getLoginPage = new ModelAndView("login");
        System.out.println("In login page controller");
        getLoginPage.addObject("PageTitle", "Login");
        return getLoginPage;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(){
        ModelAndView getRegisterPage = new ModelAndView("register");
        System.out.println("In register page controller");
        getRegisterPage.addObject("PageTitle", "Register");
        return getRegisterPage;
    }
}

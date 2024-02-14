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


    @GetMapping("/error")
    public ModelAndView getError(){
        ModelAndView getErrorPage = new ModelAndView("error");
        System.out.println("In error page controller");
        getErrorPage.addObject("PageTitle", "Error");
        return getErrorPage;
    }
    @GetMapping("/verify")
    public ModelAndView getVerify(){
        ModelAndView getVerifyPage = new ModelAndView("login");
        System.out.println("In error page controller");
        getVerifyPage.addObject("PageTitle", "Error");
        return getVerifyPage;
    }
}

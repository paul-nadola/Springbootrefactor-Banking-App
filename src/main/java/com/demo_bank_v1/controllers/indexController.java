package com.demo_bank_v1.controllers;


import com.demo_bank_v1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

    @Autowired
    private UserRepository userRepository;


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
    public ModelAndView getVerify(
            @RequestParam("token") String token,
            @RequestParam("code") String code
    ){
        //Set View
        ModelAndView getVerifyPage;

        //Get token in database
        String db_token = userRepository.checkToken(token);
        //Check if token is valid
        if (db_token == null){
            getVerifyPage = new ModelAndView("error");
            getVerifyPage.addObject("error", "This session has expired!");
        };
        //End of Check if token is valid

        //update and verify account
        userRepository.verifyAccount(token, code);

        getVerifyPage = new ModelAndView("login");
        getVerifyPage.addObject("success", "Account Verified Successfully, Please proceed to log in!");
        System.out.println("In verify account controller");
        getVerifyPage.addObject("PageTitle", "Error");
        return getVerifyPage;
    }
}

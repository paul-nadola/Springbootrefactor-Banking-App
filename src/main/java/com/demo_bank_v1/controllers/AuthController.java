package com.demo_bank_v1.controllers;

import com.demo_bank_v1.helpers.Token;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @GetMapping("/login")
    public ModelAndView getLogin(){
        System.out.println("In login page controller");
        ModelAndView getLoginPage = new ModelAndView("login");
        //Set Token String
        String token = Token.generateToken();
        //Send Token to view
        getLoginPage.addObject("token", token);
        getLoginPage.addObject("PageTitle", "Login");
        return getLoginPage;
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("email")String email,
            @RequestParam("password")String password,
            @RequestParam("_token")String token,
            Model model
    ){

        //TODO: VALIDATE INPUT FIELDS / FORM DATA:
        if(email.isEmpty() || email == null || password.isEmpty() || password == null){
            model.addAttribute("error", "Username or Password cannot be empty!");
            return "login";
        };

        //TODO: CHECK IF EMAIL EXISTS:

        //TODO: CHECK IF VALUE IS NOT NULL:

        return "";
    };

}

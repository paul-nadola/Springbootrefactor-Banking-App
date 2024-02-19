package com.demo_bank_v1.controllers;


import com.demo_bank_v1.helpers.HTML;
import com.demo_bank_v1.helpers.Token;
import com.demo_bank_v1.mailMessenger.MailMessenger;
import com.demo_bank_v1.models.User;
import com.demo_bank_v1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Random;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/register")
    public ModelAndView getRegister(){
        ModelAndView getRegisterPage = new ModelAndView("register");
        System.out.println("In register page controller");
        getRegisterPage.addObject("PageTitle", "Register");
        return getRegisterPage;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid
                @ModelAttribute("registerUser")  User user,
               BindingResult result,//request parameters
                                 @RequestParam("first_name") String first_name,
                                 @RequestParam("last_name") String last_name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm_password") String confirm_password

                ) throws MessagingException {
        ModelAndView registrationPage = new ModelAndView("register");

        //error check
        //error display based on our annotations on the models
        if(result.hasErrors() && confirm_password.isEmpty()){
            registrationPage.addObject(
                    "confirm_pass",
                    "The confirm password field is required");
            return registrationPage;
        }

        //TODO: CHECK FOR PASSWORDS MATCH

        if (!password.equals(confirm_password)){
            registrationPage.addObject(
                    "passwordMismatch",
                    "Password do not match");
            return registrationPage;
        };

        //TODO: GET TOKEN STRING
        String token = Token.generateToken();

        //TODO: GENERATE RANDOM CODE
        Random random = new Random();
        int bound = 123;
        int code = bound * random.nextInt(bound);

        //TODO: GET EMAIL HTML BODY
        String emailBody = HTML.htmlEmailTemplate(token, Integer.toString(code));

        //TODO:HASH PASSWORD
        String hash_password = BCrypt.hashpw(password, BCrypt.gensalt());

        //TODO: REGISTER USER:
        userRepository.registerUser(first_name, last_name, email, hash_password, token, Integer.toString(code));

        //TODO: SEND EMAIL NOTIFICATION
        MailMessenger.htmlEmailMessenger("no-reply@somecompany.com", email, "Verify Account", emailBody);

        //TODO: RETURN TO REGISTER PAGE

        String successMessage = "Account Registered successfully, please check your email and verify your account";
        registrationPage.addObject("success", successMessage);
        return registrationPage;

    };



}

package com.demo_bank_v1.controller_advisor;

import com.demo_bank_v1.models.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


@ControllerAdvice
public class AdvisorController {

    @ModelAttribute("registerUser")
    //The @ModelAttribute annotation is used to bind a method's return value to a named model attribute. In this case, the method getUserDefault() will be used to add a model attribute named "registerUser."
    public User getUserDefault(){
        return new User();
    };

}

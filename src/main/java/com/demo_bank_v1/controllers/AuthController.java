package com.demo_bank_v1.controllers;

import com.demo_bank_v1.helpers.Token;
import com.demo_bank_v1.models.User;
import com.demo_bank_v1.repository.UserRepository;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

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
            Model model,
            HttpSession session
    ){

        //TODO: VALIDATE INPUT FIELDS / FORM DATA:
        if(email.isEmpty() || email == null || password.isEmpty() || password == null){
            model.addAttribute("error", "Username or Password cannot be empty!");
            return "login";
        };

        //TODO: CHECK IF EMAIL EXISTS:
        String getEmailInDatabase = userRepository.getUserEmail(email);

        //Check if email Exists
        if (getEmailInDatabase != null) {
            //Get password in database
            String getPasswordInDatabase = userRepository.getUserPassword(getEmailInDatabase);

            //Validate password
            if (!BCrypt.checkpw(password, getPasswordInDatabase)) {
                model.addAttribute("error", "Incorrect Username or Password");
                return "login";
            }
            //End of Validate Password
        }else {
            model.addAttribute("error", "Something went wrong please contact support");
            return "error";
        }

        //TODO: CHECK IF USER ACCOUNT IS VERIFIED:
        int verified = userRepository.isVerified(getEmailInDatabase);
        //Check if account is verified
        if (verified != 1){
            String msg = "This account is not ye verified, please check email and verify account";
            model.addAttribute("error", msg);
            return "login";
        }
        //End of Check if account is verified
        //TODO: PROCEED TO LOG THE USER IN:

        User user = userRepository.getUserDetails(getEmailInDatabase);

        //Set session attribute:
        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("Authenticated", true);

        return "redirect:/app/dashboard";
    };
    //End of authenticating user

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes){
        session.invalidate();
        redirectAttributes.addFlashAttribute("logged_out", "Logged out successfully");
        return "redirect:/login";
    }

}

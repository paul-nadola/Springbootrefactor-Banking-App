package com.demo_bank_v1.controllers;


import com.demo_bank_v1.models.Accounts;
import com.demo_bank_v1.models.User;
import com.demo_bank_v1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session){
        ModelAndView getDashboardPage = new ModelAndView("dashboard");

        //get the details of the Logged-in user
        User user = (User) session.getAttribute("user");

        //get the accounts of the logged-in user
        List<Accounts> getUserAccounts = accountRepository.getUserAccountById(user.getUser_id());


        //get balance
        BigDecimal totalAccountBalance = accountRepository.getTotalBalance(user.getUser_id());

        //set objects
        getDashboardPage.addObject("userAccounts", getUserAccounts);
        getDashboardPage.addObject("totalBalance", totalAccountBalance);


        return getDashboardPage;
    }

}
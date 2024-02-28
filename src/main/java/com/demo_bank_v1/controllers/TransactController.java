package com.demo_bank_v1.controllers;

import com.demo_bank_v1.models.User;
import com.demo_bank_v1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/transact")
public class TransactController {

    @Autowired
    private AccountRepository accountRepository;

    User user;
    double currentBalance;
    double newBalance;

    @PostMapping("/deposit")
    public String deposit(
            @RequestParam("deposit_amount") String depositAmount,
            @RequestParam("account_id") String accountID,
            HttpSession session,
            RedirectAttributes redirectAttributes
            ){

        // TODO: CHECK FOR EMPTY STRINGS:
        if (depositAmount.isEmpty() || accountID.isEmpty()){
            redirectAttributes.addFlashAttribute("error", "Deposit Amount or Account Deposited to cannot be empty");
            return "redirect:/app/dashboard";
        }

        // TODO: GET LOGGED IN USER

        user = (User)session.getAttribute("user");

        // TODO: GET CURRENT ACCOUNT BALANCE
        int acc_id = Integer.parseInt(accountID);

        double depositAmountValue = Double.parseDouble(depositAmount);



        //TODO : CHECK IF DEPOSIT AMOUNT IS ZERO

        if (depositAmountValue == 0){
            redirectAttributes.addFlashAttribute("error", "Deposit amount cannot be of 0 (zero) value.");
            return "redirect:/app/dashboard";
        }

        // TODO: UPDATE BALANCE:
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);
        newBalance = currentBalance + depositAmountValue;

        accountRepository.changeAccountBalanceId(newBalance, acc_id);

        redirectAttributes.addFlashAttribute("success", "Amount of " + depositAmountValue + " Deposited successfully!");
        return "redirect:/app/dashboard";
    }

    //End of deposits

    @PostMapping("/transfer")
    public String transfer(
            @RequestParam("transfer_from") String transfer_from,
            @RequestParam("transfer_to") String transfer_to,
            @RequestParam("transfer_amount") String transfer_amount,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ){
        //TODO : CHECK FOR EMPTY FIELDS
        if (transfer_from.isEmpty() || transfer_to.isEmpty() || transfer_amount.isEmpty()){
            redirectAttributes.addFlashAttribute("error", "The account transferring from, to and transfer amount cannot be empty!");
            return "redirect:/app/dashboard";
        }

        // TODO : CONVERT VARIABLES
        int transferFromId = Integer.parseInt(transfer_from);
        int transferToId = Integer.parseInt(transfer_to);
        double transferAmount = Double.parseDouble(transfer_amount);

        //TODO : CHECK IF TRANSFERRING INTO THE SAME ACCOUNT
        if (transferFromId == transferToId){
            redirectAttributes.addFlashAttribute("error", "You cannot transfer to the same account!" +
                    "Please select the appropriate accounts to perform the transfer.");
            return "redirect:/app/dashboard";
        }

        // TODO : CHECK FOR ZERO VALUES
        if (transferAmount == 0){
            redirectAttributes.addFlashAttribute("error", "Cannot transfer an amount of 0 (Zero)");
            return "redirect:/app/dashboard";
        }
        // TODO : GET LOGGED IN USER
        user = (User)session.getAttribute("user") ;

        //TODO : GET THE CURRENT BALANCE
        double currentBalanceDonor = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);
        double currentBalanceRecipient = accountRepository.getAccountBalance(user.getUser_id(), transferToId);

        //TODO : SET NEW BALANCE;
        //Changed the balance of the account transferred From:
        double newBalanceDonor  = currentBalanceDonor - transferAmount;
        accountRepository.changeAccountBalanceId(newBalanceDonor, transferFromId);

        //Changed the balance of the account transferred To:
        double newBalanceRecipient = currentBalanceRecipient + transferAmount;
        accountRepository.changeAccountBalanceId(newBalanceRecipient, transferToId);

        redirectAttributes.addFlashAttribute("success", "Amount transferred Successfully!");
        return "redirect:/app/dashboard";
    }

    //End of transfer method

    @PostMapping("/withdraw")
    public String withdraw(){

        return "";
    }

}



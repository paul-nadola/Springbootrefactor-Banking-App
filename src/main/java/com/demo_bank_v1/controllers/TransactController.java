package com.demo_bank_v1.controllers;

import com.demo_bank_v1.models.User;
import com.demo_bank_v1.repository.AccountRepository;
import com.demo_bank_v1.repository.PaymentRepository;
import com.demo_bank_v1.repository.TransactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;


@Controller
@RequestMapping("/transact")
public class TransactController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentRepository paymentRepository;


    @Autowired
    private TransactRepository transactRepository;

    User user;
    double currentBalance;
    double newBalance;

    LocalDateTime currentDateTime = LocalDateTime.now();


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

        //Log Successfully Transaction.
        transactRepository.logTransaction(
                acc_id, "deposit", depositAmountValue, "online", "success", "Deposit Transaction Successful!", currentDateTime
        );

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
        String errorMessage;
        String successMessage;
        //TODO : CHECK FOR EMPTY FIELDS
        if (transfer_from.isEmpty() || transfer_to.isEmpty() || transfer_amount.isEmpty()){
            redirectAttributes.addFlashAttribute("error", "The account transferring from, to " +
                    "and transfer amount cannot be empty!");
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
            redirectAttributes.addFlashAttribute("error", "Cannot transfer an amount of 0 (Zero), please enter a value greater than 0");
            return "redirect:/app/dashboard";
        }

        // TODO : GET LOGGED IN USER
        user = (User)session.getAttribute("user") ;

        //TODO : GET THE CURRENT BALANCE
        double currentBalanceDonor = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);
        double currentBalanceRecipient = accountRepository.getAccountBalance(user.getUser_id(), transferToId);

        // TODO : CHECK IF TRANSFER AMOUNT IS MORE THAN CURRENT BALANCE
        if (currentBalanceDonor < transferAmount) {
            errorMessage = "You have insufficient funds to perform this transfer!";
            //Log failed transaction
            transactRepository.logTransaction(
                    transferFromId, "transfer", transferAmount, "online", "failed", "Insufficient Funds", currentDateTime
            );
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO : SET NEW BALANCE;
        //Changed the balance of the account transferred From:
        double newBalanceDonor  = currentBalanceDonor - transferAmount;
        accountRepository.changeAccountBalanceId(newBalanceDonor, transferFromId);

        //Changed the balance of the account transferred To:
        double newBalanceRecipient = currentBalanceRecipient + transferAmount;
        accountRepository.changeAccountBalanceId(newBalanceRecipient, transferToId);
        // Log successful transaction
        transactRepository.logTransaction(
                transferFromId, "transfer", transferAmount, "online", "success", "Transfer Transaction Successful!", currentDateTime
        );

        redirectAttributes.addFlashAttribute("success", "Amount transferred Successfully!");
        return "redirect:/app/dashboard";
    }

    //End of transfer method

    @PostMapping("/withdraw")
    public String withdraw(
            @RequestParam("withdrawal_amount")String withdrawalAmount,
            @RequestParam("account_id")String accountID,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ){
        String errorMessage;
        String successMessage;
        //TODO : CHECK FOR EMPTY VALUES
        if (withdrawalAmount.isEmpty() || accountID.isEmpty()){
            errorMessage = "Withdrawal Amount and Account withdrawing from cannot be empty!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO : CONVERT VARIABLES
        double withdrawal_amount = Double.parseDouble(withdrawalAmount);
        int account_id = Integer.parseInt(accountID);

        //TODO : CHECK FOR 0 (ZERO) VALUES
        if (withdrawal_amount == 0){
            errorMessage = "Withdrawal amount cannot be of 0 (zero) value! " +
                    "Please enter an amount greater than zero";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO : GET LOGGED IN USER
        user = (User) session.getAttribute("user");

        //TODO : GET CURRENT BALANCE
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(), account_id);

        // TODO : CHECK IF WITHDRAWAL AMOUNT IS MORE THAN CURRENT BALANCE
        if (currentBalance < withdrawal_amount) {
            errorMessage = "You have insufficient funds to perform this transfer!";
            //Log failed transaction
            transactRepository.logTransaction(
                    account_id, "withdrawal", withdrawal_amount, "online", "failed", "Insufficient Funds", currentDateTime
            );
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO : SET NEW BALANCE
        newBalance = currentBalance - withdrawal_amount;

        //TODO : UPDATE ACCOUNT BALANCE
        accountRepository.changeAccountBalanceId(newBalance,account_id);
        // Log successful withdrawal
        transactRepository.logTransaction(
                account_id, "withdrawal", withdrawal_amount, "online", "success", "Withdrawal Transaction Successful!", currentDateTime
        );

        successMessage = "Amount of "+ withdrawal_amount + " withdrew successfully";
        redirectAttributes.addFlashAttribute("success", successMessage);
        return "redirect:/app/dashboard";
    }
    //END OF WITHDRAWAL METHOD



    @PostMapping("/payment")
    public String payment(
            @RequestParam("beneficiary") String beneficiary,
            @RequestParam("account_number") String account_number,
            @RequestParam("account_id") String account_id,
            @RequestParam("reference") String reference,
            @RequestParam("payment_amount") String payment_amount,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ){
        String errorMessage;
        String successMessage;
        // TODO : CHECK FOR EMPTY VALUES
        if (
                beneficiary.isEmpty() || account_number.isEmpty() || account_id.isEmpty() || payment_amount.isEmpty()
        ){
            errorMessage = "Beneficiary, Account Number, Account Paying From and Payment Amount Cannot Be Empty";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }
        // TODO : CONVERT VARIABLES
        int accountID = Integer.parseInt(account_id);
        double paymentAmount = Double.parseDouble(payment_amount);

        // TODO : CHECK FOR 0 (ZERO) VALUES
        if (paymentAmount == 0){
            errorMessage = "Withdrawal amount cannot be of 0 (zero) value! " +
                    "Please enter an amount greater than zero";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }
        // TODO : GET LOGGED IN USER
        user = (User) session.getAttribute("user");

        // TODO : GET CURRENT BALANCE
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(),accountID);

        // TODO : CHECK IF PAYMENT AMOUNT IS MORE THAN CURRENT BALANCE
        if (currentBalance < paymentAmount) {
            errorMessage = "You have insufficient funds to perform this payment!";
            paymentRepository.makePayment(
                    accountID, beneficiary, account_number, paymentAmount, reference, "failed", "Could not process payment due to insufficient funds!", currentDateTime
            );

            //Log failed transaction
            transactRepository.logTransaction(
                    accountID, "payment", paymentAmount, "online", "failed", "Insufficient Funds", currentDateTime
            );
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }
        // TODO : SET NEW BALANCE FOR ACCOUNT PAYING FROM
        newBalance = currentBalance - paymentAmount;

        // TODO : MAKE PAYMENT
        String reasonCode = "Payment Processed Successfully!";
        paymentRepository.makePayment(
                accountID, beneficiary, account_number, paymentAmount, reference, "success", reasonCode, currentDateTime
        );


        // TODO : UPDATE ACCOUNT PAYING FROM:
        accountRepository.changeAccountBalanceId(newBalance, accountID);
        // Log successful payment
        transactRepository.logTransaction(
                accountID, "Payment", paymentAmount, "online", "success", "Payment Transaction Successful!", currentDateTime
        );

        successMessage = reasonCode;
        redirectAttributes.addFlashAttribute("success", successMessage);
        return "redirect:/app/dashboard";
    }
}



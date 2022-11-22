package com.spring.MyProjectRest.controller;

import com.spring.MyProjectRest.entity.Account;
import com.spring.MyProjectRest.entity.Customer;
import com.spring.MyProjectRest.service.Account.AccountService;
import com.spring.MyProjectRest.service.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    AccountService AccountService;

    @Autowired
    public void setAccountService(com.spring.MyProjectRest.service.Account.AccountService accountService) {
        AccountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> findAll(){
        return AccountService.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account findById(@PathVariable int id){
        return AccountService.findById(id);
    }

    @PostMapping ("/accounts/{customerId}")
    public Account addAccount(@PathVariable int customerId ,@RequestBody Account account){
        account.setId(0);
        AccountService.addAccount(account,customerId);
        return account;
    }
    @PutMapping ("/accounts")
    public Account updateAccount(@RequestBody Account account){
        AccountService.updateAccount(account);
        return account;
    }

    @DeleteMapping ("/accounts/{id}")
    public String DeleteAccount(@PathVariable int id){
        Account account=AccountService.findById(id);
        if (account==null){
            throw new RuntimeException("this Account doesn't exist");
        }
        else {
            AccountService.delete(id);
        }
        return "deleted Account with id: "+id;
    }
}

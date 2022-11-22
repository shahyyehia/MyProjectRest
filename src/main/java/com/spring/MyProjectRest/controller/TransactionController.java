package com.spring.MyProjectRest.controller;

import com.spring.MyProjectRest.entity.Transaction;
import com.spring.MyProjectRest.service.Transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> findAll(){
        return transactionService.findAll();
    }

    @GetMapping("/transactions/{id}")
    public Transaction findById(@PathVariable int id){
        return transactionService.findById(id);
    }

    @PostMapping ("/transactions/{accountId}/{branchId}")
    public Transaction addtransaction(@PathVariable int accountId,@PathVariable int branchId,@RequestBody Transaction transaction){
        transaction.setId(0);
        transactionService.addTransaction(transaction,accountId,branchId);
        return transaction;
    }
    @PutMapping ("/transactions")
    public Transaction updatetransaction(@RequestBody Transaction transaction){
        transactionService.updateTransaction(transaction);
        return transaction;
    }

    @DeleteMapping ("/transactions/{id}")
    public String Deletetransaction(@PathVariable int id){
        Transaction transaction=transactionService.findById(id);
        if (transaction==null){
            throw new RuntimeException("this transaction doesn't exist");
        }
        else {
            transactionService.delete(id);
        }
        return "deleted transaction with id: "+id;
    }
}

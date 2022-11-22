package com.spring.MyProjectRest.service.Transaction;

import com.spring.MyProjectRest.entity.Transaction;

import java.util.List;

public interface TransactionService {

    public List<Transaction> findAll();

    public Transaction findById(int id);

    public void addTransaction(Transaction Transaction,int accountId,int branchId);

    public void updateTransaction(Transaction Transaction);

    public void delete(int id);
}

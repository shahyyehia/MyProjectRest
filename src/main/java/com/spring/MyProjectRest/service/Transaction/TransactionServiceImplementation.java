package com.spring.MyProjectRest.service.Transaction;

import com.spring.MyProjectRest.entity.Account;
import com.spring.MyProjectRest.entity.Branch;
import com.spring.MyProjectRest.entity.Transaction;
import com.spring.MyProjectRest.repo.AccountRepo;
import com.spring.MyProjectRest.repo.BranchRepo;
import com.spring.MyProjectRest.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImplementation implements TransactionService {

    TransactionRepo repo;
    AccountRepo accountRepo;

    BranchRepo branchRepo;

    @Autowired
    public TransactionServiceImplementation(TransactionRepo repo,AccountRepo accountRepo,BranchRepo branchRepo) {
        this.repo = repo;
        this.accountRepo=accountRepo;
        this.branchRepo=branchRepo;
    }

    @Override
    public List<Transaction> findAll() {

        return repo.findAll();
    }

    @Override
    public Transaction findById(int id) {

        Optional<Transaction> result = repo.findById(id);
        Transaction Transaction=null;
        if (result!=null){
            Transaction=result.get();
        }
        else {
            throw new RuntimeException("Transaction not found");
        }
        return Transaction;
    }

    @Override
    public void addTransaction(Transaction Transaction, int accountId,int branchId) {
        Account account=accountRepo.findById(accountId).get();
        Branch branch=branchRepo.findById(branchId).get();
        Transaction.setAccount(account);
        Transaction.setBranch(branch);
        repo.save(Transaction);
    }

    @Override
    public void updateTransaction(Transaction Transaction) {
        repo.save(Transaction);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}

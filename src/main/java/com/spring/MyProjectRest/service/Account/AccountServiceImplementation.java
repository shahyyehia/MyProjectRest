package com.spring.MyProjectRest.service.Account;

import com.spring.MyProjectRest.entity.Account;
import com.spring.MyProjectRest.entity.Customer;
import com.spring.MyProjectRest.repo.AccountRepo;
import com.spring.MyProjectRest.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplementation implements AccountService {

    AccountRepo repo;
    CustomerRepo customerRepo;

    @Autowired
    public AccountServiceImplementation(AccountRepo repo,CustomerRepo customerRepo) {
        this.repo = repo;
        this.customerRepo=customerRepo;
    }

    @Override
    public List<Account> findAll() {

        return repo.findAll();
    }

    @Override
    public Account findById(int id) {

        Optional<Account> result = repo.findById(id);
        Account Account=null;
        if (result!=null){
            Account=result.get();
        }
        else {
            throw new RuntimeException("Account not found");
        }
        return Account;
    }

    @Override
    public void addAccount(Account Account,int customerId) {
        Customer customer=customerRepo.findById(customerId).get();
        Account.setCustomer(customer);
        repo.save(Account);
    }

    @Override
    public void updateAccount(Account account) {
        repo.save(account);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}

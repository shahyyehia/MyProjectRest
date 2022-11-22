package com.spring.MyProjectRest.service.Account;

import com.spring.MyProjectRest.entity.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public Account findById(int id);

    public void addAccount(Account Account,int customerId);

    public void updateAccount(Account account);

    public void delete(int id);
}

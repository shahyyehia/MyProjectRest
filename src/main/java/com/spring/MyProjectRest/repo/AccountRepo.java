package com.spring.MyProjectRest.repo;

import com.spring.MyProjectRest.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Integer> {
}

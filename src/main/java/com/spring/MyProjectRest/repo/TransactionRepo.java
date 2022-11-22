package com.spring.MyProjectRest.repo;

import com.spring.MyProjectRest.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
}

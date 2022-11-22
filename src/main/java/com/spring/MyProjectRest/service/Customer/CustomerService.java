package com.spring.MyProjectRest.service.Customer;

import com.spring.MyProjectRest.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

    public Customer findById(int id);

    public void addCustomer(Customer customer);

    public void delete(int id);
}

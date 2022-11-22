package com.spring.MyProjectRest.service.Customer;

import com.spring.MyProjectRest.entity.Customer;
import com.spring.MyProjectRest.repo.CustomerRepo;
import com.spring.MyProjectRest.service.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    CustomerRepo repo;

    @Autowired
    public CustomerServiceImplementation(CustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Customer> findAll() {

        return repo.findAll();
    }

    @Override
    public Customer findById(int id) {

        Optional<Customer> result = repo.findById(id);
        Customer customer=null;
        if (result!=null){
            customer=result.get();
        }
        else {
            throw new RuntimeException("Customer not found");
        }
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
        repo.save(customer);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}

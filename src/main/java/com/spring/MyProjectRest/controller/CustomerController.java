package com.spring.MyProjectRest.controller;

import com.spring.MyProjectRest.entity.Customer;
import com.spring.MyProjectRest.service.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable int id){
        return customerService.findById(id);
    }

    @PostMapping ("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);
         customerService.addCustomer(customer);
         return customer;
    }
    @PutMapping ("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return customer;
    }

    @DeleteMapping ("/customers/{id}")
    public String DeleteCustomer(@PathVariable int id){
        Customer customer=customerService.findById(id);
        if (customer==null){
            throw new RuntimeException("this customer doesn't exist");
        }
        else {
            customerService.delete(id);
        }
        return "deleted customer with id: "+id;
    }
}

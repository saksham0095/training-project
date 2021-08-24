package com.training.querymanager.service;

import com.training.querymanager.pojo.Customer;
import com.training.querymanager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> saveCustomer(Customer customer) {
        if (customerRepository.save(customer) != null) {
            return Optional.ofNullable(customerRepository.save(customer));
        } else {
            return Optional.ofNullable(customerRepository.save(customer));
        }
    }

    public List<Customer> findAllCustomers() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        if (customers != null && customers.size() != 0) {
            return customers;
        } else {
            return customers;
        }
    }
}

package com.training.querymanager.repository;

import com.training.querymanager.pojo.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    public Customer findCustomerByCustomerName(String name);
}

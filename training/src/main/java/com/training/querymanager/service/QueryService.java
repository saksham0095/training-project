package com.training.querymanager.service;

import com.training.querymanager.pojo.Customer;
import com.training.querymanager.pojo.Query;
import com.training.querymanager.repository.CustomerRepository;
import com.training.querymanager.repository.QueryRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class QueryService {

    @Autowired
    QueryRepository queryRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Optional<Query> createQuery(Query query,String name)
    {
        query.setCreatedDate(new Date());

        Customer customer=customerRepository.findCustomerByCustomerName(name);
        query.setCustomer(customer);

        if(queryRepository.save(query)!=null&&customer!=null)
        {
            return Optional.ofNullable(queryRepository.save(query));
        }
        else {
            return Optional.ofNullable(queryRepository.save(query));
        }
    }

    public Optional<Set<Query>>fetchQueries(String customerName)
    {
        Customer customer=customerRepository.findCustomerByCustomerName(customerName);
        if(customer.getQueries()!=null&&customer.getQueries().size()!=0)
        {
            return Optional.ofNullable(customer.getQueries());
        }
        else {
            return Optional.ofNullable(customer.getQueries());
        }
    }

    public List<Query> getQueries() {
        List<Query>queries= (List<Query>) queryRepository.findAll();
        System.out.println(queries.size());
        if(queries!=null&&queries.size()!=0)
        {
            return queries;
        }
        else
        {
            return queries;
        }
    }
}

package com.training.querymanager.resource;

import com.training.querymanager.pojo.Customer;
import com.training.querymanager.pojo.Query;
import com.training.querymanager.service.CustomerService;
import com.training.querymanager.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/customer")
public class QueryResource {

    @Autowired
    private QueryService queryService;

    @Autowired
    private CustomerService customerService;


    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        if (customerService.saveCustomer(customer).isPresent()) {
            return new ResponseEntity<Customer>(customerService.saveCustomer(customer).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Customer>(customerService.saveCustomer(customer).get(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Customer>> findAllCustomers() {
        List<Customer>customers=customerService.findAllCustomers();
        if (customers != null && customers.size() != 0) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/query/{customerName}")
    public ResponseEntity<Query> saveQuery(@RequestBody Query query, @PathVariable("customerName") String name) {
        if (queryService.createQuery(query, name).isPresent()) {
            return new ResponseEntity<Query>(queryService.createQuery(query, name).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Query>(queryService.createQuery(query, name).get(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/query/{customerName}")
    public ResponseEntity<Set<Query>> getQueries(@PathVariable("customerName") String customerName) {
        if (queryService.fetchQueries(customerName).isPresent()) {
            return new ResponseEntity<Set<Query>>(new LinkedHashSet<>(queryService.fetchQueries(customerName).get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<Set<Query>>(queryService.fetchQueries(customerName).get(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/query/findAll")
    public ResponseEntity<List<Query>> getAllQueries() {
        List<Query>queries=queryService.getQueries();
        if (queries!=null&&queries.size()!=0) {
            return new ResponseEntity<List<Query>>(queries, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Query>>(queries, HttpStatus.NOT_FOUND);
        }

    }

}

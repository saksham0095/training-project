package com.training.querymanager;

import com.training.querymanager.pojo.Customer;
import com.training.querymanager.pojo.Query;
import com.training.querymanager.repository.CustomerRepository;
import com.training.querymanager.repository.QueryRepository;
import com.training.querymanager.service.CustomerService;
import com.training.querymanager.service.QueryService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Set;

@SpringBootTest
class TrainingApplicationTests {

	@Autowired
	CustomerRepository mockCustomerRepository;

	@Autowired
	QueryRepository mockQueryRepository;

	@Mock
	QueryService mockQueryService;

	@Mock
	CustomerService mockCustomerService;

	@Test
	public void saveCustomerTest()
	{
		Customer customer=new Customer();
		customer.setId(1L);
		customer.setCustomerName("sam");
		mockCustomerRepository.save(customer);
		assertNotNull(mockCustomerRepository.findById(3L).get());
	}

	@Test
	public void findAllCustomersTest()
	{
		List<Customer> customerList= (List<Customer>) mockCustomerRepository.findAll();
		assertThat(customerList).size().isGreaterThan(0);

	}

	@Test
	public void saveQueryTest()
	{
		Query ordQuery=mockQueryRepository.findById(1L).get();
		Query query=new Query();
		query.setId(1L);
		query.setQuery("demo");
		query.setStatus("created");
		query.setCreatedDate(ordQuery.getCreatedDate());
		Customer customer=new Customer();
		customer.setId(1L);
		customer.setCustomerName("sam");
		query.setCustomer(customer);
		assertNotNull(mockQueryRepository.findById(1L).get());

	}

//	@Test
//	public void fetchQueriesByName()
//	{
//		Set<Query>queries= (Set<Query>) mockQueryService.fetchQueries("ronald").get();
//		System.out.println("Size="+queries.size());
//		assertThat(queries).size().isEqualTo(1);
//	}

	@Test
	public void fetchAllQueries()
	{
		List<Query>queries= (List<Query>) mockQueryRepository.findAll();
		assertThat(queries).size().isGreaterThan(0);
	}

}

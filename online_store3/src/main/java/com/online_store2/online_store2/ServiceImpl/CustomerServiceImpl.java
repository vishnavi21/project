package com.online_store2.online_store2.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_store2.online_store2.Entities.Customer;
import com.online_store2.online_store2.Repositories.CustomerRepository;
import com.online_store2.online_store2.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
}
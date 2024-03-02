package com.online_store2.online_store2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_store2.online_store2.Entities.Customer;
import com.online_store2.online_store2.Service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
@Autowired 
CustomerService customerService;

@PostMapping("/create")
public Customer createCustomer(@RequestBody Customer customer)
{
	return customerService.createCustomer(customer);
}
}

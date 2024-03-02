package com.online_store2.online_store2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_store2.online_store2.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

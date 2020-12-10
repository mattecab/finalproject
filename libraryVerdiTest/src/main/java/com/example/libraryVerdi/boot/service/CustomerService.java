package com.example.libraryVerdi.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryVerdi.boot.model.Customer;
import com.example.libraryVerdi.boot.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;

	public Iterable<Customer> findAll() {

		return repository.findAll();
	}
	
	public void insertCustomer (Customer customer) {

		repository.save(customer);
	}
	
	
	public Optional<Customer> findById (long customer_id) {

		return repository.findById(customer_id);
	}

}
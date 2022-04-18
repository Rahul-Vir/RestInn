package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.demo.document.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class ServiceCustomer {
	@Autowired
	CustomerRepository customerRepo;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	public List<Customer> getAllCustomers(){
		 List<Customer> customer = customerRepo.findAll();
		if(customer.isEmpty()) {
			return null;
		}
		else {
			return customer;
		}
		
	}
	
	public Customer  createCustomer(Customer customer) {
		if ((customer.getEmail() != null && customer.getEmail() != "")
				&& (customer.getLogin().getPassword() != null && customer.getLogin().getPassword() != "")) {
			if (customer.getEmail().contains("@")
					&& (customer.getLogin().getPassword().length() >= 6 && customer.getLogin().getPassword().length() <= 20)) {
				String encrypted = encoder.encode(customer.getLogin().getPassword());
				customer.getLogin().setPassword(encrypted);
				return customerRepo.save(customer);
			}
		}
		return new Customer();
		
	}
	
	public Customer getCustomerById(String id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			return new Customer();
		}
	}
	
}

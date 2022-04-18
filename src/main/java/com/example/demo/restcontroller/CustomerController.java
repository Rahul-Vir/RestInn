package com.example.demo.restcontroller;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.document.Credential;
import com.example.demo.document.Customer;
import com.example.demo.document.Location;
import com.example.demo.document.Login;
import com.example.demo.document.Registration;
import com.example.demo.service.ServiceCustomer;

@CrossOrigin
@RestController
public class CustomerController {

	Customer c1;
	Customer c2;
	
	@Autowired
	ServiceCustomer serviceCustomer;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@PostMapping("/user/login")
	public <T> T getUser(@RequestBody Credential credential){
		List<Customer> cus1 = serviceCustomer.getAllCustomers();
		
		cus1.forEach((c) ->{
			if(c.getLogin().getEmail().equals(credential.getEmail()) && encoder.matches(credential.getPassword(), c.getLogin().getPassword())) {
				c1 = c;
				c2 = c;
				
			}
		});
		
		if(c1!=null) {
			
			c1 = null;
			return (T) c2;
			
		}else {
			return null; 
		}
	}
	
	@GetMapping("/customers")
	
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customer= serviceCustomer.getAllCustomers();
		if(customer==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(customer));
	}
	}
	
	@PostMapping("/user/registration")
	public Customer createCustomer(@RequestBody Registration registration ) {
		
		Customer customer = new Customer();
		customer.setFirstName(registration.getFirstName());
		customer.setLastName(registration.getLastName());
		Location l = new Location(registration.getStreetAddress(),registration.getCity(),registration.getPostalCode(),registration.getProvince());
		customer.setLocation(l);
		customer.setPhoneNumber(Long.parseLong(registration.getNumber()));
		customer.setLogin(new Login(registration.getEmail(),registration.getPassword()));
		customer.setEmail(registration.getEmail());
		return serviceCustomer.createCustomer(customer);
	}
		
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String id){
		Customer customer = serviceCustomer.getCustomerById(id);
		if(customer.getId()==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();			
		}
		else {
			return ResponseEntity.of(Optional.of(customer));
		}
	}
		
}

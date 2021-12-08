package com.lti.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.exception.ResourceNotFoundException;
import com.lti.model.Customer;
import com.lti.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/bank-api")
public class CustomerController {
	
	//trying git with microservices
	

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	@HystrixCommand(fallbackMethod = "getAllCustomerFallback")
	public ResponseEntity<?> getAllCustomers() {
		List<Customer> customersList = customerService.getAllCustomers();

		if (customersList == null) {
			return new ResponseEntity<>("customers Not Found", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(customersList, HttpStatus.OK);

		}

	}
	public String getAllCustomerFallback() {
		
		return "servuce gateway failed";
		
	}
	

	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {

		return customerService.saveCustomer(customer);
		
	}

	@GetMapping("/customers/{id}")
	
	public ResponseEntity<?> findByid(@PathVariable("id") Integer id) {
		Optional<Customer> customer = customerService.findById(id);
		if (customer != null) {
			return new ResponseEntity<>(customer, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("customer Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<?>  updateCustomer(@PathVariable(value = "id") Integer id,@RequestBody Customer c) throws ResourceNotFoundException {

		
		Customer cus = customerService.findById(id)
		       .orElseThrow(()-> new ResourceNotFoundException("Customer not found for this id :: " + id));
		
		cus.setName(c.getName());
		cus.setAge(c.getAge());
		cus.setAddress(c.getAddress());
		cus.setTypeOfAccount(c.getTypeOfAccount());
		
		final Customer updatedCustomer= customerService.saveCustomer(cus);
		
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		boolean customer = customerService.deleteById(id);
		if (customer == true) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(customer, HttpStatus.FAILED_DEPENDENCY);
		}
	}

}

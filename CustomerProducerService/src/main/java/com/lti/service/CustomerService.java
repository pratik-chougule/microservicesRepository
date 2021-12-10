package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Customer;
import com.lti.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
		
		
		return customerRepository.findAll();
		
	}
	
	
	public Optional<Customer> findById(int id) {
		
		
	return	customerRepository.findById(id);
		
	}
		
	public Customer saveCustomer(Customer customer) {
		
		
		return customerRepository.save(customer);
	}
	
	public Customer updateCustomer(Customer c) {
		
		return customerRepository.save(c);
		
	}
	
	
	public boolean deleteById(Integer id) {
		
		
		Customer customer = customerRepository.findById(id).get();
		
		if(customer!=null) {
			customerRepository.delete(customer);
			
			return true;
		}
		
		return false;
		
	}


	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	
	

}

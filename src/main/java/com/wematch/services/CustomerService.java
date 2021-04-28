package com.wematch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wematch.models.Customer;
import com.wematch.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;

	public List<Customer> getCustomerList() {		
		List<Customer> customers = customerRepository.findAll();

		return customers;
	}
	
	public Customer getCustomerById(Long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		
		return customer.get();
	}
	
	public void registerCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void updateCustomer(Customer customer) {
		customerRepository.findById(customer.getCustomerId())
			.ifPresent(cus -> {
				customerRepository.save(customer);				
			});
	}
	
	public void deleteCustomer(Long customerId) {
		customerRepository.deleteById(customerId);
	}
}

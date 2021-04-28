package com.wematch.apis.v1;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wematch.models.Customer;
import com.wematch.services.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private final CustomerService customerService;
	
	@GetMapping("")
	public List<Customer> getCustomerList(){
		List<Customer> customer = customerService.getCustomerList();
		return customer;
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") Long customerId){
		Customer customer = customerService.getCustomerById(customerId);
		return customer;
	}
	
	@PostMapping("")
	public void registerCustomer(@RequestBody Customer customer){
		customerService.registerCustomer(customer);
	}
	
	@PutMapping("/{id}")
	public void updateCustomer(@RequestBody Customer customer){
		customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") Long customerId){
		customerService.deleteCustomer(customerId);
	}
}

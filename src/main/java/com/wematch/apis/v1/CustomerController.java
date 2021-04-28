package com.wematch.apis.v1;

import static com.wematch.apis.dto.ApiResult.succeed;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wematch.apis.dto.ApiResult;
import com.wematch.apis.dto.CustomerDTO;
import com.wematch.models.Customer;
import com.wematch.services.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private final CustomerService customerService;
	
	@GetMapping("")
	public ApiResult<List<CustomerDTO>> getCustomerList(){
		List<Customer> customers = customerService.getCustomerList();
		
		List<CustomerDTO> customerDtoList = customers.stream().map(customer -> {
			return CustomerDTO.builder()
				.name(customer.getName())
				.tel(customer.getTel())
				.build();
		}).collect(Collectors.toList());
		
		return succeed(customerDtoList);
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

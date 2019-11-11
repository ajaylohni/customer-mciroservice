package com.dell.emc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dell.emc.exception.ResourceNotFoundException;
import com.dell.emc.model.Customer;
import com.dell.emc.repository.CustomerRepository;




@Service
public class CustomerServiceImpl implements CustomerService {
	

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	
	public Customer getCustomerByid(Long customerId) throws ResourceNotFoundException {
		return customerRepository
        .findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found on :: " + customerId));
	}
	
	public Customer createCustomer(Customer customer) {
		 return customerRepository.save(customer);
	}
	
	public void deleteCustomer(Customer customer) {
		 customerRepository.delete(customer);
	}

	

}

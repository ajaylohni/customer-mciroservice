package com.dell.emc.service;

import java.util.List;

import javax.validation.Valid;

import com.dell.emc.exception.ResourceNotFoundException;
import com.dell.emc.model.Customer;

public interface CustomerService {


	Customer getCustomerByid(Long customerId) throws ResourceNotFoundException;

	Customer createCustomer(@Valid Customer customer);

	void deleteCustomer(Customer customer);

	List<Customer> findAll();

}
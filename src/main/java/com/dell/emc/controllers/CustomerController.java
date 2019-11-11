package com.dell.emc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dell.emc.exception.ResourceNotFoundException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.dell.emc.model.Customer;
import com.dell.emc.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1")
public class CustomerController {

  @Autowired
  private CustomerService customerService;
  /**
   * Get all customers list.
   *
   * @return the list
   */
  @GetMapping("/customers")
  public List<Customer> getAllCustomers() {
    return customerService.findAll();
  }

  /**
   * Gets customers by id.
   *
   * @param customerId the customer id
   * @return the customers by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/customers/{id}")
  public ResponseEntity<Customer> getCustomersById(@PathVariable(value = "id") Long customerId)
      throws ResourceNotFoundException {
        Customer customer = customerService.getCustomerByid(customerId);
    return ResponseEntity.ok().body(customer);
  }

  /**
   * Create customer customer.
   *
   * @param customer the customer
   * @return the customer
   */
  @PostMapping("/customers")
  public Customer createCustomer(@Valid @RequestBody Customer customer) {
    return customerService.createCustomer(customer);
  }

  /**
   * Update customer response entity.
   *
   * @param customerId the customer id
   * @param customerDetails the customer details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/customers/{id}")
  public ResponseEntity<Customer> updateCustomer(
      @PathVariable(value = "id") Long customerId, @Valid @RequestBody Customer customerDetails)
      throws ResourceNotFoundException {

    Customer customer = customerService.getCustomerByid(customerId);
    customer.setEmail(customerDetails.getEmail());
    customer.setLastName(customerDetails.getLastName());
    customer.setFirstName(customerDetails.getFirstName());
    final Customer updatedCustomer = customerService.createCustomer(customer);
    return ResponseEntity.ok(updatedCustomer);
  }

  /**
   * Delete customer map.
   *
   * @param customerId the customer id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/customers/{id}")
  public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId) throws Exception {
    Customer customer = customerService.getCustomerByid(customerId);
    customerService.deleteCustomer(customer);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
 

}
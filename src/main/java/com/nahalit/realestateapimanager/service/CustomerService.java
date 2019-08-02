package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.Customer;
import com.nahalit.realestateapimanager.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> getAllCustomer() {
    return this.customerRepository.findAll();
  }

  public Customer getCustomer(Long customerNo) throws ResourceNotFoundException {
    return this.customerRepository.findById(customerNo).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id: " + customerNo));
  }

  public Customer saveCustomer(Customer customer) {
    return this.customerRepository.save(customer);
  }

  public Customer updateCustomer(Customer customer) throws ResourceNotFoundException {
    this.customerRepository.findById(customer.getCustomerNo()).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id: " + customer.getCustomerNo()));
    return this.customerRepository.save(customer);
  }

  public void deleteCustomer(Long customerNo) throws ResourceNotFoundException {
    this.customerRepository.findById(customerNo).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id: " + customerNo));
    this.customerRepository.deleteById(customerNo);
  }
}

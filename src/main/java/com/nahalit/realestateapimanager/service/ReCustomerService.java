package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.dao.CustomerDao;
import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.ReCustomer;
import com.nahalit.realestateapimanager.repository.ReCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReCustomerService {

  private ReCustomerRepository customerRepository;
  private CustomerDao customerDao;

  @Autowired
  public ReCustomerService(ReCustomerRepository customerRepository, CustomerDao customerDao) {
    this.customerRepository = customerRepository;
    this.customerDao = customerDao;
  }

  public List<ReCustomer> getAllCustomer() {
    return this.customerRepository.findAll();
  }

  public ReCustomer getCustomer(Long customerNo) throws ResourceNotFoundException {
    return this.customerRepository.findById(customerNo).orElseThrow(() -> new ResourceNotFoundException("ReCustomer not found for this id: " + customerNo));
  }

  public ReCustomer saveCustomer(ReCustomer customer) {
    return this.customerRepository.save(customer);
  }

  public ReCustomer updateCustomer(ReCustomer customer) throws ResourceNotFoundException {
    this.customerRepository.findById(customer.getCustomerNo()).orElseThrow(() -> new ResourceNotFoundException("ReCustomer not found for this id: " + customer.getCustomerNo()));
    return this.customerRepository.save(customer);
  }

  public void deleteCustomer(Long customerNo) throws ResourceNotFoundException {
    this.customerRepository.findById(customerNo).orElseThrow(() -> new ResourceNotFoundException("ReCustomer not found for this id: " + customerNo));
    this.customerRepository.deleteById(customerNo);
  }

  public Map<String, Object> customerLogin(String customerUsername, String password) {
    return customerDao.isCustomerLogin(customerUsername, password);
  }

  public String forgotPasswordByMail(String email) {
    return customerDao.forgotPasswordByMail(email);
  }
}

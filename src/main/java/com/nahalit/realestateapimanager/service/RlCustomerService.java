package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.dao.RlCustomerDao;
import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlCustomer;
import com.nahalit.realestateapimanager.repository.RlCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RlCustomerService {

  private RlCustomerRepository customerRepository;
  private RlCustomerDao rlCustomerDao;

  @Autowired
  public RlCustomerService(RlCustomerRepository customerRepository, RlCustomerDao rlCustomerDao) {
    this.customerRepository = customerRepository;
    this.rlCustomerDao = rlCustomerDao;
  }

  public List<RlCustomer> getAllCustomer() {
    return this.customerRepository.findAll();
  }

  public RlCustomer getCustomer(Long customerNo) throws ResourceNotFoundException {
    return this.customerRepository.findById(customerNo).orElseThrow(() -> new ResourceNotFoundException("RlCustomer not found for this id: " + customerNo));
  }

  public RlCustomer saveCustomer(RlCustomer customer) {
    return this.customerRepository.save(customer);
  }

  public RlCustomer updateCustomer(RlCustomer customer) throws ResourceNotFoundException {
    this.customerRepository.findById(customer.getCustomerNo()).orElseThrow(() -> new ResourceNotFoundException("RlCustomer not found for this id: " + customer.getCustomerNo()));
    return this.customerRepository.save(customer);
  }

  public void deleteCustomer(Long customerNo) throws ResourceNotFoundException {
    this.customerRepository.findById(customerNo).orElseThrow(() -> new ResourceNotFoundException("RlCustomer not found for this id: " + customerNo));
    this.customerRepository.deleteById(customerNo);
  }

  public Map<String, Object> customerLogin(String customerUsername, String password) {
    return rlCustomerDao.isCustomerLogin(customerUsername, password);
  }

  public String forgotPasswordByMail(String email) {
    return rlCustomerDao.forgotPasswordByMail(email);
  }
}

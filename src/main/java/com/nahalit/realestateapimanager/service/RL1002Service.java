package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.dao.RL1002Dao;
import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlCustomer;
import com.nahalit.realestateapimanager.repository.RlCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RL1002Service {

  private RlCustomerRepository customerRepository;
  private RL1002Dao RL1002Dao;

  @Autowired
  public RL1002Service(RlCustomerRepository customerRepository, RL1002Dao RL1002Dao) {
    this.customerRepository = customerRepository;
    this.RL1002Dao = RL1002Dao;
  }

  public List<RlCustomer> getAllCustomer() {
    return this.customerRepository.findAll(Sort.by("customerNo").ascending());
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
    return RL1002Dao.isCustomerLogin(customerUsername, password);
  }

  public String forgotPasswordByMail(String email) {
    return RL1002Dao.forgotPasswordByMail(email);
  }
}

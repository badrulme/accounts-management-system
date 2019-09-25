package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RL1002Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlCustomer;
import com.nahalit.nahalapimanager.repository.RlCustomerRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
public class RL1002Service {

  private RlCustomerRepository customerRepository;
  private com.nahalit.nahalapimanager.dao.RL1002Dao RL1002Dao;

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

  public RlCustomer saveCustomer(RlCustomer customer) throws ParseException {
    customer.setSsCreatedOn(UtillDate.getDateTime());
    customer.setSsModifiedOn(null);
    return this.customerRepository.save(customer);
  }

  public RlCustomer updateCustomer(RlCustomer customer) throws ResourceNotFoundException, ParseException {
    RlCustomer oldData = this.customerRepository.findById(customer.getCustomerNo()).orElseThrow(() -> new ResourceNotFoundException("RlCustomer not found for this id: " + customer.getCustomerNo()));
    customer.setSsCreatedOn(oldData.getSsCreatedOn());
    customer.setSsModifiedOn(UtillDate.getDateTime());
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
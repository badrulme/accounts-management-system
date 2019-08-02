package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.Customer;
import com.nahalit.realestateapimanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/customer")
@RestController
public class CustomerController {
  @Autowired
  CustomerService customerService;

  @GetMapping("/")
  public ResponseEntity<List<Customer>> getAllCustomer() {
    return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
  }

  @GetMapping("/get-customer")
  public ResponseEntity<Customer> getCustomer(@RequestParam(value = "customerNo", required = false) Long customerNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(customerService.getCustomer(customerNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Customer> saveCustoemr(@Valid @RequestBody Customer customer) {
    return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Customer> updateCustoemr(@Valid @RequestBody Customer customer) throws ResourceNotFoundException {
    return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteCustoemr(@RequestParam Long customerNo) throws ResourceNotFoundException {
    customerService.deleteCustomer(customerNo);
    return new ResponseEntity<>("Customer Deleted Successfully", HttpStatus.OK);
  }
}


package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.Customer;
import com.nahalit.realestateapimanager.service.CustomerService;
import com.nahalit.realestateapimanager.service.EmailService;
import com.nahalit.realestateapimanager.storage.StorageService;
import com.nahalit.realestateapimanager.utillibrary.UtillDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/customer")
@RestController
public class CustomerController {

  private final CustomerService customerService;
  private final StorageService storageService;
  private final EmailService emailService;

  public CustomerController(CustomerService customerService, StorageService storageService, EmailService emailService) {
    this.customerService = customerService;
    this.storageService = storageService;
    this.emailService = emailService;
  }

  @GetMapping("/")
  public ResponseEntity<List<Customer>> getAllCustomer() {
    return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
  }

  @GetMapping("/get-customer")
  public ResponseEntity<Customer> getCustomer(@RequestParam(value = "customerNo", required = false) Long customerNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(customerService.getCustomer(customerNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Customer> saveCustoemr(@Valid @RequestParam(value = "customerPhoto", required = false) MultipartFile customerPhoto, Customer customer) {
    if (customerPhoto != null) {
      UtillDate now = new UtillDate();
      String nowTime = now.getFormatDateTimeForFile();
      String filename = StringUtils.cleanPath(customerPhoto.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");

      storageService.store(customerPhoto, filename);
      customer.setUserImageName(filename);
    }
    return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Customer> updateCustoemr(@Valid @RequestParam(value = "customerPhoto", required = false) MultipartFile customerPhoto, @RequestParam Customer customer) throws ResourceNotFoundException {
    if (customerPhoto != null) {
      if (customer.getUserImageName() != null) {
        storageService.store(customerPhoto, customer.getUserImageName());
      } else {
        UtillDate now = new UtillDate();
        String nowTime = now.getFormatDateTimeForFile();
        String filename = StringUtils.cleanPath(customerPhoto.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");
        storageService.store(customerPhoto, filename);
        customer.setUserImageName(filename);
      }
    }
    return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteCustoemr(@RequestParam Long customerNo) throws ResourceNotFoundException {
    customerService.deleteCustomer(customerNo);
    return new ResponseEntity<>("Customer Deleted Successfully", HttpStatus.OK);
  }


}


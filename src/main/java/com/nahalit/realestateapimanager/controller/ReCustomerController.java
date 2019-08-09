package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.ReCustomer;
import com.nahalit.realestateapimanager.service.ReCustomerService;
import com.nahalit.realestateapimanager.storage.StorageService;
import com.nahalit.realestateapimanager.utillibrary.RandomString;
import com.nahalit.realestateapimanager.utillibrary.UtillDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("api/rest/re/customer")
@RestController
public class ReCustomerController {
  private final ReCustomerService reCustomerService;
  private final StorageService storageService;

  public ReCustomerController(ReCustomerService reCustomerService, StorageService storageService) {
    this.reCustomerService = reCustomerService;
    this.storageService = storageService;
  }

  @GetMapping("/")
  public ResponseEntity<List<ReCustomer>> getAllCustomer() {
    return new ResponseEntity<>(reCustomerService.getAllCustomer(), HttpStatus.OK);
  }

  @GetMapping("/get-customer")
  public ResponseEntity<ReCustomer> getCustomer(@RequestParam(value = "customerNo", required = false) Long customerNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(reCustomerService.getCustomer(customerNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<ReCustomer> saveCustoemr(@Valid @RequestParam(value = "customerPhoto", required = false) MultipartFile customerPhoto, ReCustomer customer) {
    if (customerPhoto != null) {
      String nowTime = UtillDate.getNowTimeNameForFile();
      String filename = StringUtils.cleanPath(customerPhoto.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");

      storageService.store(customerPhoto, filename);
      customer.setCustomerImageName(filename);
    }
    return new ResponseEntity<>(reCustomerService.saveCustomer(customer), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<ReCustomer> updateCustomer(@Valid @RequestParam(value = "customerPhoto", required = false) MultipartFile customerPhoto, ReCustomer customer) throws ResourceNotFoundException {
    if (customerPhoto != null) {
      if (customer.getCustomerImageName() != null) {
        storageService.store(customerPhoto, customer.getCustomerImageName());
      } else {
        String nowTime = UtillDate.getNowTimeNameForFile();
        String filename = StringUtils.cleanPath(customerPhoto.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");
        storageService.store(customerPhoto, filename);
        customer.setCustomerImageName(filename);
      }
    }
    return new ResponseEntity<>(reCustomerService.updateCustomer(customer), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteCustoemr(@RequestParam Long customerNo) throws ResourceNotFoundException {
    reCustomerService.deleteCustomer(customerNo);
    return new ResponseEntity<>("Customer Deleted Successfully", HttpStatus.OK);
  }

  @PostMapping("/login")
  public Map<String, Object> loginUser(@Valid @RequestParam String customerUsername, @RequestParam String password) {
    return reCustomerService.customerLogin(customerUsername, password);
  }

  @PostMapping("/forgot-password")
  public String forgotPassword(@Valid @RequestParam String forgotMailOrMobile) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    if (forgotMailOrMobile.matches(regex)) {
      return reCustomerService.forgotPasswordByMail(forgotMailOrMobile);
    } else
      return "Not email: " + RandomString.randomAlphaNumeric(8);
  }
}


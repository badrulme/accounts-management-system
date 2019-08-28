package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlCustomer;
import com.nahalit.realestateapimanager.service.RL1002Service;
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

@RequestMapping("api/rest/rl/customer")
@RestController
public class RL1002Controller {
  private final RL1002Service RL1002Service;
  private final StorageService storageService;

  public RL1002Controller(RL1002Service RL1002Service, StorageService storageService) {
    this.RL1002Service = RL1002Service;
    this.storageService = storageService;
  }

  @GetMapping("/")
  public ResponseEntity<List<RlCustomer>> getAllCustomer() {
    return new ResponseEntity<>(RL1002Service.getAllCustomer(), HttpStatus.OK);
  }

  @GetMapping("/get-customer")
  public ResponseEntity<RlCustomer> getCustomer(@RequestParam(value = "customerNo", required = false) Long customerNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(RL1002Service.getCustomer(customerNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<RlCustomer> saveCustomer(@Valid @RequestParam(value = "customerPhoto", required = false) MultipartFile customerPhoto, RlCustomer customer) {
    if (customerPhoto != null) {
      String nowTime = UtillDate.getNowTimeNameForImage();
      String filename = StringUtils.cleanPath(customerPhoto.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");
      storageService.store(customerPhoto, filename);
      customer.setCustomerPictureName(filename);
    }
    return new ResponseEntity<>(RL1002Service.saveCustomer(customer), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<RlCustomer> updateCustomer(@Valid @RequestParam(value = "customerPhoto", required = false) MultipartFile customerPhoto, RlCustomer customer) throws ResourceNotFoundException {
    if (customerPhoto != null) {
      if (customer.getCustomerPictureName() != null) {
        storageService.store(customerPhoto, customer.getCustomerPictureName());
      } else {
        String nowTime = UtillDate.getNowTimeNameForImage();
        String filename = StringUtils.cleanPath(customerPhoto.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");
        storageService.store(customerPhoto, filename);
        customer.setCustomerPictureName(filename);
      }
    }
    return new ResponseEntity<>(RL1002Service.updateCustomer(customer), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteCustoemr(@RequestParam Long customerNo) throws ResourceNotFoundException {
    RL1002Service.deleteCustomer(customerNo);
    return new ResponseEntity<>("Customer Deleted Successfully", HttpStatus.OK);
  }

  @PostMapping("/login")
  public Map<String, Object> loginCustomer(@Valid @RequestParam String customerUsername, @RequestParam String password) {
    return RL1002Service.customerLogin(customerUsername, password);
  }

  @PostMapping("/forgot-password")
  public String forgotPassword(@Valid @RequestParam String forgotMailOrMobile) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    if (forgotMailOrMobile.matches(regex)) {
      return RL1002Service.forgotPasswordByMail(forgotMailOrMobile);
    } else
      return "Not email: " + RandomString.randomAlphaNumeric(8);
  }
}


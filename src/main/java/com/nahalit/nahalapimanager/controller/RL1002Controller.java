package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.model.RlCustomer;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.SaLookupdtl;
import com.nahalit.nahalapimanager.service.RL1002Service;
import com.nahalit.nahalapimanager.service.SA1004Service;
import com.nahalit.nahalapimanager.storage.StorageService;
import com.nahalit.nahalapimanager.utillibrary.RandomString;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RequestMapping("api/rest/rl/customer")
@RestController
public class RL1002Controller {
  private final RL1002Service rL1002Service;
  private final StorageService storageService;
  private final SA1004Service sa1004Service;

  public RL1002Controller(RL1002Service rL1002Service, StorageService storageService, SA1004Service sa1004Service) {
    this.rL1002Service = rL1002Service;
    this.storageService = storageService;
    this.sa1004Service = sa1004Service;
  }

  @GetMapping("/")
  public ResponseEntity<List<RlCustomer>> getAllCustomer() {
    return new ResponseEntity<>(rL1002Service.getAllCustomer(), HttpStatus.OK);
  }

  @GetMapping("/get-customer")
  public ResponseEntity<RlCustomer> getCustomer(@RequestParam(value = "customerNo", required = false) Long customerNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(rL1002Service.getCustomer(customerNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<RlCustomer> saveCustomer(@Valid @RequestParam(value = "customerPhoto", required = false) MultipartFile customerPhoto, RlCustomer customer) throws ParseException {
    if (customerPhoto != null) {
      String nowTime = UtillDate.getNowTimeNameForImage();
      String filename = StringUtils.cleanPath(customerPhoto.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");
      storageService.store(customerPhoto, filename);
      customer.setCustomerPictureName(filename);
    }
    return new ResponseEntity<>(rL1002Service.saveCustomer(customer), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<RlCustomer> updateCustomer(@Valid @RequestParam(value = "customerPhoto", required = false) MultipartFile customerPhoto, RlCustomer customer) throws ResourceNotFoundException, ParseException {
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
    return new ResponseEntity<>(rL1002Service.updateCustomer(customer), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteCustoemr(@RequestParam Long customerNo) throws ResourceNotFoundException, IOException {
    rL1002Service.deleteCustomer(customerNo);
    return new ResponseEntity<>("Customer Deleted Successfully", HttpStatus.OK);
  }

  @PostMapping("/login")
  public Map<String, Object> loginCustomer(@Valid @RequestParam String customerUsername, @RequestParam String password) {
    return rL1002Service.customerLogin(customerUsername, password);
  }

  @PostMapping("/forgot-password")
  public String forgotPassword(@Valid @RequestParam String forgotMailOrMobile) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    if (forgotMailOrMobile.matches(regex)) {
      return rL1002Service.forgotPasswordByMail(forgotMailOrMobile);
    } else
      return "Not email: " + RandomString.randomAlphaNumeric(8);
  }

}


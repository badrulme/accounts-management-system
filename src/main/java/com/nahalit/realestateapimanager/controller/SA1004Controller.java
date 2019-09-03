package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.SaLookup;
import com.nahalit.realestateapimanager.model.SaLookupdtl;
import com.nahalit.realestateapimanager.service.SA1004Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/rest/setting")
@Controller
public class SA1004Controller {
  private SA1004Service sa1004Service;

  public SA1004Controller(SA1004Service sa1004Service) {
    this.sa1004Service = sa1004Service;
  }

  // Lookup Information
  @GetMapping("/lookup/")
  public ResponseEntity<List<SaLookup>> getAllLookup() {
    return new ResponseEntity<>(this.sa1004Service.getAllLookup(), HttpStatus.OK);
  }

  @GetMapping("/lookup/get-lookup")
  public ResponseEntity<SaLookup> getLookup(@RequestParam Long lookupNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(this.sa1004Service.getLookup(lookupNo), HttpStatus.OK);
  }

  @PostMapping("/lookup/add")
  public ResponseEntity<SaLookup> saveLookup(@RequestBody SaLookup saLookup) {
    return new ResponseEntity<>(this.sa1004Service.saveLookup(saLookup), HttpStatus.CREATED);
  }

  @PutMapping("/lookup/update")
  public ResponseEntity<SaLookup> updateLookup(@RequestBody SaLookup saLookup) throws ResourceNotFoundException {
    return new ResponseEntity<>(this.sa1004Service.updateLookup(saLookup), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/lookup/delete")
  public ResponseEntity<String> deleLookup(@RequestParam Long lookupNo) throws ResourceNotFoundException {
    this.sa1004Service.deleteLookup(lookupNo);
    return new ResponseEntity<>("Lookup deleted successfully.", HttpStatus.OK);
  }

  // Lookup DTL information
  @GetMapping("/lookupdtl/")
  public ResponseEntity<List<SaLookupdtl>> getAllLookupdtl() {
    return new ResponseEntity<>(this.sa1004Service.getAllLookupdtl(), HttpStatus.OK);
  }

  @GetMapping("/lookupdtl/list")
  public ResponseEntity<List<SaLookupdtl>> getAllLookupdtlList(@RequestParam Long lookupNo) {
    return new ResponseEntity<>(this.sa1004Service.getAllLookupdtlList(lookupNo), HttpStatus.OK);
  }

  @GetMapping("/lookupdtl/get-lookupdtl")
  public ResponseEntity<SaLookupdtl> getLookupdtl(@RequestParam Long lookupdtlNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(this.sa1004Service.getLookupdtl(lookupdtlNo), HttpStatus.OK);
  }

  @PostMapping("/lookupdtl/add")
  public ResponseEntity<SaLookupdtl> saveLookupdtl(@RequestBody SaLookupdtl saLookupdtl) {
    return new ResponseEntity<>(this.sa1004Service.saveLookupdtl(saLookupdtl), HttpStatus.CREATED);
  }

  @PostMapping("/lookupdtl/add-list")
  public ResponseEntity<List<SaLookupdtl>> saveLookupdtlList(@RequestBody List<SaLookupdtl> saLookupdtls) {
    return new ResponseEntity<>(this.sa1004Service.saveLookupdtlList(saLookupdtls), HttpStatus.CREATED);
  }

  @PutMapping("/lookupdtl/update")
  public ResponseEntity<SaLookupdtl> updateLookupdtl(@RequestBody SaLookupdtl saLookupdtl) throws ResourceNotFoundException {
    return new ResponseEntity<>(this.sa1004Service.updateLookupdtl(saLookupdtl), HttpStatus.ACCEPTED);
  }

  @PutMapping("/lookupdtl/update-list")
  public ResponseEntity<List<SaLookupdtl>> updateLookupdtlList(@RequestBody List<SaLookupdtl> saLookupdtls) throws ResourceNotFoundException {
    return new ResponseEntity<>(this.sa1004Service.updateLookupdtlList(saLookupdtls), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/lookupdtl/delete")
  public ResponseEntity<String> deleLookupdtl(@RequestParam Long lookupNo) throws ResourceNotFoundException {
    this.sa1004Service.deleteLookupdtl(lookupNo);
    return new ResponseEntity<>("Lookupdtl deleted successfully.", HttpStatus.OK);
  }

  @DeleteMapping("/lookupdtl/delete-list")
  public ResponseEntity<String> deleLookupdtlList(@RequestBody List<SaLookupdtl> saLookupdtls) throws ResourceNotFoundException {
    this.sa1004Service.deleteLookupdtlList(saLookupdtls);
    return new ResponseEntity<>("Lookupdtl deleted successfully.", HttpStatus.OK);
  }
}

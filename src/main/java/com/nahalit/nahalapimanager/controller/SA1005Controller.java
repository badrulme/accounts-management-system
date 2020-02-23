package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.SaRole;
import com.nahalit.nahalapimanager.model.SaRoledtl;
import com.nahalit.nahalapimanager.service.SA1005Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/rest/sa")
public class SA1005Controller {

  private final SA1005Service sa1005Service;

  public SA1005Controller(SA1005Service sa1005Service) {
    this.sa1005Service = sa1005Service;
  }

  // SA ROLE Controller
  @GetMapping("/role/")
  public ResponseEntity<List<SaRole>> getAllSaRole() {
    return new ResponseEntity<>(sa1005Service.getAllSaRole(), HttpStatus.OK);
  }

  @GetMapping("/get-sa-menu-list")
  public ResponseEntity<List> getMenuList(@Valid @RequestParam("submenuType") String submenuType, @Valid @RequestParam(value = "roleNo", required = false) Long roleNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(this.sa1005Service.getMenuList(submenuType, roleNo), HttpStatus.OK);
  }

  @GetMapping("/role/get-sa-role")
  public ResponseEntity<SaRole> getSaRole(@Valid @RequestParam("roleNo") Long roleNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(sa1005Service.getSaRole(roleNo), HttpStatus.OK);
  }

  @PostMapping("/role/add")
  public ResponseEntity<SaRole> saveSaRole(@RequestBody SaRole saRole) throws ParseException {
    return new ResponseEntity<>(sa1005Service.saveSaRole(saRole), HttpStatus.CREATED);
  }

  @PostMapping("/role/add-list")
  public ResponseEntity<List<SaRole>> saveSaRoleList(@RequestBody List<SaRole> saRoleList) {
    return new ResponseEntity<>(sa1005Service.saveSaRoleList(saRoleList), HttpStatus.CREATED);
  }

  @PutMapping("/role/update")
  public ResponseEntity<SaRole> updateSaRole(@RequestBody SaRole saRole) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(sa1005Service.updateSaRole(saRole), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/role/delete")
  public ResponseEntity<Map> deleteSaRole(@RequestParam Long roleNo) {
    return new ResponseEntity<>(this.sa1005Service.deleteSaRole(roleNo), HttpStatus.OK);
  }

  // SA ROLEDTL Controller
  @GetMapping("/roledtl/")
  public ResponseEntity<List<SaRoledtl>> getAllSaRoledtl() {
    return new ResponseEntity<>(sa1005Service.getAllSaRoledtl(), HttpStatus.OK);
  }

  @GetMapping("/roledtl/get-sa-roledtl")
  public ResponseEntity<SaRoledtl> getSaRoledtl(@Valid @RequestParam("roledtlNo") Long roledtlNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(sa1005Service.getSaRoledtl(roledtlNo), HttpStatus.OK);
  }

  @PostMapping("/roledtl/add")
  public ResponseEntity<SaRoledtl> saveSaRoledtl(@RequestBody SaRoledtl saRoledtl) throws ParseException {
    return new ResponseEntity<>(sa1005Service.saveSaRoledtl(saRoledtl), HttpStatus.CREATED);
  }

  @PostMapping("/roledtl/add-list")
  public ResponseEntity<List<SaRoledtl>> saveSaRoledtlList(@RequestBody List<SaRoledtl> saRoledtlList) {
    return new ResponseEntity<>(sa1005Service.saveSaRoledtlList(saRoledtlList), HttpStatus.CREATED);
  }

  @PutMapping("/roledtl/update")
  public ResponseEntity<SaRoledtl> updateSaRoledtl(@RequestBody SaRoledtl saRoledtl) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(sa1005Service.updateSaRoledtl(saRoledtl), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/roledtl/delete")
  public ResponseEntity<Map> deleteSaRoledtl(@RequestParam Long roledtlNo) {
    return new ResponseEntity<>(this.sa1005Service.deleteSaRoledtl(roledtlNo), HttpStatus.OK);
  }

}

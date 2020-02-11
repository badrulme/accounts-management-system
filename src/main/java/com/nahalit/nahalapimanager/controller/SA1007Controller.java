package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.SaUser;
import com.nahalit.nahalapimanager.service.SA1007Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/rest/sa/user")
public class SA1007Controller {
  
  private final SA1007Service sa1007Service;

  public SA1007Controller(SA1007Service sa1007Service) {
    this.sa1007Service = sa1007Service;
  }

  // SA USER Controller
  @GetMapping("/")
  public ResponseEntity<List<SaUser>> getAllSaUser() {
    return new ResponseEntity<>(sa1007Service.getAllSaUser(), HttpStatus.OK);
  }

  @GetMapping("/get-sa-user")
  public ResponseEntity<SaUser> getSaUser(@Valid @RequestParam("userNo") Long userNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(sa1007Service.getSaUser(userNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<SaUser> saveSaUser(@RequestBody SaUser saUser) throws ParseException {
    return new ResponseEntity<>(sa1007Service.saveSaUser(saUser), HttpStatus.CREATED);
  }

  @PostMapping("/add-list")
  public ResponseEntity<List<SaUser>> saveSaUserList(@RequestBody List<SaUser> saUserList) {
    return new ResponseEntity<>(sa1007Service.saveSaUserList(saUserList), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<SaUser> updateSaUser(@RequestBody SaUser saUser) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(sa1007Service.updateSaUser(saUser), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Map> deleteSaUser(@RequestParam Long userNo) {
    return new ResponseEntity<>(this.sa1007Service.deleteSaUser(userNo), HttpStatus.OK);
  }
}

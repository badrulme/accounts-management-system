package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.HrEmp;
import com.nahalit.nahalapimanager.service.HR1002Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/rest/hr-emp")
public class HR1002Controller {
  private final HR1002Service hr1002Service;

  public HR1002Controller(HR1002Service hr1002Service) {
    this.hr1002Service = hr1002Service;
  }

  // HR EMP Controller
  @GetMapping("/")
  public ResponseEntity<List<HrEmp>> getAllHrEmp() {
    return new ResponseEntity<>(hr1002Service.getAllHrEmp(), HttpStatus.OK);
  }

  @GetMapping("/get-hr-emp")
  public ResponseEntity<HrEmp> getHrEmp(@Valid @RequestParam("empNo") Long empNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(hr1002Service.getHrEmp(empNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<HrEmp> saveHrEmp(@RequestBody HrEmp hrEmp) throws ParseException {
    return new ResponseEntity<>(hr1002Service.saveHrEmp(hrEmp), HttpStatus.CREATED);
  }

  @PostMapping("/add-list")
  public ResponseEntity<List<HrEmp>> saveHrEmpList(@RequestBody List<HrEmp> hrEmpList) {
    return new ResponseEntity<>(hr1002Service.saveHrEmpList(hrEmpList), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<HrEmp> updateHrEmp(@RequestBody HrEmp hrEmp) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(hr1002Service.updateHrEmp(hrEmp), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Map> deleteHrEmp(@RequestParam Long empNo) {
    return new ResponseEntity<>(this.hr1002Service.deleteHrEmp(empNo), HttpStatus.OK);
  }
}

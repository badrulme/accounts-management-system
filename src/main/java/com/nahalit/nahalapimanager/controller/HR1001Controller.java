package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.HrBu;
import com.nahalit.nahalapimanager.model.HrJobtitle;
import com.nahalit.nahalapimanager.service.HR1001Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/rest/hr/configuration")
public class HR1001Controller {
  private final HR1001Service hr1001Service;

  public HR1001Controller(HR1001Service hr1001Service) {
    this.hr1001Service = hr1001Service;
  }

  // HR JOBTITLE Controller
  @GetMapping("/jobtitle/")
  public ResponseEntity<List<HrJobtitle>> getAllHrJobtitle() {
    return new ResponseEntity<>(hr1001Service.getAllHrJobtitle(), HttpStatus.OK);
  }

  @GetMapping("/jobtitle/get-hr-jobtitle")
  public ResponseEntity<HrJobtitle> getHrJobtitle(@Valid @RequestParam("jobtitleNo") Long jobtitleNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(hr1001Service.getHrJobtitle(jobtitleNo), HttpStatus.OK);
  }

  @PostMapping("/jobtitle/add")
  public ResponseEntity<HrJobtitle> saveHrJobtitle(@RequestBody HrJobtitle hrJobtitle) throws ParseException {
    return new ResponseEntity<>(hr1001Service.saveHrJobtitle(hrJobtitle), HttpStatus.CREATED);
  }

  @PostMapping("/jobtitle/add-list")
  public ResponseEntity<List<HrJobtitle>> saveHrJobtitleList(@RequestBody List<HrJobtitle> hrJobtitleList) {
    return new ResponseEntity<>(hr1001Service.saveHrJobtitleList(hrJobtitleList), HttpStatus.CREATED);
  }

  @PutMapping("/jobtitle/update")
  public ResponseEntity<HrJobtitle> updateHrJobtitle(@RequestBody HrJobtitle hrJobtitle) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(hr1001Service.updateHrJobtitle(hrJobtitle), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/jobtitle/delete")
  public ResponseEntity<Map> deleteHrJobtitle(@RequestParam Long jobtitleNo) {
    return new ResponseEntity<>(this.hr1001Service.deleteHrJobtitle(jobtitleNo), HttpStatus.OK);
  }

  // HR BU Controller
  @GetMapping("/hr-bu/")
  public ResponseEntity<List<HrBu>> getAllHrBu() {
    return new ResponseEntity<>(hr1001Service.getAllHrBu(), HttpStatus.OK);
  }

  @GetMapping("/hr-bu/get-hr-bu")
  public ResponseEntity<HrBu> getHrBu(@Valid @RequestParam("buNo") Long buNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(hr1001Service.getHrBu(buNo), HttpStatus.OK);
  }

  @PostMapping("/hr-bu/add")
  public ResponseEntity<HrBu> saveHrBu(@RequestBody HrBu hrBu) throws ParseException {
    return new ResponseEntity<>(hr1001Service.saveHrBu(hrBu), HttpStatus.CREATED);
  }

  @PostMapping("/hr-bu/add-list")
  public ResponseEntity<List<HrBu>> saveHrBuList(@RequestBody List<HrBu> hrBuList) {
    return new ResponseEntity<>(hr1001Service.saveHrBuList(hrBuList), HttpStatus.CREATED);
  }

  @PutMapping("/hr-bu/update")
  public ResponseEntity<HrBu> updateHrBu(@RequestBody HrBu hrBu) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(hr1001Service.updateHrBu(hrBu), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/hr-bu/delete")
  public ResponseEntity<Map> deleteHrBu(@RequestParam Long buNo) {
    return new ResponseEntity<>(this.hr1001Service.deleteHrBu(buNo), HttpStatus.OK);
  }
}

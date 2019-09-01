package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlRajukApproval;
import com.nahalit.realestateapimanager.service.RL1001Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/configuration")
@RestController
public class RL1001Controller {
  private final RL1001Service rl1001Service;

  public RL1001Controller(RL1001Service rl1001Service) {
    this.rl1001Service = rl1001Service;
  }

  // RL Rajuk Approval Controller
  @GetMapping("/rajuk-approval/")
  public ResponseEntity<List<RlRajukApproval>> getAllRajukApproval() {
    return new ResponseEntity<>(rl1001Service.getAllRajukApproval(), HttpStatus.OK);
  }

  @GetMapping("/rajuk-approval/get-item-category")
  public ResponseEntity<RlRajukApproval> getRajukApproval(@Valid @RequestParam("approvalNo") Long approvalNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(rl1001Service.getRajukApproval(approvalNo), HttpStatus.OK);
  }

  @PostMapping("/rajuk-approval/add")
  public ResponseEntity<RlRajukApproval> saveRajukApproval(RlRajukApproval rlRajukApproval) {
    return new ResponseEntity<>(rl1001Service.saveRajukApproval(rlRajukApproval), HttpStatus.CREATED);
  }

  @PutMapping("/rajuk-approval/update")
  public ResponseEntity<RlRajukApproval> updateRajukApproval(RlRajukApproval rlRajukApproval) throws ResourceNotFoundException {
    return new ResponseEntity<>(rl1001Service.updateRajukApproval(rlRajukApproval), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/rajuk-approval/delete")
  public ResponseEntity<String> deleteRajukApproval(@RequestParam Long approvalNo) {
    this.rl1001Service.deleteRajukApproval(approvalNo);
    return new ResponseEntity<>("Rajuk Approval Deleted Successfully.", HttpStatus.OK);
  }
}

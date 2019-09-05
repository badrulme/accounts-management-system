package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlFacing;
import com.nahalit.realestateapimanager.model.RlRajukApproval;
import com.nahalit.realestateapimanager.service.RL1001Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RequestMapping("api/rest/rl/configuration")
@RestController
public class RL1001Controller {
  private final RL1001Service rl1001Service;

  public RL1001Controller(RL1001Service rl1001Service) {
    this.rl1001Service = rl1001Service;
  }


  // RL Facing Setup Controller
  @GetMapping("/facing/")
  public ResponseEntity<List<RlFacing>> getAllfacing() {
    return new ResponseEntity<>(rl1001Service.getAllFacing(), HttpStatus.OK);
  }

  @GetMapping("/facing/get-item-category")
  public ResponseEntity<RlFacing> getFacing(@Valid @RequestParam("facingNo") Long facingNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(rl1001Service.getFacing(facingNo), HttpStatus.OK);
  }

  @PostMapping("/facing/add")
  public ResponseEntity<RlFacing> saveFacing(@RequestBody RlFacing rlFacing) throws ParseException {
    return new ResponseEntity<>(rl1001Service.saveFacing(rlFacing), HttpStatus.CREATED);
  }

  @PutMapping("/facing/update")
  public ResponseEntity<RlFacing> updateFacing(@RequestBody RlFacing rlFacing) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(rl1001Service.updateFacing(rlFacing), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/facing/delete")
  public ResponseEntity<String> deleteFacing(@RequestParam Long facingNo) {
    this.rl1001Service.deleteFacing(facingNo);
    return new ResponseEntity<>("Facing Deleted Successfully.", HttpStatus.OK);
  }
}

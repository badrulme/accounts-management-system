package com.nahalit.nahalapimanager.controller;


import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.service.RL1019Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/rest/rl/trn")
@RestController
public class RL1019Controller {
  private final RL1019Service rl1019Service;

  public RL1019Controller(RL1019Service rl1019Service) {
    this.rl1019Service = rl1019Service;
  }

  @GetMapping("/")
  public ResponseEntity<List> getAllTrn(@RequestParam(required = false) String trnNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(this.rl1019Service.getAllTransaction(trnNo), HttpStatus.OK);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Map> deleteRajukApproval(@RequestParam String trnNo) {
    return new ResponseEntity<>(this.rl1019Service.deleteRlTrn(trnNo), HttpStatus.OK);
  }
}

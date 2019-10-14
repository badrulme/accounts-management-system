package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.AppResponse;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlFacing;
import com.nahalit.nahalapimanager.service.RL1001Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


@RequestMapping(value = {"api/rest/rl/configuration"})
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

  @PostMapping("/facing/add-list")
  public ResponseEntity<List<RlFacing>> saveFacingList(@RequestBody List<RlFacing> rlFacingList) {
    return new ResponseEntity<>(rl1001Service.saveFacingList(rlFacingList), HttpStatus.CREATED);
  }

  @PutMapping("/facing/update")
  public ResponseEntity<RlFacing> updateFacing(@RequestBody RlFacing rlFacing) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(rl1001Service.updateFacing(rlFacing), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/facing/delete")
  public ResponseEntity<Map> deleteFacing(@RequestParam Long facingNo) {

    return new ResponseEntity<>(this.rl1001Service.deleteFacing(facingNo), HttpStatus.OK);
  }
}

package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlItem;
import com.nahalit.nahalapimanager.service.RL1007Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("api/rest/rl/item/land")
@RestController
public class RL1007Controller {

  private final RL1007Service rl1007Service;

  public RL1007Controller(RL1007Service rl1007Service) {
    this.rl1007Service = rl1007Service;
  }

  // RL Item Controller
  @GetMapping("/")
  public ResponseEntity<List> getAllLandItem(@RequestParam(value = "itemNo", required = false) Long itemNo) {
    return new ResponseEntity<>(this.rl1007Service.getAllLandItem(itemNo), HttpStatus.OK);
  }

  @GetMapping("/get-item")
  public ResponseEntity<Object> getALandItem(@RequestParam Long itemNo) {
    return new ResponseEntity<>(this.rl1007Service.getLandItem(itemNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<RlItem> saveLandItem(@RequestBody RlItem rlItem) throws ParseException {
    return new ResponseEntity<>(this.rl1007Service.saveLandRlItem(rlItem), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<RlItem> updateLandItem(@RequestBody RlItem reItem) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(rl1007Service.updateLandRlItem(reItem), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteLandItem(@RequestParam Long itemNo) {
    this.rl1007Service.deleteLandRlItem(itemNo);
    return new ResponseEntity<>("Land Item Deleted Successfully.", HttpStatus.OK);
  }
}

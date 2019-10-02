package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlItem;
import com.nahalit.nahalapimanager.service.RL1005Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RequestMapping("api/rest/rl/item/ap")
@RestController
public class RL1005Controller {

  private final RL1005Service rL1005Service;

  @Autowired
  public RL1005Controller(RL1005Service RL1005Service) {
    this.rL1005Service = RL1005Service;
  }

  // RL Item Controller
  @GetMapping("/")
  public ResponseEntity<List<RlItem>> getAllItem() {
    return new ResponseEntity<>(this.rL1005Service.getAllApItem(), HttpStatus.OK);
  }

  @GetMapping("/get-item-ref")
  public ResponseEntity<Map> getApItemRef(@RequestParam(required = false) Long itemNo) {
    return new ResponseEntity<>(this.rL1005Service.getApItemRef(itemNo), HttpStatus.OK);
  }

  @GetMapping("/get-item")
  public ResponseEntity<RlItem> getAPItem(@RequestParam Long itemNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(this.rL1005Service.getApItem(itemNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<RlItem> saveItem(@RequestBody RlItem rlItem) throws ParseException {
    return new ResponseEntity<>(this.rL1005Service.saveApRlItem(rlItem), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<RlItem> updateItem(@RequestBody RlItem reItem) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(rL1005Service.updateApRlItem(reItem), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteItem(@RequestParam Long itemNo) {
    this.rL1005Service.deleteApRlItem(itemNo);
    return new ResponseEntity<>("Land Item Deleted Successfully.", HttpStatus.OK);
  }


}

package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlContact;
import com.nahalit.nahalapimanager.service.RlContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RequestMapping("api/rest/rl/contact/")
@RestController
public class RlContactController {
  private final RlContactService rlContactService;

  public RlContactController(RlContactService rlContactService) {
    this.rlContactService = rlContactService;
  }

  // RL Item Contact Controller
  @GetMapping("/")
  public ResponseEntity<List<RlContact>> getAllRlContact() {
    return new ResponseEntity<>(this.rlContactService.getAllRlContact(), HttpStatus.OK);
  }

  @GetMapping("/get-contact")
  public ResponseEntity<RlContact> getContact(@Valid @RequestParam("contactNo") Long contactNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(this.rlContactService.getRlContact(contactNo), HttpStatus.OK);
  }


  @PostMapping("/add")
  public ResponseEntity<RlContact> saveContact(@RequestBody RlContact reItemContact)  {
    return new ResponseEntity<>(this.rlContactService.saveRlContact(reItemContact), HttpStatus.CREATED);
  }


  @PutMapping("/update")
  public ResponseEntity<RlContact> updateContact(@RequestBody RlContact reItemContact)  {
    return new ResponseEntity<>(this.rlContactService.updateRlContact(reItemContact), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Map> deleteContact(@RequestParam Long contactNo) {

    return new ResponseEntity<>(this.rlContactService.deleteRlContact(contactNo), HttpStatus.OK);
  }

}

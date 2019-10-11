package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlPropertyContact;
import com.nahalit.nahalapimanager.service.RlPropertyContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("api/rest/rl/property-contact/")
@RestController
public class RlPropertyContactController {
  private final RlPropertyContactService rlPropertyContactService;

  public RlPropertyContactController(RlPropertyContactService rlPropertyContactService) {
    this.rlPropertyContactService = rlPropertyContactService;
  }


  // RL Item Contact Controller
  @GetMapping("/")
  public ResponseEntity<List<RlPropertyContact>> getAllRlPropertyContact() {
    return new ResponseEntity<>(this.rlPropertyContactService.getAllRlContact(), HttpStatus.OK);
  }

  @GetMapping("/get-contact")
  public ResponseEntity<RlPropertyContact> getContact(@Valid @RequestParam("contactNo") Long contactNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(this.rlPropertyContactService.getRlContact(contactNo), HttpStatus.OK);
  }


  @PostMapping("/add")
  public ResponseEntity<RlPropertyContact> saveContact(@RequestBody RlPropertyContact reItemContact)  {
    return new ResponseEntity<>(this.rlPropertyContactService.saveRlContact(reItemContact), HttpStatus.CREATED);
  }


  @PutMapping("/update")
  public ResponseEntity<RlPropertyContact> updateContact(@RequestBody RlPropertyContact reItemContact)  {
    return new ResponseEntity<>(this.rlPropertyContactService.updateRlContact(reItemContact), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Map> deleteContact(@RequestParam Long contactNo) {

    return new ResponseEntity<>(this.rlPropertyContactService.deleteRlContact(contactNo), HttpStatus.OK);
  }

}

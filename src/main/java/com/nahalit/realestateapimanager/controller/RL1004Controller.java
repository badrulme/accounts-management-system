package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.model.RlItemInstallment;
import com.nahalit.realestateapimanager.model.RlItemVideo;
import com.nahalit.realestateapimanager.service.RL1004Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/item")
@RestController
public class RL1004Controller {

  private final RL1004Service RL1004Service;

  @Autowired
  public RL1004Controller(RL1004Service RL1004Service) {
    this.RL1004Service = RL1004Service;
  }

  // RL Item Controller
  @GetMapping("/")
  public ResponseEntity<List<RlItem>> getAllItem() {
    return new ResponseEntity<>(this.RL1004Service.getAllItem(), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<RlItem> saveItem(RlItem rlItem) {
    return new ResponseEntity<>(this.RL1004Service.saveRlItem(rlItem), HttpStatus.CREATED);
  }

  // RL Item Video Controller
  @GetMapping("/video/")
  public ResponseEntity<List<RlItemVideo>> getAllRlItemVideo() {
    return new ResponseEntity<>(RL1004Service.getAllRlItemVideo(), HttpStatus.OK);
  }

  @GetMapping("/video/get-item-video")
  public ResponseEntity<RlItemVideo> getItemVideo(@Valid @RequestParam("videoNo") Long installmentNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(RL1004Service.getRlItemVideo(installmentNo), HttpStatus.OK);
  }

  @PostMapping("/video/add")
  public ResponseEntity<RlItemVideo> saveItemVideo(RlItemVideo reItemVideo) {
    return new ResponseEntity<>(RL1004Service.saveRlItemVideo(reItemVideo), HttpStatus.CREATED);
  }

  @PutMapping("/video/update")
  public ResponseEntity<RlItemVideo> updateItemVideo(RlItemVideo reItemVideo) throws ResourceNotFoundException {
    return new ResponseEntity<>(RL1004Service.updateRlItemVideo(reItemVideo), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/video/delete")
  public ResponseEntity<String> deleteVideo(@RequestParam Long installmentNo) {
    this.RL1004Service.deleteRlItemVideo(installmentNo);
    return new ResponseEntity<>("Item Video Deleted Successfully.", HttpStatus.OK);
  }

  // RL Item Installment Controller
  @GetMapping("/installment/")
  public ResponseEntity<List<RlItemInstallment>> getAllInstallment() {
    return new ResponseEntity<>(RL1004Service.getAllRlItemInstallment(), HttpStatus.OK);
  }

  @GetMapping("/installment/get-item-installment")
  public ResponseEntity<RlItemInstallment> getItemInstallment(@Valid @RequestParam("installmentNo") Long installmentNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(RL1004Service.getRlItemInstallment(installmentNo), HttpStatus.OK);
  }

  @PostMapping("/installment/add")
  public ResponseEntity<RlItemInstallment> saveItemInstallment(RlItemInstallment reItemInstallment) {
    return new ResponseEntity<>(RL1004Service.saveRlItemInstallment(reItemInstallment), HttpStatus.CREATED);
  }

  @PutMapping("/installment/update")
  public ResponseEntity<RlItemInstallment> updateItemInstallment(RlItemInstallment reItemInstallment) throws ResourceNotFoundException {
    return new ResponseEntity<>(RL1004Service.updateRlItemInstallment(reItemInstallment), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/installment/delete")
  public ResponseEntity<String> deleteInstallment(@RequestParam Long installmentNo) {
    this.RL1004Service.deleteRlItemInstallment(installmentNo);
    return new ResponseEntity<>("Item Installment Deleted Successfully.", HttpStatus.OK);
  }
}

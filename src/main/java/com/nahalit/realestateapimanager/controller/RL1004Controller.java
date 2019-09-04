package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemSize;
import com.nahalit.realestateapimanager.model.RlProject;
import com.nahalit.realestateapimanager.service.RL1004Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/project/land")
@RestController
public class RL1004Controller {
  private final RL1004Service rl1004Service;

  public RL1004Controller(RL1004Service rl1004Service) {
    this.rl1004Service = rl1004Service;
  }

  @GetMapping("/")
  public ResponseEntity<List<RlProject>> getAllLandProject() {
    return new ResponseEntity<>(rl1004Service.getAllProject(), HttpStatus.OK);
  }

  @GetMapping("/get-project")
  public ResponseEntity<RlProject> getLandProject(@Valid @RequestParam("projectNo") Long projectNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(rl1004Service.getProject(projectNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<RlProject> saveLandProject(@RequestBody RlProject rlProject) {
    return new ResponseEntity<>(rl1004Service.saveRlProject(rlProject), HttpStatus.CREATED);
  }


  @PutMapping("/update")
  public ResponseEntity<RlProject> updateLandProject(@RequestBody RlProject rlProject) throws ResourceNotFoundException {
    return new ResponseEntity<>(rl1004Service.updateRlProject(rlProject), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteLandProject(@RequestParam Long projectNo) {
    this.rl1004Service.deleteRlProject(projectNo);
    return new ResponseEntity<>("Land Project Deleted Successfully.", HttpStatus.OK);
  }

  // Flat Type Wise Size setup
  @GetMapping("/size/")
  public ResponseEntity<List<RlItemSize>> getAllItemSize() {
    return new ResponseEntity<>(this.rl1004Service.getAllItemSize(), HttpStatus.OK);
  }

  @GetMapping("/size/get-item-size")
  public ResponseEntity<RlItemSize> getItemSize(@RequestParam Long sizeNo) {
    return new ResponseEntity<>(this.rl1004Service.getItemSize(sizeNo), HttpStatus.OK);
  }

  @GetMapping("/size/get-item-size-list")
  public ResponseEntity<List<RlItemSize>> getItemSizeList(@RequestParam Long projectNo) {
    return new ResponseEntity<>(this.rl1004Service.getAllItemSizeList(projectNo), HttpStatus.OK);
  }

  @PostMapping("/size/add")
  public ResponseEntity<RlItemSize> saveItemSize(@RequestBody RlItemSize rlItemSize) {
    return new ResponseEntity<>(this.rl1004Service.saveItemSize(rlItemSize), HttpStatus.CREATED);
  }

  @PostMapping("/size/add-list")
  public ResponseEntity<List<RlItemSize>> saveItemSizeList(@RequestBody List<RlItemSize> rlItemSizes) {
    return new ResponseEntity<>(this.rl1004Service.saveItemSizeList(rlItemSizes), HttpStatus.CREATED);
  }

  @PutMapping("/size/update")
  public ResponseEntity<RlItemSize> updateItemSize(@RequestBody RlItemSize rlItemSize) {
    return new ResponseEntity<>(this.rl1004Service.updateItemSize(rlItemSize), HttpStatus.ACCEPTED);
  }

  @PutMapping("/size/update-list")
  public ResponseEntity<List<RlItemSize>> updateItemSizeList(@RequestBody List<RlItemSize> rlItemSizes) {
    return new ResponseEntity<>(this.rl1004Service.updateItemSizeList(rlItemSizes), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/size/delete")
  public ResponseEntity<String> deleteItemSize(@RequestParam Long sizeNo) {
    this.rl1004Service.deleteItemSize(sizeNo);
    return new ResponseEntity<>("Item size deleted successfully.", HttpStatus.OK);
  }

  @DeleteMapping("/size/delete-list")
  public ResponseEntity<String> deleteItemSizeList(@RequestBody List<RlItemSize> rlItemSizes) {
    this.rl1004Service.deleteItemSizeList(rlItemSizes);
    return new ResponseEntity<>("Item size deleted successfully.", HttpStatus.OK);
  }
}

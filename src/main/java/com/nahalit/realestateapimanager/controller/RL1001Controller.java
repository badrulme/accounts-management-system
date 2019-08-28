package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemCategory;
import com.nahalit.realestateapimanager.service.RL1001Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/configuration")
@RestController
public class RL1001Controller {
  private final RL1001Service reItemCategoryService;

  public RL1001Controller(RL1001Service reItemCategoryService) {
    this.reItemCategoryService = reItemCategoryService;
  }

  // Item Category Controller
  @GetMapping("/category/")
  public ResponseEntity<List<RlItemCategory>> getAllCategory() {
    return new ResponseEntity<>(reItemCategoryService.getAllItemCategory(), HttpStatus.OK);
  }

  @GetMapping("/category/get-item-category")
  public ResponseEntity<RlItemCategory> getItemCategory(@Valid @RequestParam("categoryNo") Long categoryNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(reItemCategoryService.getItemCategory(categoryNo), HttpStatus.OK);
  }

  @PostMapping("/category/add")
  public ResponseEntity<RlItemCategory> saveItemCategory(RlItemCategory reItemCategory) {
    return new ResponseEntity<>(reItemCategoryService.saveItemCategory(reItemCategory), HttpStatus.CREATED);
  }

  @PutMapping("/category/update")
  public ResponseEntity<RlItemCategory> updateItemCategory(RlItemCategory reItemCategory) throws ResourceNotFoundException {
    return new ResponseEntity<>(reItemCategoryService.updateCategory(reItemCategory), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/category/delete")
  public ResponseEntity<String> deleteCategory(@RequestParam Long categoryNo) {
    this.reItemCategoryService.deleteCategory(categoryNo);
    return new ResponseEntity<>("Item Category Deleted Successfully.", HttpStatus.OK);
  }
}

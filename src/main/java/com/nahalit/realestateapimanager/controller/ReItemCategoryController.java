package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.ReItemCategory;
import com.nahalit.realestateapimanager.service.ReItemCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/re/item-category")
@RestController
public class ReItemCategoryController {
  private final ReItemCategoryService reItemCategoryService;

  public ReItemCategoryController(ReItemCategoryService reItemCategoryService) {
    this.reItemCategoryService = reItemCategoryService;
  }

  @GetMapping("/")
  public ResponseEntity<List<ReItemCategory>> getAllCategory() {
    return new ResponseEntity<>(reItemCategoryService.getAllItemCategory(), HttpStatus.OK);
  }

  @GetMapping("/get-item-category")
  public ResponseEntity<ReItemCategory> getItemCategory(@Valid @RequestParam("categoryNo") Long categoryNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(reItemCategoryService.getItemCategory(categoryNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<ReItemCategory> saveItemCategory(ReItemCategory reItemCategory) {
    return new ResponseEntity<>(reItemCategoryService.saveItemCategory(reItemCategory), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<ReItemCategory> updateItemCategory(ReItemCategory reItemCategory) throws ResourceNotFoundException {
    return new ResponseEntity<>(reItemCategoryService.updateCategory(reItemCategory), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteCategory(@RequestParam Long categoryNo) {
    this.reItemCategoryService.deleteCategory(categoryNo);
    return new ResponseEntity<>("Item Category Deleted Successfully.", HttpStatus.OK);
  }
}

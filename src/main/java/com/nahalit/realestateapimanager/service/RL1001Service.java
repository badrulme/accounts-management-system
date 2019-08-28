package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemCategory;
import com.nahalit.realestateapimanager.repository.RlItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1001Service {
  private RlItemCategoryRepository reItemCategoryRepository;

  @Autowired
  public RL1001Service(RlItemCategoryRepository reItemCategoryRepository) {
    this.reItemCategoryRepository = reItemCategoryRepository;
  }

  public List<RlItemCategory> getAllItemCategory() {
    return this.reItemCategoryRepository.findAll();
  }

  public RlItemCategory getItemCategory(Long categoryNo) throws ResourceNotFoundException {
    return this.reItemCategoryRepository.findById(categoryNo).orElseThrow(() -> new ResourceNotFoundException("Item Category not found for this id:" + categoryNo));
  }

  public RlItemCategory saveItemCategory(RlItemCategory reItemCategory) {
    return this.reItemCategoryRepository.save(reItemCategory);
  }

  public RlItemCategory updateCategory(RlItemCategory reItemCategory) throws ResourceNotFoundException {
    this.reItemCategoryRepository.findById(reItemCategory.getCategoryNo()).orElseThrow(() -> new ResourceNotFoundException("Item Category not for this:" + reItemCategory.getCategoryNo()));
    return this.reItemCategoryRepository.save(reItemCategory);
  }

  public void deleteCategory(Long categoryNo) {
    this.reItemCategoryRepository.findById(categoryNo).orElseThrow(() -> new RejectedExecutionException("Item Category not found for this id: " + categoryNo));
    this.reItemCategoryRepository.deleteById(categoryNo);
  }
}

package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.ReCustomer;
import com.nahalit.realestateapimanager.model.ReItemCategory;
import com.nahalit.realestateapimanager.repository.ReItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class ReItemCategoryService {
  private ReItemCategoryRepository reItemCategoryRepository;

  @Autowired
  public ReItemCategoryService(ReItemCategoryRepository reItemCategoryRepository) {
    this.reItemCategoryRepository = reItemCategoryRepository;
  }

  public List<ReItemCategory> getAllItemCategory() {
    return this.reItemCategoryRepository.findAll();
  }

  public ReItemCategory getItemCategory(Long categoryNo) throws ResourceNotFoundException {
    return this.reItemCategoryRepository.findById(categoryNo).orElseThrow(() -> new ResourceNotFoundException("Item Category not found for this id:" + categoryNo));
  }

  public ReItemCategory saveItemCategory(ReItemCategory reItemCategory) {
    return this.reItemCategoryRepository.save(reItemCategory);
  }

  public ReItemCategory updateCategory(ReItemCategory reItemCategory) throws ResourceNotFoundException {
    this.reItemCategoryRepository.findById(reItemCategory.getCategoryNo()).orElseThrow(() -> new ResourceNotFoundException("Item Category not for this:" + reItemCategory.getCategoryNo()));
    return this.reItemCategoryRepository.save(reItemCategory);
  }

  public void deleteCategory(Long categoryNo) {
    this.reItemCategoryRepository.findById(categoryNo).orElseThrow(() -> new RejectedExecutionException("Item Category not found for this id: " + categoryNo));
    this.reItemCategoryRepository.deleteById(categoryNo);
  }
}

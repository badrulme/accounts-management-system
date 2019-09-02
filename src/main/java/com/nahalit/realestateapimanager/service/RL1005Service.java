package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.model.RlItemSize;
import com.nahalit.realestateapimanager.repository.RlItemRepository;
import com.nahalit.realestateapimanager.repository.RlItemSizeRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1005Service {
  private final RlItemRepository rlItemRepository;
  private final RlItemSizeRepository rlItemSizeRepository;

  @Autowired
  public RL1005Service(RlItemRepository rlItemRepository, RlItemSizeRepository rlItemSizeRepository) {
    this.rlItemRepository = rlItemRepository;
    this.rlItemSizeRepository = rlItemSizeRepository;
  }

  // RL Item For Apartment
  public List<RlItem> getAllApItem() {
    return this.rlItemRepository.findAllByItemType(2L);
  }

  public RlItem getApItem(Long itemNo) {
    return this.rlItemRepository.findItemByIdAndType(itemNo, 2L);
  }

  public RlItem saveApRlItem(RlItem rlItem) {
    rlItem.setItemType(2L);
    return this.rlItemRepository.save(rlItem);
  }

  public RlItem updateApRlItem(RlItem rlItem) throws ResourceNotFoundException {
    this.rlItemRepository.findById(rlItem.getItemNo()).orElseThrow(() -> new ResourceNotFoundException("Apartment Item not found for this id:" + rlItem.getItemNo()));
    return this.rlItemRepository.save(rlItem);
  }

  public void deleteApRlItem(Long itemNo) {
    this.rlItemRepository.findById(itemNo).orElseThrow(() -> new RejectedExecutionException("Apartment Item not found for this id: " + itemNo));
    this.rlItemRepository.deleteById(itemNo);
  }

  // Flat Type Wise Size setup
  public List<RlItemSize> getAllItemSize() {
    return this.rlItemSizeRepository.findAll();
  }

  public RlItemSize getItemSize(Long sizeNo) {
    return this.rlItemSizeRepository.findById(sizeNo).orElseThrow(() -> new RejectedExecutionException("Item sieze not found for this id:" + sizeNo));
  }

  public List<RlItemSize> getAllItemSizeList(Long projectNo) {
    return this.rlItemSizeRepository.getAllByProjectNo(projectNo);
  }

  public RlItemSize saveItemSize(RlItemSize rlItemSize) {
    return this.rlItemSizeRepository.save(rlItemSize);
  }

  public List<RlItemSize> saveItemSizeList(List<RlItemSize> rlItemSizes) {
    return this.rlItemSizeRepository.saveAll(rlItemSizes);
  }

  public RlItemSize updateItemSize(RlItemSize rlItemSize) {
    this.rlItemSizeRepository.findById(rlItemSize.getSizeNo()).orElseThrow(() -> new RejectedExecutionException("Item size not found for this id" + rlItemSize.getSizeNo()));
    return this.rlItemSizeRepository.save(rlItemSize);
  }

  public void deleteItemSize(Long sizeNo) {
    this.rlItemSizeRepository.deleteById(sizeNo);
  }

}


package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.repository.RlItemRepository;
import com.nahalit.realestateapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1007Service {
  private final RlItemRepository rlItemRepository;

  public RL1007Service(RlItemRepository rlItemRepository) {
    this.rlItemRepository = rlItemRepository;
  }

  // RL Item For Land
  public List<RlItem> getAllLandItem() {
    return this.rlItemRepository.findAllByItemType(1L);
  }

  public RlItem saveLandRlItem(RlItem rlItem) throws ParseException {
    rlItem.setSsCreatedOn(UtillDate.getDateTime());
    rlItem.setSsModifiedOn(null);
    rlItem.setItemType(1L);
    return this.rlItemRepository.save(rlItem);
  }

  public RlItem getApItem(Long itemNo) {
    return this.rlItemRepository.findItemByIdAndType(itemNo, 2L);
  }

  public RlItem updateLandRlItem(RlItem rlItem) throws ResourceNotFoundException, ParseException {
    RlItem oldData = this.rlItemRepository.findById(rlItem.getItemNo()).orElseThrow(() -> new ResourceNotFoundException("Apartment Item not for this:" + rlItem.getItemNo()));
    rlItem.setSsCreatedOn(oldData.getSsCreatedOn());
    rlItem.setSsModifiedOn(UtillDate.getDateTime());
    return this.rlItemRepository.save(rlItem);
  }

  public void deleteLandRlItem(Long itemNo) {
    this.rlItemRepository.findById(itemNo).orElseThrow(() -> new RejectedExecutionException("Apartment Item not found for this id: " + itemNo));
    this.rlItemRepository.deleteById(itemNo);
  }
}

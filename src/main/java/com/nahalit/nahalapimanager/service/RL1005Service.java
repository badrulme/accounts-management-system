package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlItem;
import com.nahalit.nahalapimanager.repository.RlItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1005Service {
  private final RlItemRepository rlItemRepository;


  @Autowired
  public RL1005Service(RlItemRepository rlItemRepository) {
    this.rlItemRepository = rlItemRepository;
  }

  // RL Item For Apartment
  public List<RlItem> getAllApItem() {
    return this.rlItemRepository.findAllByItemType(2L);
  }

  public RlItem getApItem(Long itemNo) {
    return this.rlItemRepository.findItemByIdAndType(itemNo, 2L);
  }

  public RlItem saveApRlItem(RlItem rlItem) throws ParseException {
    rlItem.setSsCreatedOn(UtillDate.getDateTime());
    rlItem.setSsModifiedOn(null);
    rlItem.setItemType(2L);
    return this.rlItemRepository.save(rlItem);
  }

  public RlItem updateApRlItem(RlItem rlItem) throws ResourceNotFoundException, ParseException {

    RlItem oldData = this.rlItemRepository.findById(rlItem.getItemNo()).orElseThrow(() -> new ResourceNotFoundException("Apartment Item not found for this id:" + rlItem.getItemNo()));
    rlItem.setSsCreatedOn(oldData.getSsCreatedOn());
    rlItem.setSsModifiedOn(UtillDate.getDateTime());
    return this.rlItemRepository.save(rlItem);
  }

  public void deleteApRlItem(Long itemNo) {
    this.rlItemRepository.findById(itemNo).orElseThrow(() -> new RejectedExecutionException("Apartment Item not found for this id: " + itemNo));
    this.rlItemRepository.deleteById(itemNo);
  }


}

package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RL1007Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlProject;
import com.nahalit.nahalapimanager.model.RlRajukApproval;
import com.nahalit.nahalapimanager.repository.RlItemRepository;
import com.nahalit.nahalapimanager.repository.RlProjectRepository;
import com.nahalit.nahalapimanager.repository.RlRajukApprovalRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import com.nahalit.nahalapimanager.model.RlItem;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1007Service {
  private final RlItemRepository rlItemRepository;
  private final RlProjectRepository rlProjectRepository;
  private final RlRajukApprovalRepository rlRajukApprovalRepository;
  private final RL1007Dao rl1007Dao;

  public RL1007Service(RlItemRepository rlItemRepository, RlProjectRepository rlProjectRepository, RlRajukApprovalRepository rlRajukApprovalRepository, RL1007Dao rl1007Dao) {
    this.rlItemRepository = rlItemRepository;
    this.rlProjectRepository = rlProjectRepository;
    this.rlRajukApprovalRepository = rlRajukApprovalRepository;
    this.rl1007Dao = rl1007Dao;
  }

  // RL Item For Land
  public List getAllLandItem(Long itemNo) {
//    return this.rlItemRepository.findAllByItemType(1L);
    return this.rl1007Dao.getAllItemRef(itemNo);
  }

  public Object getLandItem(Long itemNo) {
//    return this.rlItemRepository.findItemByIdAndType(itemNo, 1L);
    return this.rl1007Dao.getItemRef(itemNo);
  }


  public RlItem saveLandRlItem(RlItem rlItem) throws ParseException {
    rlItem.setSsCreatedOn(UtillDate.getDateTime());
    rlItem.setSsModifiedOn(null);
    rlItem.setItemTypeNo(1L);
    return this.rlItemRepository.save(rlItem);
  }


  public RlItem updateLandRlItem(RlItem rlItem) throws ResourceNotFoundException, ParseException {
    RlItem oldData = this.rlItemRepository.findById(rlItem.getItemNo()).orElseThrow(() -> new ResourceNotFoundException("Land Item not for this:" + rlItem.getItemNo()));
    rlItem.setSsCreatedOn(oldData.getSsCreatedOn());
    rlItem.setSsModifiedOn(UtillDate.getDateTime());
    return this.rlItemRepository.save(rlItem);
  }

  public void deleteLandRlItem(Long itemNo) {
    this.rlItemRepository.findById(itemNo).orElseThrow(() -> new RejectedExecutionException("Land Item not found for this id: " + itemNo));
    this.rlItemRepository.deleteById(itemNo);
  }

  public List getFeatureProperty(Long itemNo) throws ResourceNotFoundException {
    if (itemNo != null) {
      this.rlItemRepository.findById(itemNo).orElseThrow(() -> new ResourceNotFoundException("Land item not found for this id:" + itemNo));
    }
    return this.rl1007Dao.getFeatureProperty(itemNo);
  }
}

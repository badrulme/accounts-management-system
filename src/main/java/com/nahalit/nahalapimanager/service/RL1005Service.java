package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RL1005Dao;
import com.nahalit.nahalapimanager.model.RlProject;
import com.nahalit.nahalapimanager.model.RlRajukApproval;
import com.nahalit.nahalapimanager.repository.RlProjectRepository;
import com.nahalit.nahalapimanager.repository.RlRajukApprovalRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlItem;
import com.nahalit.nahalapimanager.repository.RlItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1005Service {
  private final RlItemRepository rlItemRepository;
  private final RlProjectRepository rlProjectRepository;
  private final RlRajukApprovalRepository rlRajukApprovalRepository;
  private final RL1005Dao rl1005Dao;

  @Autowired
  public RL1005Service(RlItemRepository rlItemRepository, RlProjectRepository rlProjectRepository, RlRajukApprovalRepository rlRajukApprovalRepository, @Qualifier("RL1005Dao") RL1005Dao rl1005Dao) {
    this.rlItemRepository = rlItemRepository;
    this.rlProjectRepository = rlProjectRepository;
    this.rlRajukApprovalRepository = rlRajukApprovalRepository;
    this.rl1005Dao = rl1005Dao;
  }

  // RL Item For Apartment
  public List<RlItem> getAllApItem() {
    return this.rlItemRepository.findAllByItemType(2L);
  }

  public List getApItemRef(Long itemNo) {
    return this.rl1005Dao.getAllItemRef(itemNo);
  }


  public RlItem getApItem(Long itemNo) throws ResourceNotFoundException {
    RlItem rlItem = this.rlItemRepository.findItemByIdAndType(itemNo, 2L);
    // Get Project Details
    RlProject rlProject = this.rlProjectRepository.findById(rlItem.getProjectNo()).orElseThrow(() -> new ResourceNotFoundException("Apartment Project not found for this id:" + rlItem.getProjectNo()));
    rlItem.setProjectType(rlProject.getProjectType());
    rlItem.setProjectLocation(rlProject.getProjectLocation());
    rlItem.setProjectName(rlProject.getProjectName());
    // Get Rajuk Approval Details
    RlRajukApproval rlRajukApproval = this.rlRajukApprovalRepository.findById(rlProject.getApprovalNo()).orElseThrow(() -> new ResourceNotFoundException("Rajuk Approval not found for this id:" + rlProject.getApprovalNo()));
    rlItem.setApprovalId(rlRajukApproval.getApprovalId());
    return rlItem;
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


package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RL1004Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlProject;
import com.nahalit.nahalapimanager.repository.RlProjectRepository;
import com.nahalit.nahalapimanager.repository.RlTrnRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1019Service {
  private final RlTrnRepository rlTrnRepository;


  public RL1019Service(RlTrnRepository rlTrnRepository) {
    this.rlTrnRepository = rlTrnRepository;
  }

  // RL Trn
  public List getAllTransaction(String trnNo) throws ResourceNotFoundException {
    if (trnNo != null) {
      this.rlTrnRepository.findById(trnNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + trnNo));
    }
//    return this.rl1004Dao.getAllProjectRef(projectNo);
    return this.rlTrnRepository.findAll();
  }

//  public Object getProject(Long projectNo) throws ResourceNotFoundException {
//    this.rlProjectRepository.findById(projectNo).orElseThrow(() -> new ResourceNotFoundException("Land Project not found for this id:" + projectNo));
//    return rl1004Dao.getProjectRef(projectNo);
//  }
//
//  public RlProject saveRlProject(RlProject rlProject) throws ParseException {
//    rlProject.setSsCreatedOn(UtillDate.getDateTime());
//    rlProject.setSsModifiedOn(null);
//    rlProject.setProjectTypeNo(1);
//    return this.rlProjectRepository.save(rlProject);
//  }
//
//  public RlProject updateRlProject(RlProject rlProject) throws ResourceNotFoundException, ParseException {
//    RlProject oldData = this.rlProjectRepository.findById(rlProject.getProjectNo()).orElseThrow(() -> new ResourceNotFoundException("Land Project not for this:" + rlProject.getProjectNo()));
//    rlProject.setSsCreatedOn(oldData.getSsCreatedOn());
//    rlProject.setSsModifiedOn(UtillDate.getDateTime());
//    return this.rlProjectRepository.save(rlProject);
//  }

  public Map deleteRlTrn(String trnNo) {
    this.rlTrnRepository.findById(trnNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + trnNo));
    this.rlTrnRepository.deleteById(trnNo);

    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Deleted Successfully");
    return deleteMessage;
  }
}

package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RL1019Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.repository.RlTrnRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1019Service {
  private final RlTrnRepository rlTrnRepository;
  private final RL1019Dao rl1019Dao;


  public RL1019Service(RlTrnRepository rlTrnRepository, RL1019Dao rl1019Dao) {
    this.rlTrnRepository = rlTrnRepository;
    this.rl1019Dao = rl1019Dao;
  }

  // RL Trn
  public List getAllTransaction(String trnNo) throws ResourceNotFoundException {
    if (trnNo != null) {
      this.rlTrnRepository.findById(trnNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + trnNo));
    }
    return this.rlTrnRepository.findAll();
  }

  public List getAllTrnRef(String trnNo, String customerNo, String itemNo, String ssCreartor) {
    return this.rl1019Dao.getTrnList(trnNo, customerNo, itemNo, ssCreartor);
  }


//  public List getCustomerTrnList(Long customerNo) throws ResourceNotFoundException {
////    if (trnNo != null) {
////      this.rlTrnRepository.findById(trnNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + trnNo));
////    }
//    return this.rlTrnRepository.fin(customerNo);
//  }


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

package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RL1019Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlTrn;
import com.nahalit.nahalapimanager.model.RlTrnNominee;
import com.nahalit.nahalapimanager.repository.RlTrnNomineeRepository;
import com.nahalit.nahalapimanager.repository.RlTrnRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1019Service {
  private final RlTrnRepository rlTrnRepository;
  private final RlTrnNomineeRepository rlTrnNomineeRepository;
  private final RL1019Dao rl1019Dao;


  public RL1019Service(RlTrnRepository rlTrnRepository, RlTrnNomineeRepository rlTrnNomineeRepository, RL1019Dao rl1019Dao) {
    this.rlTrnRepository = rlTrnRepository;
    this.rlTrnNomineeRepository = rlTrnNomineeRepository;
    this.rl1019Dao = rl1019Dao;
  }

  // RL Trn
  public List getAllTransaction(Long trnNo) throws ResourceNotFoundException {
    if (trnNo != null) {
      this.rlTrnRepository.findById(trnNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + trnNo));
    }
//    return this.rl1004Dao.getAllProjectRef(projectNo);
    return this.rlTrnRepository.findAll();
  }

  public Optional<RlTrn> getTrnDetails(Long trnNo) throws ResourceNotFoundException {
    if (trnNo != null) {
      this.rlTrnRepository.findById(trnNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + trnNo));
    }
//    return this.rl1004Dao.getAllProjectRef(projectNo);
    return this.rlTrnRepository.findById(trnNo);
  }


  public List getAllTrnRef(String trnNo, String customerNo, String itemNo, String ssCreartor) {
    return this.rl1019Dao.getTrnList(trnNo, customerNo, itemNo, ssCreartor);
  }

  public Map getTrnDetailsRef(String trnNo) {
    return this.rl1019Dao.getTrnDetails(trnNo);
  }

  public RlTrn saveRlTrn(RlTrn rlTrn) throws ParseException {
    rlTrn.setSsCreatedOn(UtillDate.getDateTime());
    rlTrn.setSsModifiedOn(null);
    return this.rlTrnRepository.save(rlTrn);
  }

  public RlTrn updateRlTrn(RlTrn rlTrn) throws ResourceNotFoundException, ParseException {
    RlTrn oldData = this.rlTrnRepository.findById(rlTrn.getTrnNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this:" + rlTrn.getTrnNo()));
    rlTrn.setSsCreatedOn(oldData.getSsCreatedOn());
    rlTrn.setSsModifiedOn(UtillDate.getDateTime());
    return this.rlTrnRepository.save(rlTrn);
  }

  public Map deleteRlTrn(Long trnNo) {
    this.rlTrnRepository.findById(trnNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + trnNo));
    this.rlTrnRepository.deleteById(trnNo);

    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Deleted Successfully");
    return deleteMessage;
  }

  // RL Nominee
  public List<RlTrnNominee> getAllNominee() {
    return this.rlTrnNomineeRepository.findAll();
  }

//    public RlTrnNominee getNominee(Long nomineeNo) {
//        return this.rlTrnNomineeRepository.findById(nomineeNo);
//    }

  public RlTrnNominee getNomineeByTrnNo(Long trnNo) {
    return this.rlTrnNomineeRepository.getNomineeByTrnNo(trnNo);
  }

  public RlTrnNominee saveRlTrnNominee(RlTrnNominee rlTrnNominee) throws ParseException {
    rlTrnNominee.setSsCreatedOn(UtillDate.getDateTime());
    rlTrnNominee.setSsModifiedOn(null);
    return this.rlTrnNomineeRepository.save(rlTrnNominee);
  }

  public List<RlTrnNominee> saveRlTrnNomineeList(List<RlTrnNominee> rlTrnNominees) {
    List<RlTrnNominee> rlTrnNomineeList = new ArrayList<>();
    rlTrnNominees.forEach(rlTrnNominee -> {
      try {
        rlTrnNominee.setSsCreatedOn(UtillDate.getDateTime());
        rlTrnNominee.setSsModifiedOn(null);
        rlTrnNomineeList.add(this.rlTrnNomineeRepository.save(rlTrnNominee));
      } catch (ParseException e) {
      }
    });
    return rlTrnNomineeList;
  }

  public RlTrnNominee updateRlTrnNominee(RlTrnNominee rlTrnNominee) throws ResourceNotFoundException, ParseException {
    RlTrnNominee oldData = this.rlTrnNomineeRepository.findById(rlTrnNominee.getNomineeNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + rlTrnNominee.getNomineeNo()));
    rlTrnNominee.setSsCreatedOn(oldData.getSsCreatedOn());
    rlTrnNominee.setSsModifiedOn(UtillDate.getDateTime());
    return this.rlTrnNomineeRepository.save(rlTrnNominee);
  }

  public List<RlTrnNominee> updateRlTrnNomineeList(List<RlTrnNominee> rlTrnNominees) throws ResourceNotFoundException, ParseException {
    List<RlTrnNominee> saveList = new ArrayList<>();
    for (RlTrnNominee rlTrnNominee : rlTrnNominees) {
      RlTrnNominee oldData = this.rlTrnNomineeRepository.findById(rlTrnNominee.getNomineeNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + rlTrnNominee.getNomineeNo()));
      rlTrnNominee.setSsCreatedOn(oldData.getSsCreatedOn());
      rlTrnNominee.setSsModifiedOn(UtillDate.getDateTime());
      saveList.add(this.rlTrnNomineeRepository.save(rlTrnNominee));
    }
    return saveList;
  }

  public Map deleteRlTrnNominee(Long nomineeNo) {
    this.rlTrnNomineeRepository.findById(nomineeNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + nomineeNo));
    this.rlTrnNomineeRepository.deleteById(nomineeNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Deleted Successfully");
    return deleteMessage;
  }

  public Map deleteRlTrnNomineeList(List<RlTrnNominee> rlTrnNominees) {
    for (RlTrnNominee rlTrnNominee : rlTrnNominees) {
      this.rlTrnNomineeRepository.findById(rlTrnNominee.getNomineeNo()).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + rlTrnNominee.getNomineeNo()));
      this.rlTrnNomineeRepository.deleteById(rlTrnNominee.getNomineeNo());
    }
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Deleted Successfully");
    return deleteMessage;
  }
}
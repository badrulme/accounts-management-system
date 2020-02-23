package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.SA1007Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.SaUser;
import com.nahalit.nahalapimanager.repository.SaUserRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class SA1007Service {

  private final SaUserRepository saUserRepository;
  private final SA1007Dao sa1007Dao;
  private final AuthService authService;

  public SA1007Service(SaUserRepository saUserRepository, SA1007Dao sa1007Dao, AuthService authService) {
    this.saUserRepository = saUserRepository;
    this.sa1007Dao = sa1007Dao;
    this.authService = authService;
  }

// SA USER Service

  public List<SaUser> getAllSaUser() {
    return this.saUserRepository.findAll();
  }

  public SaUser getSaUser(Long userNo) throws ResourceNotFoundException {
    SaUser saUser = this.saUserRepository.findById(userNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + userNo));
    saUser.setUserPwd(null);
    return saUser;
  }

  public SaUser saveSaUser(SaUser saUser) throws ParseException {
    saUser.setSsCreatedOn(UtillDate.getDateTime());
    saUser.setSsModifiedOn(null);
    saUser.setUserPwd(this.sa1007Dao.getUserPwd(saUser.getUserPwd()));
    saUser.setSsCreator(authService.getUserNo());
    saUser.setCompanyNo(authService.getCompanyNo());
    return this.saUserRepository.save(saUser);
  }

  public List<SaUser> saveSaUserList(List<SaUser> saUserList) {
    return this.saUserRepository.saveAll(saUserList);
  }

  public SaUser updateSaUser(SaUser saUser) throws ResourceNotFoundException, ParseException {
    SaUser oldData = this.saUserRepository.findById(saUser.getUserNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this:" + saUser.getUserNo()));
    saUser.setSsModifiedOn(UtillDate.getDateTime());
    saUser.setSsCreatedOn(oldData.getSsCreatedOn());
    saUser.setSsModifier(authService.getUserNo());
    saUser.setSsCreator(oldData.getSsCreator());
    saUser.setCompanyNo(oldData.getCompanyNo());
    saUser.setUserPwd(this.sa1007Dao.getUserPwd(saUser.getUserPwd()));
    return this.saUserRepository.save(saUser);
  }

  public Map deleteSaUser(Long userNo) {
    this.saUserRepository.findById(userNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + userNo));
    this.saUserRepository.deleteById(userNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
    return deleteMessage;
  }
}

package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.SA1005Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.SaRole;
import com.nahalit.nahalapimanager.model.SaRoledtl;
import com.nahalit.nahalapimanager.repository.SaRoleRepository;
import com.nahalit.nahalapimanager.repository.SaRoledtlRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class SA1005Service {

  private final SaRoleRepository saRoleRepository;
  private final SaRoledtlRepository saRoledtlRepository;
  private final SA1005Dao sa1005Dao;
  private final AuthService authService;

  public SA1005Service(SaRoleRepository saRoleRepository, SaRoledtlRepository saRoledtlRepository, SA1005Dao sa1005Dao, AuthService authService) {
    this.saRoleRepository = saRoleRepository;
    this.saRoledtlRepository = saRoledtlRepository;
    this.sa1005Dao = sa1005Dao;
    this.authService = authService;
  }

// SA ROLE Service

  public List<SaRole> getAllSaRole() {
    return this.saRoleRepository.findAll();
  }

  public SaRole getSaRole(Long roleNo) throws ResourceNotFoundException {
    return this.saRoleRepository.findById(roleNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + roleNo));
  }

  public SaRole saveSaRole(SaRole saRole) throws ParseException {


    saRole.setSsCreator(authService.getUserNo());
    saRole.setCompanyNo(authService.getCompanyNo());
    return this.saRoleRepository.save(saRole);
  }

  public List<SaRole> saveSaRoleList(List<SaRole> saRoleList) {
    return this.saRoleRepository.saveAll(saRoleList);
  }

  public SaRole updateSaRole(SaRole saRole) throws ResourceNotFoundException, ParseException {
    SaRole oldData = this.saRoleRepository.findById(saRole.getRoleNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this:" + saRole.getRoleNo()));


    saRole.setSsModifier(authService.getUserNo());
    saRole.setSsCreator(oldData.getSsCreator());
    saRole.setCompanyNo(oldData.getCompanyNo());
    return this.saRoleRepository.save(saRole);
  }

  public Map deleteSaRole(Long roleNo) {

    this.saRoleRepository.findById(roleNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + roleNo));

    this.saRoleRepository.deleteById(roleNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
    return deleteMessage;
  }

  // SA ROLEDTL Service
  public List<SaRoledtl> getAllSaRoledtl() {
    return this.saRoledtlRepository.findAll();
  }

  public SaRoledtl getSaRoledtl(Long roledtlNo) throws ResourceNotFoundException {
    return this.saRoledtlRepository.findById(roledtlNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + roledtlNo));
  }

  public SaRoledtl saveSaRoledtl(SaRoledtl saRoledtl) throws ParseException {


    saRoledtl.setSsCreator(authService.getUserNo());
    saRoledtl.setCompanyNo(authService.getCompanyNo());
    return this.saRoledtlRepository.save(saRoledtl);
  }

  public List<SaRoledtl> saveSaRoledtlList(List<SaRoledtl> saRoledtlList) {
    return this.saRoledtlRepository.saveAll(saRoledtlList);
  }

  public SaRoledtl updateSaRoledtl(SaRoledtl saRoledtl) throws ResourceNotFoundException, ParseException {
    SaRoledtl oldData = this.saRoledtlRepository.findById(saRoledtl.getRoledtlNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this:" + saRoledtl.getRoledtlNo()));


    saRoledtl.setSsModifier(authService.getUserNo());
    saRoledtl.setSsCreator(oldData.getSsCreator());
    saRoledtl.setCompanyNo(oldData.getCompanyNo());
    return this.saRoledtlRepository.save(saRoledtl);
  }

  public Map deleteSaRoledtl(Long roledtlNo) {

    this.saRoledtlRepository.findById(roledtlNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + roledtlNo));

    this.saRoledtlRepository.deleteById(roledtlNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
    return deleteMessage;
  }

  public List getMenuList(String submenuType,Long roleNo) {
    return this.sa1005Dao.getMenuList(submenuType,roleNo);
  }
}

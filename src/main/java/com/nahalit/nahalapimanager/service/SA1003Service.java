package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.SA1003Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.SaSubmenu;
import com.nahalit.nahalapimanager.repository.SaSubmenuRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class SA1003Service {

  private final SaSubmenuRepository saSubmenuRepository;
  private final AuthService authService;
  private final SA1003Dao sa1003Dao;

  public SA1003Service(SaSubmenuRepository saSubmenuRepository, AuthService authService, SA1003Dao sa1003Dao) {
    this.saSubmenuRepository = saSubmenuRepository;
    this.authService = authService;
    this.sa1003Dao = sa1003Dao;
  }

// SA SUBMENU Service

  public List<SaSubmenu> getAllSaSubmenu() {
    return this.saSubmenuRepository.findAll();
  }

  public SaSubmenu getSaSubmenu(Long submenuNo) throws ResourceNotFoundException {
    return this.saSubmenuRepository.findById(submenuNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + submenuNo));
  }

  public SaSubmenu saveSaSubmenu(SaSubmenu saSubmenu) throws ParseException {


    saSubmenu.setSsCreator(authService.getUserNo());
    return this.saSubmenuRepository.save(saSubmenu);
  }

  public List<SaSubmenu> saveSaSubmenuList(List<SaSubmenu> saSubmenuList) {
    return this.saSubmenuRepository.saveAll(saSubmenuList);
  }

  public SaSubmenu updateSaSubmenu(SaSubmenu saSubmenu) throws ResourceNotFoundException, ParseException {
    SaSubmenu oldData = this.saSubmenuRepository.findById(saSubmenu.getSubmenuNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this:" + saSubmenu.getSubmenuNo()));


    saSubmenu.setSsModifier(authService.getUserNo());
    saSubmenu.setSsCreator(oldData.getSsCreator());
    return this.saSubmenuRepository.save(saSubmenu);
  }

  public Map deleteSaSubmenu(Long submenuNo) {

    this.saSubmenuRepository.findById(submenuNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + submenuNo));

    this.saSubmenuRepository.deleteById(submenuNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
    return deleteMessage;
  }

  public List getMenuList(String submenuType) {
    return this.sa1003Dao.getMenuList(submenuType);
  }

  public List getAllByMenuNo(Integer menuNo){
    return this.saSubmenuRepository.getAllByMenuNo(menuNo);
  }
}

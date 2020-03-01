package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.AC1015Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.AcBa;
import com.nahalit.nahalapimanager.repository.AcBaRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class AC1015Service {
  private final AcBaRepository acBaRepository;
  private final AC1015Dao ac1015Dao;
  private final AuthService authService;

  public AC1015Service(AcBaRepository acBaRepository, AC1015Dao ac1015Dao, AuthService authService) {
    this.acBaRepository = acBaRepository;
    this.ac1015Dao = ac1015Dao;
    this.authService = authService;
  }


  // Ac Ba
  public List<AcBa> getAllAcBa() {
    return this.acBaRepository.findAll();
  }

  public AcBa getAcBa(Long baNo) throws ResourceNotFoundException {
    return this.acBaRepository.findById(baNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + baNo));
  }

  public AcBa saveAcBa(AcBa acBa){
    acBa.setSsCreator(authService.getUserNo());
    acBa.setCompanyNo(authService.getCompanyNo());
    return this.acBaRepository.save(acBa);
  }

  public List<AcBa> saveAcBaList(List<AcBa> acBaList) {
    return this.acBaRepository.saveAll(acBaList);
  }

  public AcBa updateAcBa(AcBa acBa) throws ResourceNotFoundException {
    AcBa oldData = this.acBaRepository.findById(acBa.getBaNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this:" + acBa.getBaNo()));
    acBa.setSsModifier(authService.getUserNo());
    acBa.setSsCreator(oldData.getSsCreator());
    acBa.setCompanyNo(oldData.getCompanyNo());
    return this.acBaRepository.save(acBa);
  }

  public Map deleteAcBa(Long baNo) {

    this.acBaRepository.findById(baNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + baNo));

    this.acBaRepository.deleteById(baNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
    return deleteMessage;
  }

  public List getBaTree() {
    return this.ac1015Dao.getBaTree();
  }

}

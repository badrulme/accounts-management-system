package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.HrBu;
import com.nahalit.nahalapimanager.model.HrJobtitle;
import com.nahalit.nahalapimanager.repository.HrBuRepository;
import com.nahalit.nahalapimanager.repository.HrJobtitleRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Repository
public class HR1001Service {
  private final HrBuRepository hrBuRepository;
  private final HrJobtitleRepository hrJobtitleRepository;
  private final AuthService authService;

  public HR1001Service(HrBuRepository hrBuRepository, HrJobtitleRepository hrJobtitleRepository, AuthService authService) {
    this.hrBuRepository = hrBuRepository;
    this.hrJobtitleRepository = hrJobtitleRepository;
    this.authService = authService;
  }

  // HR JOBTITLE Service

  public List<HrJobtitle> getAllHrJobtitle() {
    return this.hrJobtitleRepository.findAll();
  }

  public HrJobtitle getHrJobtitle(Long jobtitleNo) throws ResourceNotFoundException {
    return this.hrJobtitleRepository.findById(jobtitleNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + jobtitleNo));
  }

  public HrJobtitle saveHrJobtitle(HrJobtitle hrJobtitle) throws ParseException {
    hrJobtitle.setSsCreatedOn(UtillDate.getDateTime());
    hrJobtitle.setSsModifiedOn(null);
    hrJobtitle.setSsCreator(authService.getUserNo());
    return this.hrJobtitleRepository.save(hrJobtitle);
  }

  public List<HrJobtitle> saveHrJobtitleList(List<HrJobtitle> hrJobtitleList) {
    return this.hrJobtitleRepository.saveAll(hrJobtitleList);
  }

  public HrJobtitle updateHrJobtitle(HrJobtitle hrJobtitle) throws ResourceNotFoundException, ParseException {
    HrJobtitle oldData = this.hrJobtitleRepository.findById(hrJobtitle.getJobtitleNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this:" + hrJobtitle.getJobtitleNo()));
    hrJobtitle.setSsModifiedOn(UtillDate.getDateTime());
    hrJobtitle.setSsCreatedOn(oldData.getSsCreatedOn());
    hrJobtitle.setSsModifier(authService.getUserNo());
    hrJobtitle.setSsCreator(oldData.getSsCreator());
    return this.hrJobtitleRepository.save(hrJobtitle);
  }

  public Map deleteHrJobtitle(Long jobtitleNo) {

    this.hrJobtitleRepository.findById(jobtitleNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + jobtitleNo));

    this.hrJobtitleRepository.deleteById(jobtitleNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
    return deleteMessage;
  }

  // HR BU Service

  public List<HrBu> getAllHrBu() {
    return this.hrBuRepository.findAll();
  }

  public HrBu getHrBu(Long buNo) throws ResourceNotFoundException {
    return this.hrBuRepository.findById(buNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + buNo));
  }

  public HrBu saveHrBu(HrBu hrBu) throws ParseException {
    hrBu.setSsCreatedOn(UtillDate.getDateTime());
    hrBu.setSsModifiedOn(null);
    hrBu.setSsCreator(authService.getUserNo());
    hrBu.setCompanyNo(authService.getCompanyNo());
    return this.hrBuRepository.save(hrBu);
  }

  public List<HrBu> saveHrBuList(List<HrBu> hrBuList) {
    return this.hrBuRepository.saveAll(hrBuList);
  }

  public HrBu updateHrBu(HrBu hrBu) throws ResourceNotFoundException, ParseException {
    HrBu oldData = this.hrBuRepository.findById(hrBu.getBuNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this:" + hrBu.getBuNo()));
    hrBu.setSsModifiedOn(UtillDate.getDateTime());
    hrBu.setSsCreatedOn(oldData.getSsCreatedOn());
    hrBu.setSsModifier(authService.getUserNo());
    hrBu.setSsCreator(oldData.getSsCreator());
    hrBu.setCompanyNo(oldData.getCompanyNo());
    return this.hrBuRepository.save(hrBu);
  }

  public Map deleteHrBu(Long buNo) {

    this.hrBuRepository.findById(buNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + buNo));

    this.hrBuRepository.deleteById(buNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
    return deleteMessage;
  }
}

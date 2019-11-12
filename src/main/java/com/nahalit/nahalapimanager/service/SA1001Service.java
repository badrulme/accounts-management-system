package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.SaCompany;
import com.nahalit.nahalapimanager.model.SaCompanySlider;
import com.nahalit.nahalapimanager.repository.SaCompanyRepository;
import com.nahalit.nahalapimanager.repository.SaCompanySliderRepository;
import com.nahalit.nahalapimanager.storage.StorageService;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import jdk.management.resource.ResourceRequestDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class SA1001Service {
  private final SaCompanySliderRepository saCompanySliderRepository;
  private final SaCompanyRepository saCompanyRepository;
  private final StorageService storageService;
  private final AuthService authService;

  public SA1001Service(SaCompanySliderRepository saCompanySliderRepository, SaCompanyRepository saCompanyRepository, StorageService storageService, AuthService authService) {
    this.saCompanySliderRepository = saCompanySliderRepository;
    this.saCompanyRepository = saCompanyRepository;
    this.storageService = storageService;
    this.authService = authService;
  }


  // Sa Company Service  Service
  public List<SaCompany> getAllSaCompany() {
    return this.saCompanyRepository.findAll();
  }

  public SaCompany getSaCompany(Long companyNo) throws ResourceNotFoundException {
    return this.saCompanyRepository.findById(companyNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + companyNo));
  }


  public List<SaCompany> getSaCompanyList() {
    return this.saCompanyRepository.findAll();
  }

  public SaCompany saveSaCompany(SaCompany saCompany) throws ParseException {
    saCompany.setSsCreatedOn(UtillDate.getDateTime());
    saCompany.setSsModifiedOn(null);
    return this.saCompanyRepository.save(saCompany);
  }

  public SaCompany updateSaCompany(SaCompany saCompany) throws ParseException, ResourceNotFoundException {
    SaCompany oldData = this.saCompanyRepository.findById(saCompany.getCompanyNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + saCompany.getCompanyNo()));
    saCompany.setSsCreatedOn(oldData.getSsCreatedOn());
    saCompany.setSsModifiedOn(UtillDate.getDateTime());
    return this.saCompanyRepository.save(saCompany);
  }

  public Map deleteSaCompany(Long companyNo) throws IOException {
    SaCompany saCompany = this.saCompanyRepository.findById(companyNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + companyNo));
    try {
      storageService.deleteFile(saCompany.getCompanyFaviconName());
      storageService.deleteFile(saCompany.getCompanyLogoName());
    } catch (Exception e) {
    }
    this.saCompanyRepository.deleteById(companyNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Deleted Successfully");
    return deleteMessage;
  }

  // Company Slider

  public List<SaCompanySlider> getAllSlider() {
    return this.saCompanySliderRepository.findAll();
  }

  public SaCompanySlider getSlider(Long sliderNo) {
    return this.saCompanySliderRepository.findById(sliderNo).orElseThrow(() -> new ResourceRequestDeniedException("Transaction not found for this id: " + sliderNo));
  }

  public List<SaCompanySlider> getCompanySlider(Long companyNo) {
    return this.saCompanySliderRepository.getCompanySliderByCompanyNo(companyNo);
  }

  public SaCompanySlider saveCompanySlider(SaCompanySlider saCompanySlider, MultipartFile multipartFile) throws ParseException {
    saCompanySlider.setCompanyNo(this.authService.getCompanyNo());
    saCompanySlider.setSsCreator(this.authService.getEmpNo());
    saCompanySlider.setSsCreatedOn(UtillDate.getDateTime());
    saCompanySlider.setSsModifiedOn(null);
    return this.saCompanySliderRepository.save(saCompanySlider);
  }


}

package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import com.nahalit.nahalapimanager.model.SaLookup;
import com.nahalit.nahalapimanager.model.SaLookupdtl;
import com.nahalit.nahalapimanager.repository.SaLookupRepository;
import com.nahalit.nahalapimanager.repository.SaLookupdtlRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SA1004Service {
  private final SaLookupRepository saLookupRepository;
  private final SaLookupdtlRepository saLookupdtlRepository;

  public SA1004Service(SaLookupRepository saLookupRepository, SaLookupdtlRepository saLookupdtlRepository) {
    this.saLookupRepository = saLookupRepository;
    this.saLookupdtlRepository = saLookupdtlRepository;
  }

  // SA Lookup Information
  public List<SaLookup> getAllLookup() {
    return saLookupRepository.findAll();
  }

  public SaLookup getLookup(Long lookupNo) throws ResourceNotFoundException {
    return saLookupRepository.findById(lookupNo).orElseThrow(() -> new ResourceNotFoundException("Lopokup Not found for this id: " + lookupNo));
  }

  public SaLookup saveLookup(SaLookup saLookup) throws ParseException {
    saLookup.setSsCreatedOn(UtillDate.getDateTime());
    saLookup.setSsModifiedOn(null);
    return saLookupRepository.save(saLookup);
  }

  public SaLookup updateLookup(SaLookup saLookup) throws ResourceNotFoundException, ParseException {
    SaLookup oldData = this.saLookupRepository.findById(saLookup.getLookupNo()).orElseThrow(() -> new ResourceNotFoundException("Lookup not found for this id: " + saLookup.getLookupNo()));
    saLookup.setSsCreatedOn(oldData.getSsCreatedOn());
    saLookup.setSsModifiedOn(UtillDate.getDateTime());
    return saLookupRepository.save(saLookup);
  }

  public void deleteLookup(Long lookupNo) throws ResourceNotFoundException {
    this.saLookupRepository.findById(lookupNo).orElseThrow(() -> new ResourceNotFoundException("Lookup not found for this id: " + lookupNo));
    this.saLookupRepository.deleteById((lookupNo));
  }

  // SA Lookup DTL Information
  public List<SaLookupdtl> getAllLookupdtl() {
    return saLookupdtlRepository.findAll();
  }

  public List<SaLookupdtl> getAllLookupdtlList(Long lookupNo) {
    return saLookupdtlRepository.findAllByLookupNo(lookupNo);
  }

  public SaLookupdtl getLookupdtl(Long lookupNo) throws ResourceNotFoundException {
    return saLookupdtlRepository.findById(lookupNo).orElseThrow(() -> new ResourceNotFoundException("Lopokup Not found for this id: " + lookupNo));
  }


  public SaLookupdtl saveLookupdtl(SaLookupdtl saLookupdtl) throws ParseException {
    saLookupdtl.setSsCreatedOn(UtillDate.getDateTime());
    saLookupdtl.setSsModifiedOn(null);
    return saLookupdtlRepository.save(saLookupdtl);
  }

  public List<SaLookupdtl> saveLookupdtlList(List<SaLookupdtl> saLookupdtls) {
    List<SaLookupdtl> saLookupdtlList = new ArrayList<>();
    saLookupdtls.forEach(saLookupdtl -> {
      try {
        saLookupdtl.setSsCreatedOn(UtillDate.getDateTime());
        saLookupdtl.setSsModifiedOn(null);
        saLookupdtlList.add(this.saLookupdtlRepository.save(saLookupdtl));
      } catch (ParseException e) {
      }

    });
    return saLookupdtlList;
  }

  public SaLookupdtl updateLookupdtl(SaLookupdtl saLookupdtl) throws ResourceNotFoundException, ParseException {
    SaLookupdtl oldData = this.saLookupdtlRepository.findById(saLookupdtl.getLookupNo()).orElseThrow(() -> new ResourceNotFoundException("Lookupdtl not found for this id: " + saLookupdtl.getLookupdtlNo()));
    saLookupdtl.setSsCreatedOn(oldData.getSsCreatedOn());
    saLookupdtl.setSsModifiedOn(UtillDate.getDateTime());
    return saLookupdtlRepository.save(saLookupdtl);
  }

  public List<SaLookupdtl> updateLookupdtlList(List<SaLookupdtl> saLookupdtls) throws ResourceNotFoundException, ParseException {
    List<SaLookupdtl> saveData = new ArrayList<>();
    for (SaLookupdtl saLookupdtl : saLookupdtls) {
      SaLookupdtl oldData = this.saLookupdtlRepository.findById(saLookupdtl.getLookupNo()).orElseThrow(() -> new ResourceNotFoundException("Lookupdtl not found for this id: " + saLookupdtl.getLookupdtlNo()));
      saLookupdtl.setSsCreatedOn(oldData.getSsCreatedOn());
      saLookupdtl.setSsModifiedOn(UtillDate.getDateTime());
      saveData.add(saLookupdtlRepository.save(saLookupdtl));
    }
    return saveData;
  }

  public void deleteLookupdtl(Long lookupdtlNo) throws ResourceNotFoundException {
    this.saLookupRepository.findById(lookupdtlNo).orElseThrow(() -> new ResourceNotFoundException("Lookupdtl not found for this id: " + lookupdtlNo));
    this.saLookupdtlRepository.deleteById(lookupdtlNo);
  }

  public void deleteLookupdtlList(List<SaLookupdtl> saLookupdtls) throws ResourceNotFoundException {
    for (SaLookupdtl saLookupdtl : saLookupdtls) {
      this.saLookupRepository.findById(saLookupdtl.getLookupdtlNo()).orElseThrow(() -> new ResourceNotFoundException("Lookupdtl not found for this id: " + saLookupdtl.getLookupdtlNo()));
      this.saLookupdtlRepository.deleteById(saLookupdtl.getLookupdtlNo());
    }
  }
}
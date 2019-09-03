package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.SaLookup;
import com.nahalit.realestateapimanager.model.SaLookupdtl;
import com.nahalit.realestateapimanager.repository.SaLookupRepository;
import com.nahalit.realestateapimanager.repository.SaLookupdtlRepository;
import org.springframework.stereotype.Service;

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

  public SaLookup saveLookup(SaLookup saLookup) {
    return saLookupRepository.save(saLookup);
  }

  public SaLookup updateLookup(SaLookup saLookup) throws ResourceNotFoundException {
    this.saLookupRepository.findById(saLookup.getLookupNo()).orElseThrow(() -> new ResourceNotFoundException("Lookup not found for this id: " + saLookup.getLookupNo()));
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


  public SaLookupdtl saveLookupdtl(SaLookupdtl saLookupdtl) {
    return saLookupdtlRepository.save(saLookupdtl);
  }

  public List<SaLookupdtl> saveLookupdtlList(List<SaLookupdtl> saLookupdtls) {
    return saLookupdtlRepository.saveAll(saLookupdtls);
  }

  public SaLookupdtl updateLookupdtl(SaLookupdtl saLookupdtl) throws ResourceNotFoundException {
    this.saLookupdtlRepository.findById(saLookupdtl.getLookupNo()).orElseThrow(() -> new ResourceNotFoundException("Lookupdtl not found for this id: " + saLookupdtl.getLookupdtlNo()));
    return saLookupdtlRepository.save(saLookupdtl);
  }

  public List<SaLookupdtl> updateLookupdtlList(List<SaLookupdtl> saLookupdtls) throws ResourceNotFoundException {
    List<SaLookupdtl> saveData = new ArrayList<>();
    for (SaLookupdtl saLookupdtl : saLookupdtls) {
      this.saLookupdtlRepository.findById(saLookupdtl.getLookupNo()).orElseThrow(() -> new ResourceNotFoundException("Lookupdtl not found for this id: " + saLookupdtl.getLookupdtlNo()));
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

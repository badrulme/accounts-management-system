package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlContact;
import com.nahalit.nahalapimanager.repository.RlContactRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
@Service
public class RlContactService {
  private final RlContactRepository rlContactRepository;

  public RlContactService(RlContactRepository rlContactRepository) {
    this.rlContactRepository = rlContactRepository;
  }

  // RL Item Contact Service
  public List<RlContact> getAllRlContact() {
    return this.rlContactRepository.findAll();
  }

  public RlContact getRlContact(Long contactNo) throws ResourceNotFoundException {
    return this.rlContactRepository.findById(contactNo).orElseThrow(() -> new ResourceNotFoundException("Item Contact not found for this id:" + contactNo));
  }
  

  public RlContact saveRlContact(RlContact rlContact) throws ParseException {
    return this.rlContactRepository.save(rlContact);
  }
  
  public RlContact updateRlContact(RlContact reRlContact) throws ResourceNotFoundException, ParseException {
    return this.rlContactRepository.save(reRlContact);
  }


  public void deleteRlContact(Long contactNo) {
    this.rlContactRepository.findById(contactNo).orElseThrow(() -> new RejectedExecutionException("Item Contact not found for this id: " + contactNo));
    this.rlContactRepository.deleteById(contactNo);
  }
}

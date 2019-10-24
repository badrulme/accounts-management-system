package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlPropertyContact;
import com.nahalit.nahalapimanager.repository.RlPropertyContactRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1018Service {
  private final RlPropertyContactRepository rlPropertyContactRepository;

  public RL1018Service(RlPropertyContactRepository rlPropertyContactRepository) {
    this.rlPropertyContactRepository = rlPropertyContactRepository;
  }

  // RL Item Contact Service
  public List<RlPropertyContact> getAllRlContact() {
    return this.rlPropertyContactRepository.findAll(Sort.by("contactNo").descending());
  }

  public RlPropertyContact getRlContact(Long contactNo) throws ResourceNotFoundException {
    return this.rlPropertyContactRepository.findById(contactNo).orElseThrow(() -> new ResourceNotFoundException("Item Contact not found for this id:" + contactNo));
  }


  public RlPropertyContact saveRlContact(RlPropertyContact rlPropertyContact) throws ParseException {
    rlPropertyContact.setContactDate(UtillDate.getDateTime());
    return this.rlPropertyContactRepository.save(rlPropertyContact);
  }

  public RlPropertyContact updateRlContact(RlPropertyContact reRlContact) {
    return this.rlPropertyContactRepository.save(reRlContact);
  }


  public Map deleteRlContact(Long contactNo) {
    this.rlPropertyContactRepository.findById(contactNo).orElseThrow(() -> new RejectedExecutionException("Item Contact not found for this id: " + contactNo));
    this.rlPropertyContactRepository.deleteById(contactNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Item Contact Deleted Successfully.");
    return deleteMessage;
  }
}

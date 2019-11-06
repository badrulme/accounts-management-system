package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.repository.RlFacingRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import com.nahalit.nahalapimanager.model.RlFacing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1001Service {

  private RlFacingRepository rlFacingRepository;
  private AuthService authService;

  @Autowired
  public RL1001Service(RlFacingRepository rlFacingRepository, AuthService authService) {
    this.rlFacingRepository = rlFacingRepository;
    this.authService = authService;
  }


  // RL Facing Setup
  public List<RlFacing> getAllFacing() {
    return this.rlFacingRepository.findAll();
  }

  public RlFacing getFacing(Long facingNo) throws ResourceNotFoundException {
    return this.rlFacingRepository.findById(facingNo).orElseThrow(() -> new ResourceNotFoundException("Facing not found for this id:" + facingNo));
  }

  public RlFacing saveFacing(RlFacing rlFacing) throws ParseException {
    rlFacing.setSsCreatedOn(UtillDate.getDateTime());
    rlFacing.setSsModifiedOn(null);
    rlFacing.setSsCreator(authService.getUserNo());
    return this.rlFacingRepository.save(rlFacing);
  }

  public List<RlFacing> saveFacingList(List<RlFacing> rlFacingList) {
    return this.rlFacingRepository.saveAll(rlFacingList);
  }

  public RlFacing updateFacing(RlFacing rlFacing) throws ResourceNotFoundException, ParseException {
    RlFacing oldData = this.rlFacingRepository.findById(rlFacing.getFacingNo()).orElseThrow(() -> new ResourceNotFoundException("Facing not for this:" + rlFacing.getFacingNo()));
    rlFacing.setSsModifiedOn(UtillDate.getDateTime());
    rlFacing.setSsCreatedOn(oldData.getSsCreatedOn());
    rlFacing.setSsModifier(authService.getUserNo());
    return this.rlFacingRepository.save(rlFacing);
  }

  public Map deleteFacing(Long facingNo) {

    this.rlFacingRepository.findById(facingNo).orElseThrow(() -> new RejectedExecutionException("Facing not found for this id: " + facingNo));

    this.rlFacingRepository.deleteById(facingNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Facing Deleted Successfully");
    return deleteMessage;
  }

}

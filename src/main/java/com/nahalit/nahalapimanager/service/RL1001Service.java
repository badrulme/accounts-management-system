package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlRoadSize;
import com.nahalit.nahalapimanager.repository.RlFacingRepository;
import com.nahalit.nahalapimanager.repository.RlRoadSizeRepository;
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

  private final RlFacingRepository rlFacingRepository;
  private final RlRoadSizeRepository rlRoadSizeRepository;
  private final AuthService authService;

  @Autowired
  public RL1001Service(RlFacingRepository rlFacingRepository, RlRoadSizeRepository rlRoadSizeRepository, AuthService authService) {
    this.rlFacingRepository = rlFacingRepository;
    this.rlRoadSizeRepository = rlRoadSizeRepository;
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

  // RL Road Size Setup
  public List<RlRoadSize> getAllRlRoadSize() {
    return this.rlRoadSizeRepository.findAll();
  }

  public RlRoadSize getRlRoadSize(Long sizeNo) throws ResourceNotFoundException {
    return this.rlRoadSizeRepository.findById(sizeNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + sizeNo));
  }

  public RlRoadSize saveRlRoadSize(RlRoadSize rlRoadSize) throws ParseException {
    rlRoadSize.setSsCreatedOn(UtillDate.getDateTime());
    rlRoadSize.setSsModifiedOn(null);
    rlRoadSize.setSsCreator(authService.getUserNo());
    return this.rlRoadSizeRepository.save(rlRoadSize);
  }

  public List<RlRoadSize> saveRlRoadSizeList(List<RlRoadSize> rlRoadSizeList) {
    return this.rlRoadSizeRepository.saveAll(rlRoadSizeList);
  }

  public RlRoadSize updateRlRoadSize(RlRoadSize rlRoadSize) throws ResourceNotFoundException, ParseException {
    RlRoadSize oldData = this.rlRoadSizeRepository.findById(rlRoadSize.getSizeNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this id:" + rlRoadSize.getSizeNo()));
    rlRoadSize.setSsModifiedOn(UtillDate.getDateTime());
    rlRoadSize.setSsCreatedOn(oldData.getSsCreatedOn());
    rlRoadSize.setSsModifier(authService.getUserNo());
    return this.rlRoadSizeRepository.save(rlRoadSize);
  }

  public Map deleteRlRoadSize(Long sizeNo) {

    this.rlRoadSizeRepository.findById(sizeNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + sizeNo));

    this.rlRoadSizeRepository.deleteById(sizeNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Facing Deleted Successfully");
    return deleteMessage;
  }

}

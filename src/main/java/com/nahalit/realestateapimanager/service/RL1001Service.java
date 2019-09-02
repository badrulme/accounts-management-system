package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlFacing;
import com.nahalit.realestateapimanager.model.RlRajukApproval;
import com.nahalit.realestateapimanager.repository.RlFacingRepository;
import com.nahalit.realestateapimanager.repository.RlRajukApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1001Service {
  private RlRajukApprovalRepository rlRajukApprovalRepository;
  private RlFacingRepository rlFacingRepository;

  @Autowired
  public RL1001Service(RlRajukApprovalRepository rlRajukApprovalRepository) {
    this.rlRajukApprovalRepository = rlRajukApprovalRepository;
  }

  // RL Rajuk Approval
  public List<RlRajukApproval> getAllRajukApproval() {
    return this.rlRajukApprovalRepository.findAll();
  }

  public RlRajukApproval getRajukApproval(Long approvalNo) throws ResourceNotFoundException {
    return this.rlRajukApprovalRepository.findById(approvalNo).orElseThrow(() -> new ResourceNotFoundException("Rajuk Approval not found for this id:" + approvalNo));
  }

  public RlRajukApproval saveRajukApproval(RlRajukApproval rlRajukApproval) {
    return this.rlRajukApprovalRepository.save(rlRajukApproval);
  }

  public RlRajukApproval updateRajukApproval(RlRajukApproval rlRajukApproval) throws ResourceNotFoundException {
    this.rlRajukApprovalRepository.findById(rlRajukApproval.getApprovalNo()).orElseThrow(() -> new ResourceNotFoundException("Rajuk Approval not for this:" + rlRajukApproval.getApprovalNo()));
    return this.rlRajukApprovalRepository.save(rlRajukApproval);
  }

  public void deleteRajukApproval(Long approvalNo) {
    this.rlRajukApprovalRepository.findById(approvalNo).orElseThrow(() -> new RejectedExecutionException("Rajuk Approval not found for this id: " + approvalNo));
    this.rlRajukApprovalRepository.deleteById(approvalNo);
  }

  // RL Facing Setup
  public List<RlFacing> getAllFacing() {
    return this.rlFacingRepository.findAll();
  }

  public RlFacing getFacing(Long facingNo) throws ResourceNotFoundException {
    return this.rlFacingRepository.findById(facingNo).orElseThrow(() -> new ResourceNotFoundException("Facing not found for this id:" + facingNo));
  }

  public RlFacing saveFacing(RlFacing rlFacing) {
    return this.rlFacingRepository.save(rlFacing);
  }

  public RlFacing updateFacing(RlFacing rlFacing) throws ResourceNotFoundException {
    this.rlFacingRepository.findById(rlFacing.getFacingNo()).orElseThrow(() -> new ResourceNotFoundException("Facing not for this:" + rlFacing.getFacingNo()));
    return this.rlFacingRepository.save(rlFacing);
  }

  public void deleteFacing(Long facingNo) {
    this.rlFacingRepository.findById(facingNo).orElseThrow(() -> new RejectedExecutionException("Facing not found for this id: " + facingNo));
    this.rlFacingRepository.deleteById(facingNo);
  }

}

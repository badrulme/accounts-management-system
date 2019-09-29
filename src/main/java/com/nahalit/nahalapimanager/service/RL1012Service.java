package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlRajukApproval;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import com.nahalit.nahalapimanager.repository.RlRajukApprovalRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1012Service {
  private RlRajukApprovalRepository rlRajukApprovalRepository;

  public RL1012Service(RlRajukApprovalRepository rlRajukApprovalRepository) {
    this.rlRajukApprovalRepository = rlRajukApprovalRepository;
  }

  // RL Rajuk Approval
  public List<RlRajukApproval> getAllRajukApproval() {
    return this.rlRajukApprovalRepository.findAll();
  }

  public RlRajukApproval getRajukApproval(Long approvalNo) throws ResourceNotFoundException {
    return this.rlRajukApprovalRepository.findById(approvalNo).orElseThrow(() -> new ResourceNotFoundException("Rajuk Approval not found for this id:" + approvalNo));
  }

  public RlRajukApproval saveRajukApproval(RlRajukApproval rlRajukApproval) throws ParseException {
    rlRajukApproval.setSsCreatedOn(UtillDate.getDateTime());
    rlRajukApproval.setSsModifiedOn(null);
    return this.rlRajukApprovalRepository.save(rlRajukApproval);
  }

  public RlRajukApproval updateRajukApproval(RlRajukApproval rlRajukApproval) throws ResourceNotFoundException, ParseException {
    RlRajukApproval oldData = this.rlRajukApprovalRepository.findById(rlRajukApproval.getApprovalNo()).orElseThrow(() -> new ResourceNotFoundException("Rajuk Approval not for this:" + rlRajukApproval.getApprovalNo()));
    rlRajukApproval.setSsCreatedOn(oldData.getSsCreatedOn());
    rlRajukApproval.setSsModifiedOn(UtillDate.getDateTime());
    return this.rlRajukApprovalRepository.save(rlRajukApproval);
  }

  public void deleteRajukApproval(Long approvalNo) {
    this.rlRajukApprovalRepository.findById(approvalNo).orElseThrow(() -> new RejectedExecutionException("Rajuk Approval not found for this id: " + approvalNo));
    this.rlRajukApprovalRepository.deleteById(approvalNo);
  }

}

package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.model.RlItemInstallment;
import com.nahalit.realestateapimanager.model.RlItemVideo;
import com.nahalit.realestateapimanager.repository.RlItemInstallmentRepository;
import com.nahalit.realestateapimanager.repository.RlItemRepository;
import com.nahalit.realestateapimanager.repository.RlItemVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1004Service {
  private final RlItemRepository rlItemRepository;
  private final RlItemVideoRepository rlItemVideoRepository;
  private final RlItemInstallmentRepository rlItemInstallmentRepository;

  @Autowired
  public RL1004Service(RlItemRepository rlItemRepository, RlItemVideoRepository rlItemVideoRepository, RlItemInstallmentRepository rlItemInstallmentRepository) {
    this.rlItemRepository = rlItemRepository;
    this.rlItemVideoRepository = rlItemVideoRepository;
    this.rlItemInstallmentRepository = rlItemInstallmentRepository;
  }

  public List<RlItem> getAllItem() {
    return this.rlItemRepository.findAll();
  }

  public RlItem saveRlItem(RlItem rlItem) {
    return this.rlItemRepository.save(rlItem);
  }

  // RL Item Video Service
  public List<RlItemVideo> getAllRlItemVideo() {
    return this.rlItemVideoRepository.findAll();
  }

  public RlItemVideo getRlItemVideo(Long videoNo) throws ResourceNotFoundException {
    return this.rlItemVideoRepository.findById(videoNo).orElseThrow(() -> new ResourceNotFoundException("Item Video not found for this id:" + videoNo));
  }

  public RlItemVideo saveRlItemVideo(RlItemVideo reRlItemVideo) {
    return this.rlItemVideoRepository.save(reRlItemVideo);
  }

  public RlItemVideo updateRlItemVideo(RlItemVideo reRlItemVideo) throws ResourceNotFoundException {
    this.rlItemVideoRepository.findById(reRlItemVideo.getVideoNo()).orElseThrow(() -> new ResourceNotFoundException("Item Video not for this:" + reRlItemVideo.getVideoNo()));
    return this.rlItemVideoRepository.save(reRlItemVideo);
  }

  public void deleteRlItemVideo(Long videoNo) {
    this.rlItemVideoRepository.findById(videoNo).orElseThrow(() -> new RejectedExecutionException("Item Video not found for this id: " + videoNo));
    this.rlItemVideoRepository.deleteById(videoNo);
  }

  // RL Item Installment Service
  public List<RlItemInstallment> getAllRlItemInstallment() {
    return this.rlItemInstallmentRepository.findAll();
  }

  public RlItemInstallment getRlItemInstallment(Long installmentNo) throws ResourceNotFoundException {
    return this.rlItemInstallmentRepository.findById(installmentNo).orElseThrow(() -> new ResourceNotFoundException("Item Installment not found for this id:" + installmentNo));
  }

  public RlItemInstallment saveRlItemInstallment(RlItemInstallment reRlItemInstallment) {
    return this.rlItemInstallmentRepository.save(reRlItemInstallment);
  }

  public RlItemInstallment updateRlItemInstallment(RlItemInstallment reRlItemInstallment) throws ResourceNotFoundException {
    this.rlItemInstallmentRepository.findById(reRlItemInstallment.getInstallmentNo()).orElseThrow(() -> new ResourceNotFoundException("Item Installment not for this:" + reRlItemInstallment.getInstallmentNo()));
    return this.rlItemInstallmentRepository.save(reRlItemInstallment);
  }


  public void deleteRlItemInstallment(Long installmentNo) {
    this.rlItemInstallmentRepository.findById(installmentNo).orElseThrow(() -> new RejectedExecutionException("Item Installment not found for this id: " + installmentNo));
    this.rlItemInstallmentRepository.deleteById(installmentNo);
  }
}

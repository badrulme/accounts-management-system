package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlProjectSlider;
import com.nahalit.nahalapimanager.repository.RlProjectSliderRepository;
import com.nahalit.nahalapimanager.storage.StorageService;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RlProjectSliderService {
  private final RlProjectSliderRepository rlProjectSliderRepository;
  private final StorageService storageService;

  public RlProjectSliderService(RlProjectSliderRepository rlProjectSliderRepository, StorageService storageService) {
    this.rlProjectSliderRepository = rlProjectSliderRepository;
    this.storageService = storageService;
  }

  // RL Item Slider Service
  public List<RlProjectSlider> getAllRlProjectSlider() {
    return this.rlProjectSliderRepository.findAll();
  }

  public RlProjectSlider getRlProjectSlider(Long sliderNo) throws ResourceNotFoundException {
    return this.rlProjectSliderRepository.findById(sliderNo).orElseThrow(() -> new ResourceNotFoundException("Project Slider not found for this id:" + sliderNo));
  }

  public List<RlProjectSlider> getRlProjectSliderList(Long projectNo) {
    return this.rlProjectSliderRepository.findAllByProjectNo(projectNo);
  }

  public RlProjectSlider saveRlProjectSlider(RlProjectSlider reRlProjectSlider) throws ParseException {
    reRlProjectSlider.setSsCreatedOn(UtillDate.getDateTime());
    reRlProjectSlider.setSsModifiedOn(null);
    return this.rlProjectSliderRepository.save(reRlProjectSlider);
  }

  public void deleteRlProjectSlider(Long SliderNo) throws IOException {
    RlProjectSlider rlProjectSlider = this.rlProjectSliderRepository.findById(SliderNo).orElseThrow(() -> new RejectedExecutionException("Project Slider not found for this id: " + SliderNo));
    storageService.deleteFile(rlProjectSlider.getImageName());
    this.rlProjectSliderRepository.deleteById(SliderNo);
  }
}

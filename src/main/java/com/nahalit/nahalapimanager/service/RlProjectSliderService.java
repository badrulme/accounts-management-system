package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlProjectSlider;
import com.nahalit.nahalapimanager.repository.RlProjectSliderRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RlProjectSliderService {
  private final RlProjectSliderRepository rlProjectSliderRepository;

  public RlProjectSliderService(RlProjectSliderRepository rlProjectSliderRepository) {
    this.rlProjectSliderRepository = rlProjectSliderRepository;
  }

  // RL Item Slider Service
  public List<RlProjectSlider> getAllRlProjectSlider() {
    return this.rlProjectSliderRepository.findAll();
  }

  public RlProjectSlider getRlProjectSlider(Long sliderNo) throws ResourceNotFoundException {
    return this.rlProjectSliderRepository.findById(sliderNo).orElseThrow(() -> new ResourceNotFoundException("Project Slider not found for this id:" + sliderNo));
  }

  public List<RlProjectSlider> getRlProjectSliderList(Long itemNO) {
    return this.rlProjectSliderRepository.findAllByItemNo(itemNO);
  }

  public RlProjectSlider saveRlProjectSlider(RlProjectSlider reRlProjectSlider) throws ParseException {
    reRlProjectSlider.setSsCreatedOn(UtillDate.getDateTime());
    reRlProjectSlider.setSsModifiedOn(null);
    return this.rlProjectSliderRepository.save(reRlProjectSlider);
  }

  public void deleteRlProjectSlider(Long SliderNo) {
    this.rlProjectSliderRepository.findById(SliderNo).orElseThrow(() -> new RejectedExecutionException("Project Slider not found for this id: " + SliderNo));
    this.rlProjectSliderRepository.deleteById(SliderNo);
  }
}

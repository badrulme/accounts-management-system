package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemSlider;
import com.nahalit.realestateapimanager.model.RlItemSlider;
import com.nahalit.realestateapimanager.repository.RlItemSliderRepository;
import com.nahalit.realestateapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RlItemSliderService {
  private final RlItemSliderRepository rlItemSliderRepository;

  public RlItemSliderService(RlItemSliderRepository rlItemSliderRepository) {
    this.rlItemSliderRepository = rlItemSliderRepository;
  }

  // RL Item Slider Service
  public List<RlItemSlider> getAllRlItemSlider() {
    return this.rlItemSliderRepository.findAll();
  }

  public RlItemSlider getRlItemSlider(Long sliderNo) throws ResourceNotFoundException {
    return this.rlItemSliderRepository.findById(sliderNo).orElseThrow(() -> new ResourceNotFoundException("Item Slider not found for this id:" + sliderNo));
  }

  public List<RlItemSlider> getRlItemSliderList(Long itemNO) {
    return this.rlItemSliderRepository.findAllByItemNo(itemNO);
  }

  public RlItemSlider saveRlItemSlider(RlItemSlider reRlItemSlider) throws ParseException {
    reRlItemSlider.setSsCreatedOn(UtillDate.getDateTime());
    reRlItemSlider.setSsModifiedOn(null);
    return this.rlItemSliderRepository.save(reRlItemSlider);
  }

  public void deleteRlItemSlider(Long SliderNo) {
    this.rlItemSliderRepository.findById(SliderNo).orElseThrow(() -> new RejectedExecutionException("Item Slider not found for this id: " + SliderNo));
    this.rlItemSliderRepository.deleteById(SliderNo);
  }
}

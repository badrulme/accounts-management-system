package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemVideo;
import com.nahalit.realestateapimanager.repository.RlItemVideoRepository;
import com.nahalit.realestateapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RlItemVideoService {
  private final RlItemVideoRepository rlItemVideoRepository;

  public RlItemVideoService(RlItemVideoRepository rlItemVideoRepository) {
    this.rlItemVideoRepository = rlItemVideoRepository;
  }

  // RL Item Video Service
  public List<RlItemVideo> getAllRlItemVideo() {
    return this.rlItemVideoRepository.findAll();
  }

  public RlItemVideo getRlItemVideo(Long videoNo) throws ResourceNotFoundException {
    return this.rlItemVideoRepository.findById(videoNo).orElseThrow(() -> new ResourceNotFoundException("Item Video not found for this id:" + videoNo));
  }

  public List<RlItemVideo> getRlItemVideoList(Long itemNO) {
    return this.rlItemVideoRepository.findAllByItemNo(itemNO);
  }

  public RlItemVideo saveRlItemVideo(RlItemVideo rlItemVideo) throws ParseException {
    rlItemVideo.setSsCreatedOn(UtillDate.getDateTime());
    rlItemVideo.setSsModifiedOn(null);
    return this.rlItemVideoRepository.save(rlItemVideo);
  }

  public List<RlItemVideo> saveRlItemVideoList(List<RlItemVideo> rlItemVideos) {
    List<RlItemVideo> rlItemVideoList = new ArrayList<>();
    rlItemVideos.forEach(rlItemVideo -> {
      try {
        rlItemVideo.setSsCreatedOn(UtillDate.getDateTime());
        rlItemVideo.setSsModifiedOn(null);
        rlItemVideoList.add(this.rlItemVideoRepository.save(rlItemVideo));
      } catch (ParseException e) {
      }
    });
    return rlItemVideoList;
  }

  public RlItemVideo updateRlItemVideo(RlItemVideo reRlItemVideo) throws ResourceNotFoundException, ParseException {
    RlItemVideo oldData = this.rlItemVideoRepository.findById(reRlItemVideo.getVideoNo()).orElseThrow(() -> new ResourceNotFoundException("Item Video not for this:" + reRlItemVideo.getVideoNo()));
    reRlItemVideo.setSsCreatedOn(oldData.getSsCreatedOn());
    reRlItemVideo.setSsModifiedOn(UtillDate.getDateTime());
    return this.rlItemVideoRepository.save(reRlItemVideo);
  }

  public List<RlItemVideo> updateRlItemVideoList(List<RlItemVideo> reRlItemVideos) throws ResourceNotFoundException, ParseException {
    List<RlItemVideo> saveList = new ArrayList<>();
    for (RlItemVideo reRlItemVideo : reRlItemVideos) {
      RlItemVideo oldData = this.rlItemVideoRepository.findById(reRlItemVideo.getVideoNo()).orElseThrow(() -> new ResourceNotFoundException("Item Video not for this:" + reRlItemVideo.getVideoNo()));
      reRlItemVideo.setSsCreatedOn(oldData.getSsCreatedOn());
      reRlItemVideo.setSsModifiedOn(UtillDate.getDateTime());
      saveList.add(this.rlItemVideoRepository.save(reRlItemVideo));
    }
    return saveList;
  }

  public void deleteRlItemVideo(Long videoNo) {
    this.rlItemVideoRepository.findById(videoNo).orElseThrow(() -> new RejectedExecutionException("Item Video not found for this id: " + videoNo));
    this.rlItemVideoRepository.deleteById(videoNo);
  }

  public void deleteRlItemVideoList(List<RlItemVideo> reRlItemVideos) {
    for (RlItemVideo rlItemVideo : reRlItemVideos) {
      this.rlItemVideoRepository.findById(rlItemVideo.getVideoNo()).orElseThrow(() -> new RejectedExecutionException("Item Video not found for this id: " + rlItemVideo.getVideoNo()));
      this.rlItemVideoRepository.deleteById(rlItemVideo.getVideoNo());
    }
  }
}

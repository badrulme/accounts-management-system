package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemVideo;
import com.nahalit.realestateapimanager.repository.RlItemVideoRepository;
import org.springframework.stereotype.Service;

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

    public RlItemVideo saveRlItemVideo(RlItemVideo reRlItemVideo) {
        return this.rlItemVideoRepository.save(reRlItemVideo);
    }

    public List<RlItemVideo> saveRlItemVideoList(List<RlItemVideo> reRlItemVideos) {
        return this.rlItemVideoRepository.saveAll(reRlItemVideos);
    }

    public RlItemVideo updateRlItemVideo(RlItemVideo reRlItemVideo) throws ResourceNotFoundException {
        this.rlItemVideoRepository.findById(reRlItemVideo.getVideoNo()).orElseThrow(() -> new ResourceNotFoundException("Item Video not for this:" + reRlItemVideo.getVideoNo()));
        return this.rlItemVideoRepository.save(reRlItemVideo);
    }

    public void deleteRlItemVideo(Long videoNo) {
        this.rlItemVideoRepository.findById(videoNo).orElseThrow(() -> new RejectedExecutionException("Item Video not found for this id: " + videoNo));
        this.rlItemVideoRepository.deleteById(videoNo);
    }
}

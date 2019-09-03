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

    private RlFacingRepository rlFacingRepository;

    @Autowired
    public RL1001Service(RlFacingRepository rlFacingRepository) {
        this.rlFacingRepository = rlFacingRepository;
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

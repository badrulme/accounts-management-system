package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlProject;
import com.nahalit.nahalapimanager.model.RlRajukApproval;
import com.nahalit.nahalapimanager.repository.RlItemRepository;
import com.nahalit.nahalapimanager.repository.RlProjectRepository;
import com.nahalit.nahalapimanager.repository.RlRajukApprovalRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import com.nahalit.nahalapimanager.model.RlItem;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1007Service {
    private final RlItemRepository rlItemRepository;
    private final RlProjectRepository rlProjectRepository;
    private final RlRajukApprovalRepository rlRajukApprovalRepository;

    public RL1007Service(RlItemRepository rlItemRepository, RlProjectRepository rlProjectRepository, RlRajukApprovalRepository rlRajukApprovalRepository) {
        this.rlItemRepository = rlItemRepository;
        this.rlProjectRepository = rlProjectRepository;
        this.rlRajukApprovalRepository = rlRajukApprovalRepository;
    }

    // RL Item For Land
    public List<RlItem> getAllLandItem() {
        return this.rlItemRepository.findAllByItemType(1L);
    }

    public RlItem saveLandRlItem(RlItem rlItem) throws ParseException {
        rlItem.setSsCreatedOn(UtillDate.getDateTime());
        rlItem.setSsModifiedOn(null);
        rlItem.setItemType(1L);
        return this.rlItemRepository.save(rlItem);
    }

    public RlItem getLandItem(Long itemNo) throws ResourceNotFoundException {
//    return this.rlItemRepository.findItemByIdAndType(itemNo, 1L);
        RlItem rlItem = this.rlItemRepository.findItemByIdAndType(itemNo, 1L);
        // Get Project Details
        RlProject rlProject = this.rlProjectRepository.findById(rlItem.getProjectNo()).orElseThrow(() -> new ResourceNotFoundException("Land Project not found for this id:" + rlItem.getProjectNo()));
        rlItem.setProjectType(rlProject.getProjectType());
        rlItem.setProjectLocation(rlProject.getProjectLocation());
        // Get Rajuk Approval Details
        RlRajukApproval rlRajukApproval = this.rlRajukApprovalRepository.findById(rlProject.getApprovalNo()).orElseThrow(() -> new ResourceNotFoundException("Rajuk Approval not found for this id:" + rlProject.getApprovalNo()));
        rlItem.setApprovalId(rlRajukApproval.getApprovalId());
        return rlItem;
    }


    public RlItem updateLandRlItem(RlItem rlItem) throws ResourceNotFoundException, ParseException {
        RlItem oldData = this.rlItemRepository.findById(rlItem.getItemNo()).orElseThrow(() -> new ResourceNotFoundException("Apartment Item not for this:" + rlItem.getItemNo()));
        rlItem.setSsCreatedOn(oldData.getSsCreatedOn());
        rlItem.setSsModifiedOn(UtillDate.getDateTime());
        return this.rlItemRepository.save(rlItem);
    }

    public void deleteLandRlItem(Long itemNo) {
        this.rlItemRepository.findById(itemNo).orElseThrow(() -> new RejectedExecutionException("Apartment Item not found for this id: " + itemNo));
        this.rlItemRepository.deleteById(itemNo);
    }
}

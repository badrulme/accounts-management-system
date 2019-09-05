package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.model.RlItemSize;
import com.nahalit.realestateapimanager.model.RlProject;
import com.nahalit.realestateapimanager.repository.RlItemSizeRepository;
import com.nahalit.realestateapimanager.repository.RlProjectRepository;
import com.nahalit.realestateapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1004Service {
  private final RlProjectRepository rlProjectRepository;
  private final RlItemSizeRepository rlItemSizeRepository;

  public RL1004Service(RlProjectRepository rlProjectRepository, RlItemSizeRepository rlItemSizeRepository) {
    this.rlProjectRepository = rlProjectRepository;
    this.rlItemSizeRepository = rlItemSizeRepository;
  }

  // RL Land Project Service
  public List<RlProject> getAllProject() {
//        return this.rlProjectRepository.findAll();
    return this.rlProjectRepository.findByProjectCategory(1L);
  }

  public RlProject getProject(Long projectNo) throws ResourceNotFoundException {
    return this.rlProjectRepository.findById(projectNo).orElseThrow(() -> new ResourceNotFoundException("Land Project not found for this id:" + projectNo));
  }

  public RlProject saveRlProject(RlProject rlProject) throws ParseException {
    rlProject.setSsCreatedOn(UtillDate.getDateTime());
    rlProject.setSsModifiedOn(null);
    rlProject.setProjectType(1L);
    return this.rlProjectRepository.save(rlProject);
  }

  public RlProject updateRlProject(RlProject rlProject) throws ResourceNotFoundException, ParseException {
    RlProject oldData = this.rlProjectRepository.findById(rlProject.getProjectNo()).orElseThrow(() -> new ResourceNotFoundException("Land Project not for this:" + rlProject.getProjectNo()));
    rlProject.setSsCreatedOn(oldData.getSsCreatedOn());
    rlProject.setSsModifiedOn(UtillDate.getDateTime());
    return this.rlProjectRepository.save(rlProject);
  }

  public void deleteRlProject(Long projectNo) {
    this.rlProjectRepository.findById(projectNo).orElseThrow(() -> new RejectedExecutionException("Land Project not found for this id: " + projectNo));
    this.rlProjectRepository.deleteById(projectNo);
  }

  // Flat Type Wise Size setup
  public List<RlItemSize> getAllItemSize() {
    return this.rlItemSizeRepository.findAll();
  }

  public RlItemSize getItemSize(Long sizeNo) {
    return this.rlItemSizeRepository.findById(sizeNo).orElseThrow(() -> new RejectedExecutionException("Item sieze not found for this id: " + sizeNo));
  }

  public List<RlItemSize> getAllItemSizeList(Long projectNo) {
    return this.rlItemSizeRepository.getAllByProjectNo(projectNo);
  }

  public RlItemSize saveItemSize(RlItemSize rlItemSize) throws ParseException {
    rlItemSize.setSsCreatedOn(UtillDate.getDateTime());
    rlItemSize.setSsModifiedOn(null);
    return this.rlItemSizeRepository.save(rlItemSize);
  }

  public List<RlItemSize> saveItemSizeList(List<RlItemSize> rlItemSizes) {
    List<RlItemSize> rlItemSizeList = new ArrayList<>();
    rlItemSizes.forEach(rlItemSize -> {
      try {
        rlItemSize.setSsCreatedOn(UtillDate.getDateTime());
        rlItemSize.setSsModifiedOn(null);
        rlItemSizeList.add(this.rlItemSizeRepository.save(rlItemSize));
      } catch (ParseException e) {
      }
    });
    return rlItemSizeList;
  }

  public RlItemSize updateItemSize(RlItemSize rlItemSize) throws ParseException {
    RlItemSize oldData = this.rlItemSizeRepository.findById(rlItemSize.getSizeNo()).orElseThrow(() -> new RejectedExecutionException("Item size not found for this id: " + rlItemSize.getSizeNo()));
    rlItemSize.setSsCreatedOn(oldData.getSsCreatedOn());
    rlItemSize.setSsModifiedOn(UtillDate.getDateTime());
    return this.rlItemSizeRepository.save(rlItemSize);
  }

  public List<RlItemSize> updateItemSizeList(List<RlItemSize> rlItemSizes) throws ParseException {
    List<RlItemSize> saveList = new ArrayList<>();
    for (RlItemSize rlItemSize : rlItemSizes) {
      RlItemSize oldData = this.rlItemSizeRepository.findById(rlItemSize.getSizeNo()).orElseThrow(() -> new RejectedExecutionException("Item size not found for this id: " + rlItemSize.getSizeNo()));
      rlItemSize.setSsCreatedOn(oldData.getSsCreatedOn());
      rlItemSize.setSsModifiedOn(UtillDate.getDateTime());
      saveList.add(this.rlItemSizeRepository.save(rlItemSize));
    }
    return saveList;
  }

  public void deleteItemSize(Long sizeNo) {
    this.rlItemSizeRepository.findById(sizeNo).orElseThrow(() -> new RejectedExecutionException("Item size not found for this id: " + sizeNo));
    this.rlItemSizeRepository.deleteById(sizeNo);
  }

  public void deleteItemSizeList(List<RlItemSize> rlItemSizes) {
    for (RlItemSize rlItemSize : rlItemSizes) {
      this.rlItemSizeRepository.findById(rlItemSize.getSizeNo()).orElseThrow(() -> new RejectedExecutionException("Item size not found for this id: " + rlItemSize.getSizeNo()));
      this.rlItemSizeRepository.deleteById(rlItemSize.getSizeNo());
    }
  }
}

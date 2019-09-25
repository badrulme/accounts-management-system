package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlItemSize;
import com.nahalit.nahalapimanager.model.RlProject;
import com.nahalit.nahalapimanager.repository.RlItemSizeRepository;
import com.nahalit.nahalapimanager.repository.RlProjectRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1003Service {
  private final RlProjectRepository rlProjectRepository;
  private final RlItemSizeRepository rlItemSizeRepository;

  public RL1003Service(RlProjectRepository rlProjectRepository, RlItemSizeRepository rlItemSizeRepository) {
    this.rlProjectRepository = rlProjectRepository;
    this.rlItemSizeRepository = rlItemSizeRepository;
  }

  // RL Apartment Project Service
  public List<RlProject> getAllProject() {
//        return this.rlProjectRepository.findAll();
    return this.rlProjectRepository.findByProjectCategory(2L);
  }

  public RlProject getProject(Long projectNo) throws ResourceNotFoundException {
    return this.rlProjectRepository.findById(projectNo).orElseThrow(() -> new ResourceNotFoundException("Apartment Project not found for this id:" + projectNo));
  }

  public RlProject saveRlProject(RlProject rlProject) throws ParseException {
    rlProject.setProjectType(2L);
    rlProject.setSsCreatedOn(UtillDate.getDateTime());
    rlProject.setSsModifiedOn(null);
    return this.rlProjectRepository.save(rlProject);
  }

  public RlProject updateRlProject(RlProject rlProject) throws ResourceNotFoundException, ParseException {
    RlProject oldData = this.rlProjectRepository.findById(rlProject.getProjectNo()).orElseThrow(() -> new ResourceNotFoundException("Apartment Project not for this:" + rlProject.getProjectNo()));
    rlProject.setSsCreatedOn(oldData.getSsCreatedOn());
    rlProject.setSsModifiedOn(UtillDate.getDateTime());
    return this.rlProjectRepository.save(rlProject);
  }

  public void deleteRlProject(Long projectNo) {
    this.rlProjectRepository.findById(projectNo).orElseThrow(() -> new RejectedExecutionException("Apartment Project not found for this id: " + projectNo));
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
package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlProject;
import com.nahalit.nahalapimanager.repository.RlProjectRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1003Service {
  private final RlProjectRepository rlProjectRepository;

  public RL1003Service(RlProjectRepository rlProjectRepository) {
    this.rlProjectRepository = rlProjectRepository;
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
}

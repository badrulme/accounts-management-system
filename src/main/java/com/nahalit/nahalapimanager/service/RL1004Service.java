package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RL1004Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlProject;
import com.nahalit.nahalapimanager.repository.RlProjectRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1004Service {
  private final RlProjectRepository rlProjectRepository;
  private final RL1004Dao rl1004Dao;


  public RL1004Service(RlProjectRepository rlProjectRepository, RL1004Dao rl1004Dao) {
    this.rlProjectRepository = rlProjectRepository;
    this.rl1004Dao = rl1004Dao;
  }

  // RL Land Project Service
  public List<RlProject> getAllProject() {
//        return this.rlProjectRepository.findAll();
    return this.rlProjectRepository.findByProjectCategory(1);
  }

  public List getAllProjectRef(Long projectNo){
    return this.rl1004Dao.getAllProjectRef(projectNo);
  }

  public RlProject getProject(Long projectNo) throws ResourceNotFoundException {
    return this.rlProjectRepository.findById(projectNo).orElseThrow(() -> new ResourceNotFoundException("Land Project not found for this id:" + projectNo));
  }

  public RlProject saveRlProject(RlProject rlProject) throws ParseException {
    rlProject.setSsCreatedOn(UtillDate.getDateTime());
    rlProject.setSsModifiedOn(null);
    rlProject.setProjectTypeNo(1);
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
}

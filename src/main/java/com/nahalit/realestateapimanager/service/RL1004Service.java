package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlProject;
import com.nahalit.realestateapimanager.repository.RlProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1004Service {
    private final RlProjectRepository rlProjectRepository;

    public RL1004Service(RlProjectRepository rlProjectRepository) {
        this.rlProjectRepository = rlProjectRepository;
    }

    // RL Land Project Service
    public List<RlProject> getAllProject() {
//        return this.rlProjectRepository.findAll();
        return this.rlProjectRepository.findByProjectCategory(1L);
    }

    public RlProject getProject(Long projectNo) throws ResourceNotFoundException {
        return this.rlProjectRepository.findById(projectNo).orElseThrow(() -> new ResourceNotFoundException("Land Project not found for this id:" + projectNo));
    }

    public RlProject saveRlProject(RlProject rlProject) {
        rlProject.setProjectType(1L);
        return this.rlProjectRepository.save(rlProject);
    }

    public RlProject updateRlProject(RlProject rlProject) throws ResourceNotFoundException {
        this.rlProjectRepository.findById(rlProject.getProjectNo()).orElseThrow(() -> new ResourceNotFoundException("Land Project not for this:" + rlProject.getProjectNo()));
        return this.rlProjectRepository.save(rlProject);
    }

    public void deleteRlProject(Long projectNo) {
        this.rlProjectRepository.findById(projectNo).orElseThrow(() -> new RejectedExecutionException("Land Project not found for this id: " + projectNo));
        this.rlProjectRepository.deleteById(projectNo);
    }
}

package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlProject;
import com.nahalit.realestateapimanager.model.RlRajukApproval;
import com.nahalit.realestateapimanager.repository.RlProjectRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

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

    public RlProject saveRlProject(RlProject rlProject) {
        rlProject.setProjectType(2L);
        return this.rlProjectRepository.save(rlProject);
    }

    public RlProject updateRlProject(RlProject rlProject) throws ResourceNotFoundException {
        this.rlProjectRepository.findById(rlProject.getProjectNo()).orElseThrow(() -> new ResourceNotFoundException("Apartment Project not for this:" + rlProject.getProjectNo()));
        return this.rlProjectRepository.save(rlProject);
    }

    public void deleteRlProject(Long projectNo) {
        this.rlProjectRepository.findById(projectNo).orElseThrow(() -> new RejectedExecutionException("Apartment Project not found for this id: " + projectNo));
        this.rlProjectRepository.deleteById(projectNo);
    }
}

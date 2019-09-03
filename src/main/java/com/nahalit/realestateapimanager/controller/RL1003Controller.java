package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlProject;
import com.nahalit.realestateapimanager.model.RlRajukApproval;
import com.nahalit.realestateapimanager.repository.RlProjectRepository;
import com.nahalit.realestateapimanager.service.RL1003Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/project/ap")
@RestController
public class RL1003Controller {
    private final RL1003Service rl1003Service;

    public RL1003Controller(RL1003Service rl1003Service) {
        this.rl1003Service = rl1003Service;
    }

    @GetMapping("/")
    public ResponseEntity<List<RlProject>> getAllApProject() {
        return new ResponseEntity<>(rl1003Service.getAllProject(), HttpStatus.OK);
    }

    @GetMapping("/get-project")
    public ResponseEntity<RlProject> getApProject(@Valid @RequestParam("projectNo") Long projectNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(rl1003Service.getProject(projectNo), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlProject> saveApProject(@RequestBody RlProject rlProject) {
        return new ResponseEntity<>(rl1003Service.saveRlProject(rlProject), HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<RlProject> updateApProject(@RequestBody RlProject rlProject) throws ResourceNotFoundException {
        return new ResponseEntity<>(rl1003Service.updateRlProject(rlProject), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteApProject(@RequestParam Long projectNo) {
        this.rl1003Service.deleteRlProject(projectNo);
        return new ResponseEntity<>("Apartment Project Deleted Successfully.", HttpStatus.OK);
    }
}

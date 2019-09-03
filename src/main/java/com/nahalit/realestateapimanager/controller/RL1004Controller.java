package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlProject;
import com.nahalit.realestateapimanager.service.RL1004Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/project/land")
@RestController
public class RL1004Controller {
    private final RL1004Service rl1004Service;

    public RL1004Controller(RL1004Service rl1004Service) {
        this.rl1004Service = rl1004Service;
    }

    @GetMapping("/")
    public ResponseEntity<List<RlProject>> getAllLandProject() {
        return new ResponseEntity<>(rl1004Service.getAllProject(), HttpStatus.OK);
    }

    @GetMapping("/get-project")
    public ResponseEntity<RlProject> getLandProject(@Valid @RequestParam("projectNo") Long projectNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(rl1004Service.getProject(projectNo), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlProject> saveLandProject(@RequestBody RlProject rlProject) {
        return new ResponseEntity<>(rl1004Service.saveRlProject(rlProject), HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<RlProject> updateLandProject(@RequestBody RlProject rlProject) throws ResourceNotFoundException {
        return new ResponseEntity<>(rl1004Service.updateRlProject(rlProject), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLandProject(@RequestParam Long projectNo) {
        this.rl1004Service.deleteRlProject(projectNo);
        return new ResponseEntity<>("Land Project Deleted Successfully.", HttpStatus.OK);
    }
}

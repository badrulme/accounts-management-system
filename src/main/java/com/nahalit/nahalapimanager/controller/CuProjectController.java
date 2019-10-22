package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.service.CuProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RequestMapping("/api/rest/rl/cu/project")
@RestController
public class CuProjectController {
  private final CuProjectService cuProjectService;

  public CuProjectController(CuProjectService cuProjectService) {
    this.cuProjectService = cuProjectService;
  }
@GetMapping("/")
  public ResponseEntity<List> getProjectList(
      @RequestParam(required = false) String projectNo,
      @RequestParam(required = false) String projectTypeNo) {
    return new ResponseEntity<>(this.cuProjectService.getProjectList(projectNo, projectTypeNo), HttpStatus.OK);
  }
  @GetMapping("/details")
  public ResponseEntity<Map> getProjectDetails(
      @RequestParam(required = false) String projectNo) {
    return new ResponseEntity<>(this.cuProjectService.getProjectDetails(projectNo), HttpStatus.OK);
  }
}

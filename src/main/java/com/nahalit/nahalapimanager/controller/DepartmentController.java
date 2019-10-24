package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.model.Department;
import com.nahalit.nahalapimanager.model.Student;
import com.nahalit.nahalapimanager.repository.DepartmentRepository;
import com.nahalit.nahalapimanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
  @Autowired
  private DepartmentRepository departmentRepository;

  @GetMapping("/department/")
  public ResponseEntity<List<Department>> getAllDepartment(){
    return new ResponseEntity<>(this.departmentRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/department/get-department")
  public ResponseEntity<Department> getDepartment(@RequestParam Long departmentId){
    return new ResponseEntity(this.departmentRepository.findById(departmentId), HttpStatus.OK);
  }

  @PostMapping("/department/add")
  public ResponseEntity<Department>saveDepartment(@RequestBody Department department){
    return new ResponseEntity<>(this.departmentRepository.save(department),HttpStatus.CREATED);
  }
}

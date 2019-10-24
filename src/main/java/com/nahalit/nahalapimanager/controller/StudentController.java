package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.model.Student;
import com.nahalit.nahalapimanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
  @Autowired
  private StudentRepository studentRepository;

  @GetMapping("/student/")
  public ResponseEntity<List<Student>> getAllStudent(){
    return new ResponseEntity<>(this.studentRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/student/get-student")
  public ResponseEntity<Student> getStudent(@RequestParam Long studentId){
    return new ResponseEntity(this.studentRepository.findById(studentId), HttpStatus.OK);
  }

  @PostMapping("/student/add")
  public ResponseEntity<Student>saveStudent(@RequestBody Student student){
    return new ResponseEntity<>(this.studentRepository.save(student),HttpStatus.CREATED);
  }
}

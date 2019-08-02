package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.model.Users;
import com.nahalit.realestateapimanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/rest/user")
@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/get-all-user")
  public List<Users> getAllUsers() {
    return userService.getAllUsers();
  }
}

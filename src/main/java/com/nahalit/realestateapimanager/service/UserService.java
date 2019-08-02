package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.model.Users;
import com.nahalit.realestateapimanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<Users> getAllUsers() {
    return this.userRepository.findAll();
  }
}

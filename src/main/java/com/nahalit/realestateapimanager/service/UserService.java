package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.model.Users;
import com.nahalit.realestateapimanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private UserRepository userRepository;

  public List<Users> getAllUsers() {
    return this.userRepository.findAll();
  }
}

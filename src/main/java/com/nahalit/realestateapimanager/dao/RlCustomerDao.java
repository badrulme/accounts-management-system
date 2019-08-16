package com.nahalit.realestateapimanager.dao;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface RlCustomerDao {
  Map<String, Object> isCustomerLogin(String customerUsername, String password);

  String forgotPasswordByMail(String email);
}

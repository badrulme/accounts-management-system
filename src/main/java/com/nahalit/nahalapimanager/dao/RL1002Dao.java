package com.nahalit.nahalapimanager.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface RL1002Dao {
  Map<String, Object> isCustomerLogin(String customerUsername, String password);

  String forgotPasswordByMail(String email);
}

package com.nahalit.realestateapimanager.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ConsoleMainDao {
  public Map<String, Object> consoleMainLogin(String userName, String userPassword);
  public Map<String, Object> changeUserPassword(String userName, String oldPassword, String newPassword);
}

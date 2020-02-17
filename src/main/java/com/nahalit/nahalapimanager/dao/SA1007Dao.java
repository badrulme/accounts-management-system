package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SA1007Dao {
  private final NamedParameterJdbcTemplate db;

  public SA1007Dao(NamedParameterJdbcTemplate db) {
    this.db = db;
  }

  public String getUserPwd(String userPwd) {

    StringBuilder sql = new StringBuilder();

    sql.append(" SELECT F_USER_PWD(:USER_PWD) PWD FROM DUAL");


    Map param = new HashMap();
    param.put("USER_PWD", userPwd);

    return db.queryForMap(sql.toString(), param).get("PWD").toString();
  }
}

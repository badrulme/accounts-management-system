package com.nahalit.realestateapimanager.dao.orcl;

import com.nahalit.realestateapimanager.dao.CustomerDao;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerDaoOrcl implements CustomerDao {
  private final NamedParameterJdbcTemplate db;

  public CustomerDaoOrcl(NamedParameterJdbcTemplate _db) {
    this.db = _db;
  }

  @Override
  public Map<String, Object> isCustomerLogin(String customerUsername, String password) {
    StringBuilder sql = new StringBuilder();
    Map<String, String> params = new HashMap<>();
    params.put("customerUsername", customerUsername);
    params.put("password", password);

    sql.append(" SELECT NVL((select 1 NO");
    sql.append("             from CUSTOMER");
    sql.append("             where (UPPER(CUSTOMER_ID) = UPPER(:customerUsername) and PASSWORD = :password)");
    sql.append("                or (LOWER(EMAIL) = LOWER(:customerUsername) and PASSWORD = :password)), 0) LOGIN_STATUS");
    sql.append(" FROM DUAL");
    return db.queryForMap(sql.toString(),params);
  }

}

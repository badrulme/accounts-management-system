package com.nahalit.nahalapimanager.dao.orcl;

import com.nahalit.nahalapimanager.dao.RL1003Dao;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class RL1003DaoOrcl implements RL1003Dao {
  private final NamedParameterJdbcTemplate db;

  public RL1003DaoOrcl(NamedParameterJdbcTemplate db) {
    this.db = db;
  }

  public List getAllProjectRef(Long projectNo) {
    StringBuilder sql = new StringBuilder();
    sql.append(" SELECT P.*,A.APPROVAL_ID");
    sql.append(" FROM RL_PROJECT P,RL_RAJUK_APPROVAL A");
    sql.append(" WHERE P.APPROVAL_NO=A.APPROVAL_NO(+)");
    sql.append(" AND P.PROJECT_TYPE_NO=2");
    sql.append(" AND P.PROJECT_NO=NVL(:PROJECT_NO,P.PROJECT_NO)");

    Map<String, Long> params = new HashMap<>();
    params.put("PROJECT_NO", projectNo);

    return db.queryForList(sql.toString(), params);
  }
}

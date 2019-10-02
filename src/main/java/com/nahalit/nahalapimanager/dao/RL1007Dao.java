package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RL1007Dao {
  private final NamedParameterJdbcTemplate db;

  public RL1007Dao(NamedParameterJdbcTemplate db) {
    this.db = db;
  }

  public Map getAllItemRef(Long itemNo) {

    StringBuilder sql = new StringBuilder();
    sql.append(" SELECT I.*,");
    sql.append("        P.PROJECT_ID,");
    sql.append("        P.PROJECT_LOCATION,");
    sql.append("        P.PROJECT_TYPE,");
    sql.append("        DECODE(P.PROJECT_TYPE, 'R', 'Residential', 'C', 'Commercial', 'RC',");
    sql.append("               'Residential Cum Commercial') PROJECT_TYPE_NAME,");
    sql.append("        A.APPROVAL_ID");
    sql.append(" FROM RL_ITEM I,");
    sql.append("      RL_PROJECT P,");
    sql.append("      RL_RAJUK_APPROVAL A");
    sql.append(" WHERE I.PROJECT_NO = P.PROJECT_NO(+)");
    sql.append("   AND P.APPROVAL_NO=A.APPROVAL_NO(+)");
    sql.append("   AND I.ITEM_TYPE_NO = 1");
    sql.append("   AND I.ITEM_NO = NVL(:ITEM_NO,I.ITEM_NO)");

    Map<String, Long> params = new HashMap<>();
    params.put("ITEM_NO", itemNo);

    return db.queryForMap(sql.toString(), params);

  }
}

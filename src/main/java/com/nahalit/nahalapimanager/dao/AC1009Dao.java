package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AC1009Dao {
    private final NamedParameterJdbcTemplate db;

    public AC1009Dao(NamedParameterJdbcTemplate db) {
        this.db = db;
    }

    public void updateCheckStatus(Long vNo, Long checkBy, Date checkFate) {
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE AC_VOUCHER SET CHECK_FLAG  = 1,");
        sql.append(" CHECK_BY=:CHECK_BY, CHECK_DATE=:CHECK_DATE");
        sql.append(" WHERE V_NO=:V_NO");

        Map params = new HashMap<>();
        params.put("V_NO", vNo);
        params.put("CHECK_BY", checkBy);
        params.put("CHECK_DATE", checkFate);

        db.update(sql.toString(), params);

    }

    public void updateUnCheckStatus(Long vNo) {
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE AC_VOUCHER SET CHECK_FLAG  = 0,");
        sql.append(" CHECK_BY=null, CHECK_DATE=null");
        sql.append(" WHERE V_NO=:V_NO");

        Map params = new HashMap<>();
        params.put("V_NO", vNo);

        db.update(sql.toString(), params);

    }
}

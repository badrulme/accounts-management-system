package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AC1015Dao {
    private final NamedParameterJdbcTemplate db;

    public AC1015Dao(NamedParameterJdbcTemplate db) {
        this.db = db;
    }

    public List getBaTree() {
        StringBuilder sql = new StringBuilder();

        sql.append(" select 1                 \"init\",");
        sql.append("        LEVEL             \"level\",");
        sql.append("        ba_name           \"baName\",");
        sql.append("        ba_no             \"baNo\",");
        sql.append("        ba_no_parent      \"baNoParent\",");
        sql.append("        CONNECT_BY_ISLEAF \"connectByIsleaf\"");
        sql.append(" from ac_ba");
        sql.append(" start with ba_no_parent IS NULL");
        sql.append(" connect by prior ba_no = ba_no_parent");

        Map params = new HashMap<>();

        return db.queryForList(sql.toString(), params);
    }

}

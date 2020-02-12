package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SA1003Dao {
    private final NamedParameterJdbcTemplate db;

    public SA1003Dao(NamedParameterJdbcTemplate db) {
        this.db = db;
    }

    public List getMenuList(String submenuType){

        StringBuilder sql = new StringBuilder();

        sql.append(" select lpad(m.menu_id || ' : ' || m.menu_name, (LEVEL - 1) * 8 + length(m.menu_id || ' : ' || m.menu_name), ' ') ||");
        sql.append("        ' (' ||");
        sql.append("        (select count(1)");
        sql.append("         from sa_submenu sm");
        sql.append("         where sm.active_stat = 1");
        sql.append("           and sm.menu_no = m.menu_no");
        sql.append("           and sm.submenu_type = :submenu_type)");
        sql.append("            || ')'         \"menuName\",");
        sql.append("        to_char(m.menu_no) \"menuNo\"");
        sql.append(" from sa_menu m");
        sql.append(" where m.active_stat = 1");
        sql.append(" START WITH m.parent_menu_no is null");
        sql.append(" CONNECT BY PRIOR m.menu_no = m.parent_menu_no");
        sql.append(" ORDER SIBLINGS BY m.sl_no");

        Map param = new HashMap();
        param.put("submenu_type",submenuType);
        return db.queryForList(sql.toString(),param);
    }
}

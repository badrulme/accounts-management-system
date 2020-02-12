package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SA1005Dao {
  private final NamedParameterJdbcTemplate db;

  public SA1005Dao(NamedParameterJdbcTemplate db) {
    this.db = db;
  }

  public List getMenuList(String submenuType, Long roleNo) {

    StringBuilder sql;

    if (roleNo != null) {
      sql = new StringBuilder();
      sql.append(" select ' - All Menu (' ||");
      sql.append("        (select count(1)");
      sql.append("         from sa_roledtl rd");
      sql.append("            , sa_submenu sm");
      sql.append("         where sm.active_stat = 1");
      sql.append("           and nvl(sm.my_desk");
      sql.append("                   , 0) = 0");
      sql.append("           and rd.submenu_no = sm.submenu_no");
      sql.append("           and sm.submenu_type = :submenu_type");
      sql.append("           and rd.role_no = :role_no) || '/' ||");
      sql.append("        (select count(1)");
      sql.append("         from sa_submenu sm");
      sql.append("            , sa_menu m");
      sql.append("         where sm.menu_no = m.menu_no");
      sql.append("           and m.active_stat = 1");
      sql.append("           and sm.active_stat = 1");
      sql.append("           and nvl(sm.my_desk");
      sql.append("                   , 0) = 0");
      sql.append("           and sm.submenu_type = :submenu_type) || ') -' \"menuName\"");
      sql.append("      , null                                   \"menuNo\"");
      sql.append(" from dual");
      sql.append(" union all");
      sql.append(" select '-----------------------------------------------------------' menu_name, null menu_no");
      sql.append(" from dual");
      sql.append(" union all");
      sql.append(" select menu_name, menu_no");
      sql.append(" from (select lpad(m.menu_id || ' : ' || m.menu_name, (LEVEL - 1) * 8 + length(m.menu_id || ' : ' || m.menu_name),");
      sql.append("                   ' ') || ' (' ||");
      sql.append("              (select count(1)");
      sql.append("               from sa_roledtl rd,");
      sql.append("                    sa_submenu sm");
      sql.append("               where sm.active_stat = 1");
      sql.append("                 and nvl(sm.my_desk, 0) = 0");
      sql.append("                 and rd.submenu_no = sm.submenu_no");
      sql.append("                 and sm.menu_no = m.menu_no");
      sql.append("                 and sm.submenu_type = :submenu_type");
      sql.append("                 and rd.role_no = :role_no) || '/' ||");
      sql.append("              (select count(1)");
      sql.append("               from sa_submenu sm");
      sql.append("               where sm.active_stat = 1");
      sql.append("                 and nvl(sm.my_desk, 0) = 0");
      sql.append("                 and sm.menu_no = m.menu_no");
      sql.append("                 and sm.submenu_type = :submenu_type)");
      sql.append("                  || ')'         menu_name,");
      sql.append("              to_char(m.menu_no) menu_no");
      sql.append("       from sa_menu m");
      sql.append("       where m.active_stat = 1");
      sql.append("       START WITH m.parent_menu_no is null");
      sql.append("       CONNECT BY PRIOR m.menu_no = m.parent_menu_no");
      sql.append("       ORDER SIBLINGS BY m.sl_no)");
    } else {
      sql = new StringBuilder();
      sql.append(" select '- All Menu (0/' ||");
      sql.append("        (select count(1)");
      sql.append("         from sa_submenu sm,");
      sql.append("              sa_menu m");
      sql.append("         where sm.menu_no = m.menu_no");
      sql.append("           and m.active_stat = 1");
      sql.append("           and sm.active_stat = 1");
      sql.append("           and nvl(sm.my_desk, 0) = 0");
      sql.append("           and sm.submenu_type = 'F')");
      sql.append("            || ') -' menu_name,");
      sql.append("        null         menu_no");
      sql.append(" from dual");
      sql.append(" union all");
      sql.append(" select '-----------------------------------------------------------' menu_name, null menu_no");
      sql.append(" from dual");
      sql.append(" union all");
      sql.append(" select menu_name, menu_no");
      sql.append(" from (select lpad(m.menu_id || ' : ' || m.menu_name, (LEVEL - 1) * 8 + length(m.menu_id || ' : ' || m.menu_name),");
      sql.append("                   ' ') || ' (0/' ||");
      sql.append("              (select count(1)");
      sql.append("               from sa_submenu sm");
      sql.append("               where sm.active_stat = 1");
      sql.append("                 and nvl(sm.my_desk, 0) = 0");
      sql.append("                 and sm.menu_no = m.menu_no");
      sql.append("                 and sm.submenu_type = 'F')");
      sql.append("                  || ')'         menu_name,");
      sql.append("              to_char(m.menu_no) menu_no");
      sql.append("       from sa_menu m");
      sql.append("       where m.active_stat = 1");
      sql.append("       START WITH m.parent_menu_no is null");
      sql.append("       CONNECT BY PRIOR m.menu_no = m.parent_menu_no");
      sql.append("       ORDER SIBLINGS BY m.sl_no)");
    }

    Map param = new HashMap();
    param.put("submenu_type", submenuType);
    param.put("role_no", roleNo);
    return db.queryForList(sql.toString(), param);
  }
}

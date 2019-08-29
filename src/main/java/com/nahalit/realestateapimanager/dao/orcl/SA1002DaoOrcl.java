package com.nahalit.realestateapimanager.dao.orcl;

import com.nahalit.realestateapimanager.dao.SA1002Dao;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SA1002DaoOrcl implements SA1002Dao {
    private final NamedParameterJdbcTemplate db;

    public SA1002DaoOrcl(NamedParameterJdbcTemplate db) {
        this.db = db;
    }

    @Override
    public List getUserMenu(String menuId, String submenuType, String empNo) {

        StringBuilder sql = new StringBuilder();

        sql.append(" WITH");
        sql.append(" MENU");
        sql.append(" AS");
        sql.append(" (    SELECT DISTINCT 'M' || MENU_NO            OBJ_NO,");
        sql.append(" MENU_NAME                 OBJ_NAME,");
        sql.append(" SL_NO,");
        sql.append(" 'M' || PARENT_MENU_NO     PARENT_OBJ_NO");
        sql.append(" FROM SA_MENU M");
        sql.append(" WHERE     ACTIVE_STAT = 1");
        sql.append(" AND NVL (WEB_ERP_FLAG, 0) = 1");
        sql.append(" AND UPPER (MENU_ID) =");
        sql.append(" NVL (UPPER ( :MENU_ID), UPPER (MENU_ID))");
        sql.append(" START WITH EXISTS");
        sql.append(" (SELECT 1");
        sql.append(" FROM SA_ROLEDTL RD, SA_SUBMENU SM");
        sql.append(" WHERE     M.MENU_NO = SM.MENU_NO");
        sql.append(" AND RD.SUBMENU_NO = SM.SUBMENU_NO");
        sql.append(" AND SM.SUBMENU_TYPE =");
        sql.append(" NVL (UPPER ( :SUBMENU_TYPE), 'F')");
        sql.append(" AND NVL (WEB_ERP_FLAG, 0) = 1");
        sql.append(" AND RD.ROLE_NO = (SELECT ROLE_NO");
        sql.append(" FROM SA_GRANTROLE");
        sql.append(" WHERE USER_NO = :EMP_NO))");
        sql.append(" CONNECT BY MENU_NO = PRIOR PARENT_MENU_NO)");
        sql.append(" SELECT 1");
        sql.append(" INIT,");
        sql.append(" LEVEL");
        sql.append(" LVL,");
        sql.append(" OBJ_NAME,");
        sql.append(" CASE");
        sql.append(" WHEN SUBSTR (OBJ_NO, 1, 1) = 'M' AND LEVEL = 1 THEN 'SIT1'");
        sql.append(" WHEN SUBSTR (OBJ_NO, 1, 1) = 'M' AND LEVEL > 1 THEN 'SIT2'");
        sql.append(" ELSE 'YELLOW_DOT'");
        sql.append(" END");
        sql.append(" ICON,");
        sql.append(" OBJ_NO");
        sql.append(" FROM (SELECT OBJ_NO, OBJ_NAME, SL_NO, PARENT_OBJ_NO FROM MENU");
        sql.append(" UNION ALL");
        sql.append(" SELECT TO_CHAR (RD.SUBMENU_NO)     OBJ_NO,");
        sql.append(" SM.SUBMENU_NAME_USER        OBJ_NAME,");
        sql.append(" SM.SL_NO,");
        sql.append(" 'M' || SM.MENU_NO           PARENT_OBJ_NO");
        sql.append(" FROM SA_ROLEDTL RD, SA_SUBMENU SM");
        sql.append(" WHERE     RD.SUBMENU_NO = SM.SUBMENU_NO");
        sql.append(" AND SM.SUBMENU_TYPE = NVL (UPPER ( :SUBMENU_TYPE), 'F')");
        sql.append(" AND NVL (WEB_ERP_FLAG, 0) = 1");
        sql.append(" AND RD.ROLE_NO = (SELECT ROLE_NO");
        sql.append(" FROM SA_GRANTROLE");
        sql.append(" WHERE USER_NO = :EMP_NO))");
        sql.append(" START WITH PARENT_OBJ_NO = 'M'");
        sql.append(" CONNECT BY PRIOR OBJ_NO = PARENT_OBJ_NO");
        sql.append(" ORDER SIBLINGS BY SL_NO");

        Map<String, String> params = new HashMap<>();
        params.put("MENU_ID", menuId);
        params.put("SUBMENU_TYPE", submenuType);
        params.put("EMP_NO", empNo);

        return db.queryForList(sql.toString(), params);
    }
}

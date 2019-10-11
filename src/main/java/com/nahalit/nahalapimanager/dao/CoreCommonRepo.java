package com.nahalit.nahalapimanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value = "coreCommonRepo")
public class CoreCommonRepo {
  @Autowired
  private NamedParameterJdbcTemplate db;

  public List getMenu(Long companyNo, Long userNo, String menuType) {
    StringBuilder sql = new StringBuilder();
    sql.append("    WITH MENU AS");
    sql.append("         (SELECT DISTINCT 'M' || M.MENU_NO OBJ_NO, M.MENU_NAME OBJ_NAME, M.SL_NO,");
    sql.append("                          'M' || M.PARENT_MENU_NO PARENT_OBJ_NO, M.MENU_ID,");
    sql.append("                          P.MENU_ID PARENT_MENU_ID");
    sql.append("                     FROM SA_MENU M, SA_MENU P");
    sql.append("                    WHERE M.PARENT_MENU_NO = P.MENU_NO(+)");
    sql.append("                      AND M.ACTIVE_STAT = 1");
    sql.append("                      AND NVL (M.WEB_ERP_FLAG, 0) = 1");
    sql.append("               START WITH EXISTS (");
    sql.append("                             SELECT 1");
    sql.append("                               FROM SA_USERACCESSCTRL_V E");
    sql.append("                              WHERE M.MENU_NO = E.MENU_NO");
    sql.append("                                AND SUBMENU_TYPE = :MENU_TYPE");
    sql.append("                                AND NVL (E.WEB_ERP_FLAG, 0) = 1");
    sql.append("                                AND USER_NO = TO_NUMBER (:USER_NO)");
    sql.append("                                AND COMPANY_NO = TO_NUMBER (:COMPANY_NO))");
    sql.append("               CONNECT BY M.MENU_NO = PRIOR M.PARENT_MENU_NO)");
    sql.append("    SELECT *");
    sql.append("      FROM (SELECT     PARENT_OBJ_NO, 1 INIT, LEVEL LVL, OBJ_NAME, OBJ_NO,");
    sql.append("                       MENU_ID,");
    sql.append("                       (CASE");
    sql.append("                           WHEN SUBSTR (PARENT_OBJ_NO, 1, 1) = 'M'");
    sql.append("                              THEN (SELECT MENU_ID || '_' || PARENT_OBJ_NO");
    sql.append("                                      FROM SA_MENU");
    sql.append("                                     WHERE MENU_NO = SUBSTR (PARENT_OBJ_NO, 2))");
    sql.append("                           ELSE (SELECT SUBMENU_ID");
    sql.append("                                   FROM SA_SUBMENU");
    sql.append("                                  WHERE SUBMENU_NO = PARENT_OBJ_NO)");
    sql.append("                        END");
    sql.append("                       ) PARENT_MENU_ID,");
    sql.append("                       CONNECT_BY_ISLEAF IS_OBJECT");
    sql.append("                  FROM (SELECT OBJ_NO, OBJ_NAME, SL_NO, PARENT_OBJ_NO, MENU_ID,");
    sql.append("                               PARENT_MENU_ID");
    sql.append("                          FROM MENU");
    sql.append("                        UNION ALL");
    sql.append("                        SELECT TO_CHAR (SUBMENU_NO) OBJ_NO,");
    sql.append("                               SUBMENU_NAME_USER OBJ_NAME, SL_NO,");
    sql.append("                               'M' || MENU_NO PARENT_OBJ_NO, SUBMENU_ID MENU_ID,");
    sql.append("                               NULL PARENT_MENU_ID");
    sql.append("                          FROM SA_USERACCESSCTRL_V");
    sql.append("                         WHERE SUBMENU_TYPE = :MENU_TYPE");
    sql.append("                           AND NVL (WEB_ERP_FLAG, 0) = 1");
    sql.append("                           AND USER_NO = TO_NUMBER (:USER_NO)");
    sql.append("                           AND COMPANY_NO = TO_NUMBER (:COMPANY_NO)");
    sql.append("                        UNION ALL");
    sql.append("                        SELECT TO_CHAR (SUBMENU_NO) OBJ_NO,");
    sql.append("                               SUBMENU_NAME_USER OBJ_NAME, SL_NO,");
    sql.append("                               TO_CHAR (PARA_SUBMENU_NO) PARENT_OBJ_NO,");
    sql.append("                               SUBMENU_ID MENU_ID, NULL PARENT_MENU_ID");
    sql.append("                          FROM SA_SUBMENU");
    sql.append("                         WHERE PARA_SUBMENU_NO IN (");
    sql.append("                                  SELECT SUBMENU_NO");
    sql.append("                                    FROM SA_USERACCESSCTRL_V");
    sql.append("                                   WHERE SUBMENU_TYPE = 'G'");
    sql.append("                                     AND NVL (WEB_ERP_FLAG, 0) = 1");
    sql.append("                                     AND USER_NO = TO_NUMBER (:USER_NO)");
    sql.append("                                     AND COMPANY_NO = TO_NUMBER (:COMPANY_NO)))");
    sql.append("            START WITH PARENT_OBJ_NO = 'M'");
    sql.append("            CONNECT BY PRIOR OBJ_NO = PARENT_OBJ_NO");
    sql.append("              ORDER SIBLINGS BY SL_NO)");

    Map<String, Object> params = new HashMap<>();
    params.put("COMPANY_NO", companyNo);
    params.put("USER_NO", userNo);
    params.put("MENU_TYPE", menuType);
    return db.queryForList(sql.toString(), params);
  }
}


package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CuItemDao {
  private final NamedParameterJdbcTemplate db;

  public CuItemDao(NamedParameterJdbcTemplate db) {
    this.db = db;
  }

  public List getItemList(String itemNo, String itemType, String itemName, String bedRoom, String priceFrom, String priceTo, String sizeFrom, String sizeTo, String projectLocation) {
    Map<String, String> params = new HashMap<>();
    params.put("ITEM_TYPE", itemType);
    params.put("ITEM_NO", itemNo);
    params.put("ITEM_NAME", itemName);
    params.put("PRICE_FROM", priceFrom);
    params.put("PRICE_TO", priceTo);
    params.put("SIZE_FROM", sizeFrom);
    params.put("SIZE_TO", sizeTo);
    params.put("BED_ROOM", bedRoom);
    params.put("PROJECT_LOCATION", projectLocation);

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
    sql.append("   AND P.APPROVAL_NO = A.APPROVAL_NO(+)");
    sql.append("   AND I.ITEM_TYPE = NVL(:ITEM_TYPE, I.ITEM_TYPE)");
    sql.append("   AND I.ITEM_NO = NVL(:ITEM_NO, I.ITEM_NO)");
    sql.append("   AND NVL(I.BED_ROOM, -9999) = NVL(:BED_ROOM, NVL(I.BED_ROOM, -9999))");
    sql.append("   AND NVL(I.TOTAL_PRICE, -9999) BETWEEN NVL(:PRICE_FROM, NVL(I.TOTAL_PRICE, -9999))");
    sql.append("     AND NVL(:PRICE_TO, NVL(I.TOTAL_PRICE, -9999))");
    sql.append("   AND CASE");
    sql.append("           WHEN I.ITEM_TYPE = 1 THEN NVL(I.PLOT_SIZE, -9999)");
    sql.append("           WHEN I.ITEM_TYPE = 2 THEN NVL(I.FLAT_SIZE, -9999) END");
    sql.append("     BETWEEN NVL(:SIZE_FROM,");
    sql.append("                 CASE");
    sql.append("                     WHEN I.ITEM_TYPE = 1 THEN NVL(I.PLOT_SIZE, -9999)");
    sql.append("                     WHEN I.ITEM_TYPE = 2 THEN NVL(I.FLAT_SIZE, -9999) END)");
    sql.append("     AND NVL(:SIZE_TO, CASE");
    sql.append("                           WHEN I.ITEM_TYPE = 1 THEN NVL(I.PLOT_SIZE, -9999)");
    sql.append("                           WHEN I.ITEM_TYPE = 2 THEN NVL(I.FLAT_SIZE, -9999) END)");
    sql.append("   AND NVL(I.ITEM_NAME, '-XXX') LIKE '%' || NVL(:ITEM_TYPE, NVL(I.ITEM_NAME, '-XXX')) || '%'");
    sql.append("   AND NVL(P.PROJECT_LOCATION, '-XXX') LIKE '%' || NVL(:PROJECT_LOCATION, NVL(P.PROJECT_LOCATION, '-XXX')) || '%'");


    return null;
  }
}

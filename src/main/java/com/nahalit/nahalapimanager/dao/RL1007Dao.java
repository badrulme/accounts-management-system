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

  public List getAllItemRef(Long itemNo) {

    StringBuilder sql = new StringBuilder();

    sql.append(" SELECT I.ITEM_NO \"itemNo\",");
    sql.append(" I.ITEM_ID \"itemId\",");
    sql.append(" I.PROJECT_NO \"projectNo\",");
    sql.append(" I.PLOT_TYPE \"plotType\",");
    sql.append(" I.ROAD_SIZE \"roadSize\",");
    sql.append(" I.FACING_NO \"facingNo\",");
    sql.append(" I.BLOCK_NAME \"blockName\",");
    sql.append(" I.PLOT_SIZE \"plotSize\",");
    sql.append(" I.PRICE \"price\",");
    sql.append(" I.TOTAL_PRICE \"totalPrice\",");
    sql.append(" I.FLAT_SIZE \"flatSize\",");
    sql.append(" I.FLAT_PLACEOF_STORID \"flatPlaceofStorid\",");
    sql.append(" I.FLAT_NO \"flatNo\",");
    sql.append(" I.NUMBER_OF_LIFT \"numberOfLift\",");
    sql.append(" I.DECORATION_CONDITION \"decorationCondition\",");
    sql.append(" I.BED_ROOM \"bedRoom\",");
    sql.append(" I.LIVING_AND_DINING \"livingAndDining\",");
    sql.append(" I.KITCHEN \"kitchen\",");
    sql.append(" I.VARANDA \"varanda\",");
    sql.append(" I.TOILETS \"toilets\",");
    sql.append(" I.SWIMMING_POOL \"swimmingPool\",");
    sql.append(" I.GYM \"gym\",");
    sql.append(" I.PARKING_FLAG \"parkingFlag\",");
    sql.append(" I.PARKING_PRICE \"parkingPrice\",");
    sql.append(" I.SS_CREATED_ON \"ssCreatedOn\",");
    sql.append(" I.SS_CREATOR \"ssCreator\",");
    sql.append(" I.SS_MODIFIED_ON \"ssModifiedOn\",");
    sql.append(" I.SS_MODIFIER \"ssModifier\",");
    sql.append(" I.ITEM_TYPE_NO \"itemTypeNo\",");
    sql.append(" I.FLAT_TYPE \"flatType\",");
    sql.append(" I.ITEM_BRAND_PHOTO \"itemBrandPhoto\",");
    sql.append(" I.ITEM_INVENTORY_FLAG \"itemInventoryFlag\",");
    sql.append(" I.ITEM_NAME \"itemName\",");
    sql.append(" I.DESCR \"descr\",");
    sql.append(" I.INACTIVE_FLAG \"inactiveFlag\",");
    sql.append("        P.PROJECT_ID \"projectId\",");
    sql.append("        P.PROJECT_LOCATION \"projectLocation\",");
    sql.append("        P.PROJECT_TYPE \"projectType\",");
    sql.append("        DECODE(P.PROJECT_TYPE, 'R', 'Residential', 'C', 'Commercial', 'RC',");
    sql.append("               'Residential Cum Commercial') \"projectTypeName\",");
    sql.append("        A.APPROVAL_ID \"approvalId\",");
    sql.append(" P.PROJECT_NAME \"projectName\"");
    sql.append(" FROM RL_ITEM I,");
    sql.append("      RL_PROJECT P,");
    sql.append("      RL_RAJUK_APPROVAL A");
    sql.append(" WHERE I.PROJECT_NO = P.PROJECT_NO(+)");
    sql.append("   AND P.APPROVAL_NO=A.APPROVAL_NO(+)");
    sql.append("   AND I.ITEM_TYPE_NO = 1");
    sql.append("   AND I.ITEM_NO = nvl(:ITEM_NO,I.ITEM_NO)");

    Map<String, Long> params = new HashMap<>();
    params.put("ITEM_NO", itemNo);

    return db.queryForList(sql.toString(), params);
  }

  public Object getItemRef(Long itemNo) {

    StringBuilder sql = new StringBuilder();

    sql.append(" SELECT I.ITEM_NO \"itemNo\",");
    sql.append(" I.ITEM_ID \"itemId\",");
    sql.append(" I.PROJECT_NO \"projectNo\",");
    sql.append(" I.PLOT_TYPE \"plotType\",");
    sql.append(" I.ROAD_SIZE \"roadSize\",");
    sql.append(" I.FACING_NO \"facingNo\",");
    sql.append(" I.BLOCK_NAME \"blockName\",");
    sql.append(" I.PLOT_SIZE \"plotSize\",");
    sql.append(" I.PRICE \"price\",");
    sql.append(" I.TOTAL_PRICE \"totalPrice\",");
    sql.append(" I.FLAT_SIZE \"flatSize\",");
    sql.append(" I.FLAT_PLACEOF_STORID \"flatPlaceofStorid\",");
    sql.append(" I.FLAT_NO \"flatNo\",");
    sql.append(" I.NUMBER_OF_LIFT \"numberOfLift\",");
    sql.append(" I.DECORATION_CONDITION \"decorationCondition\",");
    sql.append(" I.BED_ROOM \"bedRoom\",");
    sql.append(" I.LIVING_AND_DINING \"livingAndDining\",");
    sql.append(" I.KITCHEN \"kitchen\",");
    sql.append(" I.VARANDA \"varanda\",");
    sql.append(" I.TOILETS \"toilets\",");
    sql.append(" I.SWIMMING_POOL \"swimmingPool\",");
    sql.append(" I.GYM \"gym\",");
    sql.append(" I.PARKING_FLAG \"parkingFlag\",");
    sql.append(" I.PARKING_PRICE \"parkingPrice\",");
    sql.append(" I.SS_CREATED_ON \"ssCreatedOn\",");
    sql.append(" I.SS_CREATOR \"ssCreator\",");
    sql.append(" I.SS_MODIFIED_ON \"ssModifiedOn\",");
    sql.append(" I.SS_MODIFIER \"ssModifier\",");
    sql.append(" I.ITEM_TYPE_NO \"itemTypeNo\",");
    sql.append(" I.FLAT_TYPE \"flatType\",");
    sql.append(" I.ITEM_BRAND_PHOTO \"itemBrandPhoto\",");
    sql.append(" I.ITEM_INVENTORY_FLAG \"itemInventoryFlag\",");
    sql.append(" I.ITEM_NAME \"itemName\",");
    sql.append(" I.DESCR \"descr\",");
    sql.append(" I.INACTIVE_FLAG \"inactiveFlag\",");
    sql.append("        P.PROJECT_ID \"projectId\",");
    sql.append("        P.PROJECT_LOCATION \"projectLocation\",");
    sql.append("        P.PROJECT_TYPE \"projectType\",");
    sql.append("        DECODE(P.PROJECT_TYPE, 'R', 'Residential', 'C', 'Commercial', 'RC',");
    sql.append("               'Residential Cum Commercial') \"projectTypeName\",");
    sql.append("        A.APPROVAL_ID \"approvalId\",");
    sql.append(" P.PROJECT_NAME \"projectName\"");
    sql.append(" FROM RL_ITEM I,");
    sql.append("      RL_PROJECT P,");
    sql.append("      RL_RAJUK_APPROVAL A");
    sql.append(" WHERE I.PROJECT_NO = P.PROJECT_NO(+)");
    sql.append("   AND P.APPROVAL_NO=A.APPROVAL_NO(+)");
    sql.append("   AND I.ITEM_TYPE_NO = 1");
    sql.append("   AND I.ITEM_NO =:ITEM_NO");

    Map<String, Long> params = new HashMap<>();
    params.put("ITEM_NO", itemNo);

    return db.queryForMap(sql.toString(), params);
  }

}

package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RLItemDao {
  private final NamedParameterJdbcTemplate db;

  public RLItemDao(NamedParameterJdbcTemplate db) {
    this.db = db;
  }



  public String getItemId(String projectNo) {
    StringBuilder sql = new StringBuilder();
    Map<String, String> params = new HashMap<>();
    params.put("PROJECT_NO", projectNo);

    sql.append(" SELECT MAX(SUBSTR(ITEM_ID, 7)) + 1 ID");
    sql.append(" FROM RL_ITEM");
    sql.append(" WHERE SUBSTR(ITEM_ID, 1, 5) = (");
    sql.append("     SELECT SUBSTR(PROJECT_ID, 1, 7)");
    sql.append("     FROM RL_PROJECT");
    sql.append("     WHERE PROJECT_NO = :PROJECT_NO);");

    Map mapCustomerId = db.queryForMap(sql.toString(), params);

    return mapCustomerId.get("ID").toString();
  }

  public List getItemList(String itemNo, String itemTypeNo, String itemName, String bedRoom, String priceFrom, String priceTo, String sizeFrom, String sizeTo, String projectLocation, String itemNoList, String projectNo) {
    Map<String, String> params = new HashMap<>();
    params.put("ITEM_TYPE_NO", itemTypeNo);
    params.put("ITEM_NO", itemNo);
    params.put("ITEM_NAME", itemName);
    params.put("PRICE_FROM", priceFrom);
    params.put("PRICE_TO", priceTo);
    params.put("SIZE_FROM", sizeFrom);
    params.put("SIZE_TO", sizeTo);
    params.put("BED_ROOM", bedRoom);
    params.put("PROJECT_LOCATION", projectLocation);
    params.put("ITEM_NO_LIST", itemNoList);
    params.put("PROJECT_NO", projectNo);

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
    sql.append(" I.DESCR_BN \"descrBn\",");
    sql.append(" I.INACTIVE_FLAG \"inactiveFlag\",");
    sql.append(" i.CCTV_FLAG \"cctvFlag\",");
    sql.append(" i.CONFERENCE_HALL_FLAG \"conferenceHallFlag\",");
    sql.append(" i.HEATING_FLAG \"heatingFlag\",");
    sql.append(" i.COOLING_FLAG \"coolingFlag\",");
    sql.append(" i.NUMBER_OF_BALCONY \"numberOfBalcony\",");
    sql.append(" i.BUILT_YEAR \"builtYear\",");
    sql.append(" i.DISCOUNT_AMOUNT \"discountAmount\",");
    sql.append(" i.DISCOUNT_PCT \"discountPct\",");
    sql.append(" i.INTERNET_FLAG \"internetFlag\",");
    sql.append(" i.CABLE_TV_FLAG \"cableTvFlag\",");
    sql.append(" i.net_Price \"netPrice\",");
    sql.append(" P.PROJECT_ID \"projectId\",");
    sql.append(" P.PROJECT_LOCATION \"projectLocation\",");
    sql.append(" P.PROJECT_TYPE \"projectType\",");
    sql.append(" DECODE(P.PROJECT_TYPE, 'R', 'Residential', 'C', 'Commercial', 'RC',");
    sql.append("        'Residential Cum Commercial') \"projectTypeName\",");
    sql.append(" A.APPROVAL_ID \"approvalId\",");
    sql.append(" P.PROJECT_NAME \"projectName\",");
    sql.append(" T.TYPE_NAME \"itemTypeName\"");
    sql.append(" FROM RL_ITEM I,");
    sql.append("      RL_ITEM_TYPE T,");
    sql.append("      RL_PROJECT P,");
    sql.append("      RL_RAJUK_APPROVAL A");
    sql.append(" WHERE I.PROJECT_NO = P.PROJECT_NO(+)");
    sql.append("   AND P.APPROVAL_NO = A.APPROVAL_NO(+)");
    sql.append("   AND I.ITEM_TYPE_NO=T.TYPE_NO");
    sql.append("   AND I.PROJECT_NO=NVL(:PROJECT_NO,I.PROJECT_NO)");
    sql.append("   AND instr(','||nvl(:ITEM_NO_LIST,i.item_no)||',',','||i.item_no||',')>0");
    sql.append("   AND I.ITEM_TYPE_NO = NVL(:ITEM_TYPE_NO, I.ITEM_TYPE_NO)");
    sql.append("   AND I.ITEM_NO = NVL(:ITEM_NO, I.ITEM_NO)");
    sql.append("   AND NVL(I.BED_ROOM, -9999) = NVL(:BED_ROOM, NVL(I.BED_ROOM, -9999))");
    sql.append("   AND NVL(I.TOTAL_PRICE, -9999) BETWEEN NVL(:PRICE_FROM, NVL(I.TOTAL_PRICE, -9999))");
    sql.append("     AND NVL(:PRICE_TO, NVL(I.TOTAL_PRICE, -9999))");
    sql.append("   AND CASE");
    sql.append("           WHEN I.ITEM_TYPE_NO = 1 THEN NVL(I.PLOT_SIZE, -9999)");
    sql.append("           WHEN I.ITEM_TYPE_NO = 2 THEN NVL(I.FLAT_SIZE, -9999) END");
    sql.append("     BETWEEN NVL(:SIZE_FROM,");
    sql.append("                 CASE");
    sql.append("                     WHEN I.ITEM_TYPE_NO = 1 THEN NVL(I.PLOT_SIZE, -9999)");
    sql.append("                     WHEN I.ITEM_TYPE_NO = 2 THEN NVL(I.FLAT_SIZE, -9999) END)");
    sql.append("     AND NVL(:SIZE_TO, CASE");
    sql.append("                           WHEN I.ITEM_TYPE_NO = 1 THEN NVL(I.PLOT_SIZE, -9999)");
    sql.append("                           WHEN I.ITEM_TYPE_NO = 2 THEN NVL(I.FLAT_SIZE, -9999) END)");
    sql.append("   AND NVL(I.ITEM_NAME, '-XXX') LIKE '%' || NVL(:ITEM_NAME, NVL(I.ITEM_NAME, '-XXX')) || '%'");
    sql.append("   AND NVL(P.PROJECT_LOCATION, '-XXX') LIKE '%' || NVL(:PROJECT_LOCATION, NVL(P.PROJECT_LOCATION, '-XXX')) || '%'");


    return db.queryForList(sql.toString(), params);

  }

  public List getAllItemRef(String itemNo, String itemTypeNo, String projectNo) {

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
    sql.append(" I.DESCR_BN \"descrBn\",");
    sql.append(" I.INACTIVE_FLAG \"inactiveFlag\",");
    sql.append(" i.CCTV_FLAG \"cctvFlag\",");
    sql.append(" i.SECURITY_FLAG \"securityFlag\",");
    sql.append(" i.CONFERENCE_HALL_FLAG \"conferenceHallFlag\",");
    sql.append(" i.HEATING_FLAG \"heatingFlag\",");
    sql.append(" i.COOLING_FLAG \"coolingFlag\",");
    sql.append(" i.NUMBER_OF_BALCONY \"numberOfBalcony\",");
    sql.append(" i.BUILT_YEAR \"builtYear\",");
    sql.append(" i.DISCOUNT_AMOUNT \"discountAmount\",");
    sql.append(" i.DISCOUNT_PCT \"discountPct\",");
    sql.append(" i.INTERNET_FLAG \"internetFlag\",");
    sql.append(" i.CABLE_TV_FLAG \"cableTvFlag\",");
    sql.append(" i.net_Price \"netPrice\",");
    sql.append("        P.PROJECT_ID \"projectId\",");
    sql.append("        P.PROJECT_LOCATION \"projectLocation\",");
    sql.append("        P.PROJECT_TYPE \"projectType\",");
    sql.append("        DECODE(P.PROJECT_TYPE, 'R', 'Residential', 'C', 'Commercial', 'RC',");
    sql.append("               'Residential Cum Commercial') \"projectTypeName\",");
    sql.append("        A.APPROVAL_ID \"approvalId\",");
    sql.append(" P.PROJECT_NAME \"projectName\",");
    sql.append(" T.TYPE_NAME \"itemTypeName\"");
    sql.append(" FROM RL_ITEM I,");
    sql.append("      RL_ITEM_TYPE T,");
    sql.append("      RL_PROJECT P,");
    sql.append("      RL_RAJUK_APPROVAL A");
    sql.append(" WHERE I.PROJECT_NO = P.PROJECT_NO(+)");
    sql.append("   AND P.APPROVAL_NO=A.APPROVAL_NO(+)");
    sql.append("   AND I.ITEM_TYPE_NO=T.TYPE_NO");
    sql.append("   AND I.ITEM_TYPE_NO = :ITEM_TYPE_NO");
    sql.append("   AND I.PROJECT_NO = NVL(:PROJECT_NO,I.PROJECT_NO)");
    sql.append("   AND I.ITEM_NO = nvl(:ITEM_NO,I.ITEM_NO)");

    Map<String, String> params = new HashMap<>();
    params.put("ITEM_NO", itemNo);
    params.put("ITEM_TYPE_NO", itemTypeNo);
    params.put("PROJECT_NO", projectNo);

    return db.queryForList(sql.toString(), params);
  }

  public Map getItemDetails(String itemNo) {
    Map<String, String> params = new HashMap<>();
    params.put("ITEM_NO", itemNo);

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
    sql.append(" I.TERMS_AND_CONDITION \"termsAndCondition\",");
    sql.append(" I.TERMS_AND_CONDITION_BN \"termsAndConditionBn\",");
    sql.append(" I.DESCR \"descr\",");
    sql.append(" I.DESCR_BN \"descrBn\",");
    sql.append(" I.INACTIVE_FLAG \"inactiveFlag\",");
    sql.append(" i.SECURITY_FLAG \"securityFlag\",");
    sql.append(" i.CCTV_FLAG \"cctvFlag\",");
    sql.append(" i.CONFERENCE_HALL_FLAG \"conferenceHallFlag\",");
    sql.append(" i.HEATING_FLAG \"heatingFlag\",");
    sql.append(" i.COOLING_FLAG \"coolingFlag\",");
    sql.append(" i.NUMBER_OF_BALCONY \"numberOfBalcony\",");
    sql.append(" i.BUILT_YEAR \"builtYear\",");
    sql.append(" i.DISCOUNT_AMOUNT \"discountAmount\",");
    sql.append(" i.DISCOUNT_PCT \"discountPct\",");
    sql.append(" i.INTERNET_FLAG \"internetFlag\",");
    sql.append(" i.CABLE_TV_FLAG \"cableTvFlag\",");
    sql.append(" LISTAGG(INSTALLMENT_AMOUNT,',') WITHIN GROUP(ORDER BY N.ITEM_NO ) \"installmentNumber\",");
    sql.append(" i.net_Price \"netPrice\",");
    sql.append(" P.PROJECT_ID \"projectId\",");
    sql.append(" P.PROJECT_LOCATION \"projectLocation\",");
    sql.append(" P.PROJECT_TYPE \"projectType\",");
    sql.append(" DECODE(P.PROJECT_TYPE, 'R', 'Residential', 'C', 'Commercial', 'RC',");
    sql.append("        'Residential Cum Commercial') \"projectTypeName\",");
    sql.append(" A.APPROVAL_ID \"approvalId\",");
    sql.append(" P.PROJECT_NAME \"projectName\",");
    sql.append(" T.TYPE_NAME \"itemTypeName\"");
    sql.append(" FROM RL_ITEM I,");
    sql.append("      RL_ITEM_TYPE T,");
    sql.append("      RL_PROJECT P,");
    sql.append("      RL_ITEM_INSTALLMENT N,");
    sql.append("      RL_RAJUK_APPROVAL A");
    sql.append(" WHERE I.PROJECT_NO = P.PROJECT_NO(+)");
    sql.append("   AND P.APPROVAL_NO=A.APPROVAL_NO(+)");
    sql.append("   AND I.ITEM_NO=N.ITEM_NO(+)");
    sql.append("   AND I.ITEM_TYPE_NO=T.TYPE_NO");
//        sql.append("   AND I.ITEM_TYPE_NO = 2");
    sql.append("   AND I.ITEM_NO = :ITEM_NO");
    sql.append(" GROUP BY I.ITEM_NO,");
    sql.append(" I.ITEM_ID,");
    sql.append(" I.PROJECT_NO,");
    sql.append(" I.PLOT_TYPE,");
    sql.append(" I.ROAD_SIZE,");
    sql.append(" I.FACING_NO,");
    sql.append(" I.BLOCK_NAME,");
    sql.append(" I.PLOT_SIZE,");
    sql.append(" I.PRICE,");
    sql.append(" I.TOTAL_PRICE,");
    sql.append(" I.FLAT_SIZE,");
    sql.append(" I.FLAT_PLACEOF_STORID,");
    sql.append(" I.FLAT_NO,");
    sql.append(" I.NUMBER_OF_LIFT,");
    sql.append(" I.DECORATION_CONDITION,");
    sql.append(" I.BED_ROOM,");
    sql.append(" I.LIVING_AND_DINING,");
    sql.append(" I.KITCHEN,");
    sql.append(" I.TOILETS,");
    sql.append(" I.SWIMMING_POOL,");
    sql.append(" I.GYM,");
    sql.append(" I.PARKING_FLAG,");
    sql.append(" I.PARKING_PRICE,");
    sql.append(" I.SS_CREATED_ON,");
    sql.append(" I.SS_CREATOR,");
    sql.append(" I.SS_MODIFIED_ON,");
    sql.append(" I.SS_MODIFIER,");
    sql.append(" I.ITEM_TYPE_NO,");
    sql.append(" I.FLAT_TYPE,");
    sql.append(" I.ITEM_BRAND_PHOTO,");
    sql.append(" I.ITEM_INVENTORY_FLAG,");
    sql.append(" I.ITEM_NAME,");
    sql.append(" I.DESCR,");
    sql.append(" I.DESCR_BN,");
    sql.append(" I.INACTIVE_FLAG,");
    sql.append(" i.SECURITY_FLAG,");
    sql.append(" i.CCTV_FLAG,");
    sql.append(" i.CONFERENCE_HALL_FLAG,");
    sql.append(" i.HEATING_FLAG,");
    sql.append(" i.COOLING_FLAG,");
    sql.append(" i.NUMBER_OF_BALCONY,");
    sql.append(" i.BUILT_YEAR,");
    sql.append(" i.DISCOUNT_AMOUNT,");
    sql.append(" i.TERMS_AND_CONDITION,");
    sql.append(" i.TERMS_AND_CONDITION_BN,");
    sql.append(" i.DISCOUNT_PCT,");
    sql.append(" i.INTERNET_FLAG,");
    sql.append(" i.CABLE_TV_FLAG,");
    sql.append(" i.net_Price,");
    sql.append(" P.PROJECT_ID,");
    sql.append(" P.PROJECT_LOCATION,");
    sql.append(" P.PROJECT_TYPE,");
    sql.append(" P.PROJECT_TYPE,");
    sql.append(" A.APPROVAL_ID,");
    sql.append(" P.PROJECT_NAME,");
    sql.append(" T.TYPE_NAME");


    return db.queryForMap(sql.toString(), params);
  }


  public List getFeatureProperty(Long itemNo) {
    StringBuilder sql = new StringBuilder();

    sql.append(" SELECT * FROM (");
    sql.append("          SELECT I.ITEM_NO                                \"itemNo\",");
    sql.append("                 I.ITEM_ID                                \"itemId\",");
    sql.append("                 I.PROJECT_NO                             \"projectNo\",");
    sql.append("                 I.PLOT_TYPE                              \"plotType\",");
    sql.append("                 I.ROAD_SIZE                              \"roadSize\",");
    sql.append("                 I.FACING_NO                              \"facingNo\",");
    sql.append("                 I.BLOCK_NAME                             \"blockName\",");
    sql.append("                 I.PLOT_SIZE                              \"plotSize\",");
    sql.append("                 I.PRICE                                  \"price\",");
    sql.append("                 I.TOTAL_PRICE                            \"totalPrice\",");
    sql.append("                 I.FLAT_SIZE                              \"flatSize\",");
    sql.append("                 I.FLAT_PLACEOF_STORID                    \"flatPlaceofStorid\",");
    sql.append("                 I.FLAT_NO                                \"flatNo\",");
    sql.append("                 I.NUMBER_OF_LIFT                         \"numberOfLift\",");
    sql.append("                 I.DECORATION_CONDITION                   \"decorationCondition\",");
    sql.append("                 I.BED_ROOM                               \"bedRoom\",");
    sql.append("                 I.LIVING_AND_DINING                      \"livingAndDining\",");
    sql.append("                 I.KITCHEN                                \"kitchen\",");
    sql.append("                 I.VARANDA                                \"varanda\",");
    sql.append("                 I.TOILETS                                \"toilets\",");
    sql.append("                 I.SWIMMING_POOL                          \"swimmingPool\",");
    sql.append("                 I.GYM                                    \"gym\",");
    sql.append("                 I.PARKING_FLAG                           \"parkingFlag\",");
    sql.append("                 i.SECURITY_FLAG                           \"securityFlag\",");
    sql.append("                 I.PARKING_PRICE                          \"parkingPrice\",");
    sql.append("                 I.SS_CREATED_ON                          \"ssCreatedOn\",");
    sql.append("                 I.SS_CREATOR                             \"ssCreator\",");
    sql.append("                 I.SS_MODIFIED_ON                         \"ssModifiedOn\",");
    sql.append("                 I.SS_MODIFIER                            \"ssModifier\",");
    sql.append("                 I.ITEM_TYPE_NO                           \"itemTypeNo\",");
    sql.append("                 I.FLAT_TYPE                              \"flatType\",");
    sql.append("                 I.ITEM_BRAND_PHOTO                       \"itemBrandPhoto\",");
    sql.append("                 I.ITEM_INVENTORY_FLAG                    \"itemInventoryFlag\",");
    sql.append("                 I.ITEM_NAME                              \"itemName\",");
    sql.append("                 I.DESCR                                  \"descr\",");
    sql.append("                 I.DESCR_BN                                  \"descrBn\",");
    sql.append("                 I.INACTIVE_FLAG                          \"inactiveFlag\",");
    sql.append("                 i.CCTV_FLAG \"cctvFlag\",");
    sql.append("                 i.CONFERENCE_HALL_FLAG \"conferenceHallFlag\",");
    sql.append("                 i.HEATING_FLAG \"heatingFlag\",");
    sql.append("                 i.COOLING_FLAG \"coolingFlag\",");
    sql.append("                 i.NUMBER_OF_BALCONY \"numberOfBalcony\",");
    sql.append("                 i.BUILT_YEAR \"builtYear\",");
    sql.append("                 i.DISCOUNT_AMOUNT \"discountAmount\",");
    sql.append("                 i.DISCOUNT_PCT \"discountPct\",");
    sql.append("                 i.INTERNET_FLAG \"internetFlag\",");
    sql.append("                 i.CABLE_TV_FLAG \"cableTvFlag\",");
    sql.append("                 i.net_Price \"netPrice\",");
    sql.append("                 P.PROJECT_ID                             \"projectId\",");
    sql.append("                 P.PROJECT_LOCATION                       \"projectLocation\",");
    sql.append("                 P.PROJECT_TYPE                           \"projectType\",");
    sql.append("                 DECODE(P.PROJECT_TYPE, 'R', 'Residential', 'C', 'Commercial', 'RC',");
    sql.append("                        'Residential Cum Commercial')     \"projectTypeName\",");
    sql.append("                 A.APPROVAL_ID                            \"approvalId\",");
    sql.append("                 T.TYPE_NAME \"itemTypeName\",");
    sql.append("                 P.PROJECT_NAME                           \"projectName\",");
    sql.append("                 ROW_NUMBER() over (ORDER BY ITEM_NO ASC) SL");
    sql.append("          FROM RL_ITEM I,");
    sql.append("               RL_PROJECT P,");
    sql.append("               RL_ITEM_TYPE T,");
    sql.append("               RL_RAJUK_APPROVAL A");
    sql.append("          WHERE I.PROJECT_NO = P.PROJECT_NO");
    sql.append("            AND P.APPROVAL_NO = A.APPROVAL_NO");
    sql.append("            AND I.ITEM_TYPE_NO=T.TYPE_NO");
    sql.append("            AND NVL(I.INACTIVE_FLAG, 0) = 0");
    sql.append("            AND NVL(I.ITEM_INVENTORY_FLAG, 0) = 0");
    sql.append("            AND I.ITEM_NO<>:ITEM_NO");
    sql.append("            AND I.PROJECT_NO = (SELECT PROJECT_NO FROM RL_ITEM WHERE ITEM_NO = :ITEM_NO)");
    sql.append("      )");
    sql.append(" WHERE SL <= (SELECT NVL(DISPLAY_FEATURE_LIST_NUMBER, SL) FROM RL_CONFIG)");


    Map<String, Long> params = new HashMap<>();
    params.put("ITEM_NO", itemNo);

    return db.queryForList(sql.toString(), params);
  }
}

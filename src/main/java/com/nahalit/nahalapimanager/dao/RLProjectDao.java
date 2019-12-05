package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RLProjectDao {
  private final NamedParameterJdbcTemplate db;

  public RLProjectDao(NamedParameterJdbcTemplate db) {
    this.db = db;
  }

  public String getProjectId(String projectTypeNo) {
    StringBuilder sql = new StringBuilder();
    Map<String, String> params = new HashMap<>();
    params.put("PROJECT_TYPE_NO", projectTypeNo);

    sql.append(" SELECT case when :PROJECT_TYPE_NO =1 then 'LP'" +
        "when :PROJECT_TYPE_NO =2 then 'AP' end || LPAD(nvl(MAX(TO_NUMBER(SUBSTR(PROJECT_ID, 3))),0) + 1, 3, 0) ID");
    sql.append(" FROM RL_PROJECT WHERE PROJECT_TYPE_NO=:PROJECT_TYPE_NO");

    Map mapCustomerId = db.queryForMap(sql.toString(), params);

    return mapCustomerId.get("ID").toString();
  }

  public List getProjectList(String projectNo, String projectTypeNo, String projectType, String projectStatus,String projectRegion) {

    StringBuilder sql = new StringBuilder();

    sql.append(" SELECT  P.PROJECT_NO \"projectNo\",");
    sql.append(" P.PROJECT_ID \"projectId\",");
    sql.append(" P.PROJECT_NAME \"projectName\",");
    sql.append(" P.PROJECT_TYPE \"projectType\",");
    sql.append(" P.DESCR \"descr\",");
    sql.append(" P.APPROVAL_NO \"approvalNo\",");
    sql.append(" P.PROJECT_LOCATION \"projectLocation\",");
    sql.append(" P.PLOT_SIZE \"plotSize\",");
    sql.append(" P.BLOCK_NAME_FROM \"blockNameFrom\",");
    sql.append(" P.BLOCK_NAME_TO \"blockNameTo\",");
    sql.append(" P.LAND_AREA \"landArea\",");
    sql.append(" P.NO_OF_STORIED \"noOfStoried\",");
    sql.append(" P.NO_OF_LIFT \"noOfLift\",");
    sql.append(" P.FACING_NO \"facingNo\",");
    sql.append(" P.NO_OF_FLAT \"noOfFlat\",");
    sql.append(" P.CAR_PARKING \"carParking\",");
    sql.append(" P.HAND_OVER_TIME \"handOverTime\",");
    sql.append(" P.OPEN_SPACE \"openSpace\",");
    sql.append(" P.SS_CREATED_ON \"ssCreatedOn\",");
    sql.append(" P.SS_CREATOR \"ssCreator\",");
    sql.append(" P.SS_MODIFIED_ON \"ssModifiedOn\",");
    sql.append(" P.SS_MODIFIER \"ssModifier\",");
    sql.append(" P.ROAD_SIZE \"roadSize\",");
    sql.append(" P.region_no \"regionNo\",");
    sql.append(" P.subregion_no \"subregionNo\",");
    sql.append(" P.PROJECT_TYPE_NO \"projectTypeNo\",");
    sql.append(" P.PROJECT_REGION \"projectRegion\",");
    sql.append(" P.APPROVAL_INFORMATION \"approvalInformation\",");
    sql.append(" P.UOM_NO \"uomNo\",");
    sql.append(" U.UOM_SHORT \"uomShort\",");
    sql.append(" Y.TYPE_NAME \"projectTypeName\",");
    sql.append(" F.FACING_NAME \"facingName\",");
    sql.append(" p.project_status \"projectStatus\",");
    sql.append(" P.PROJECT_LAYOUT_PHOTO \"projectLayoutPhoto\"");
    sql.append(" FROM RL_PROJECT P, RL_PROJECT_TYPE Y,IN_UOM U,RL_FACING F");
    sql.append(" WHERE P.PROJECT_TYPE_NO=Y.TYPE_NO");
    sql.append(" AND P.FACING_NO=F.FACING_NO(+)");
    sql.append(" AND P.UOM_NO=U.UOM_NO(+)");
    sql.append(" AND nvl(PUBLISH_FLAG,0)=1");
    sql.append(" AND P.PROJECT_TYPE_NO=NVL(:PROJECT_TYPE_NO,P.PROJECT_TYPE_NO)");
    sql.append(" AND P.PROJECT_TYPE=NVL(:PROJECT_TYPE,P.PROJECT_TYPE)");
    sql.append(" AND nvl(P.PROJECT_REGION,'-XX') = NVL ( :PROJECT_REGION, nvl(P.PROJECT_REGION,'-XX'))");
    sql.append(" AND NVL(P.PROJECT_STATUS,'SG')=NVL(:PROJECT_STATUS,NVL(P.PROJECT_STATUS,'SG'))");
    sql.append(" AND P.PROJECT_NO=NVL(:PROJECT_NO,P.PROJECT_NO)");

    Map<String, String> params = new HashMap<>();
    params.put("PROJECT_NO", projectNo);
    params.put("PROJECT_TYPE_NO", projectTypeNo);
    params.put("PROJECT_TYPE", projectType);
    params.put("PROJECT_STATUS", projectStatus);
    params.put("PROJECT_REGION", projectRegion);

    return db.queryForList(sql.toString(), params);
  }


  public Map getProjectDetails(String projectNo) {

    StringBuilder sql = new StringBuilder();

    sql.append(" SELECT  P.PROJECT_NO \"projectNo\",");
    sql.append(" P.PROJECT_ID \"projectId\",");
    sql.append(" P.PROJECT_NAME \"projectName\",");
    sql.append(" P.PROJECT_TYPE \"projectType\",");
    sql.append(" P.DESCR \"descr\",");
    sql.append(" P.PROJECT_LOCATION \"projectLocation\",");
    sql.append(" P.PLOT_SIZE \"plotSize\",");
    sql.append(" P.BLOCK_NAME_FROM \"blockNameFrom\",");
    sql.append(" P.BLOCK_NAME_TO \"blockNameTo\",");
    sql.append(" P.LAND_AREA \"landArea\",");
    sql.append(" P.NO_OF_STORIED \"noOfStoried\",");
    sql.append(" P.NO_OF_LIFT \"noOfLift\",");
    sql.append(" P.FACING_NO \"facingNo\",");
    sql.append(" P.NO_OF_FLAT \"noOfFlat\",");
    sql.append(" P.CAR_PARKING \"carParking\",");
    sql.append(" P.HAND_OVER_TIME \"handOverTime\",");
    sql.append(" P.OPEN_SPACE \"openSpace\",");
    sql.append(" P.SS_CREATED_ON \"ssCreatedOn\",");
    sql.append(" P.SS_CREATOR \"ssCreator\",");
    sql.append(" P.SS_MODIFIED_ON \"ssModifiedOn\",");
    sql.append(" P.SS_MODIFIER \"ssModifier\",");
    sql.append(" P.ROAD_SIZE \"roadSize\",");
    sql.append(" p.project_status \"projectStatus\",");
    sql.append(" P.PROJECT_LAYOUT_PHOTO \"projectLayoutPhoto\",");
    sql.append(" P.PROJECT_TYPE_NO \"projectTypeNo\",");
    sql.append(" P.PROJECT_REGION \"projectRegion\",");
    sql.append(" P.GENERAL_PLOT_NO \"generalPlotNo\",");
    sql.append(" P.COMMERCIAL_PLOT_NO \"commercialPlotNo\",");
    sql.append(" P.DUPLEX_PLOT_NO \"duplexPlotNo\",");
    sql.append(" P.PUBLISH_FLAG \"publishFlag\",");
    sql.append(" P.NUMBER_OF_PLOT \"numberOfPlot\",");
    sql.append(" P.APPROVAL_INFORMATION \"approvalInformation\",");
    sql.append(" P.UOM_NO \"uomNo\",");
    sql.append(" P.region_no \"regionNo\",");
    sql.append(" P.subregion_no \"subregionNo\",");
    sql.append(" Y.TYPE_NAME \"projectTypeName\",");
    sql.append(" U.UOM_SHORT \"uomShort\",");
    sql.append(" F.FACING_NAME \"facingName\"");
    sql.append(" FROM RL_PROJECT P,RL_FACING F, RL_PROJECT_TYPE Y,IN_UOM U");
    sql.append(" WHERE P.FACING_NO=F.FACING_NO(+)");
    sql.append(" AND P.PROJECT_TYPE_NO=Y.TYPE_NO");
    sql.append(" AND P.UOM_NO=U.UOM_NO(+)");
    sql.append(" AND P.PROJECT_NO=(:PROJECT_NO)");

    Map<String, String> params = new HashMap<>();
    params.put("PROJECT_NO", projectNo);

    return db.queryForMap(sql.toString(), params);
  }
}

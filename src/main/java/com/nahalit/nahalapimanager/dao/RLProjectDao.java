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

    sql.append(" SELECT 'LP' || LPAD(MAX(TO_NUMBER(SUBSTR(PROJECT_ID, 3))) + 1, 3, 0) ID");
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
    sql.append(" P.ROAD_SIZE_NO \"roadSizeNo\",");
    sql.append(" P.PROJECT_TYPE_NO \"projectTypeNo\",");
    sql.append(" P.PROJECT_REGION \"projectRegion\",");
    sql.append(" Y.TYPE_NAME \"projectTypeName\",");
    sql.append(" p.project_status \"projectStatus\",");
    sql.append(" P.PROJECT_LAYOUT_PHOTO \"projectLayoutPhoto\",");
    sql.append(" A.APPROVAL_ID \"approvalId\"");
    sql.append(" FROM RL_PROJECT P,RL_RAJUK_APPROVAL A, RL_PROJECT_TYPE Y");
    sql.append(" WHERE P.APPROVAL_NO=A.APPROVAL_NO(+)");
    sql.append(" AND P.PROJECT_TYPE_NO=Y.TYPE_NO");
    sql.append(" AND P.PROJECT_TYPE_NO=NVL(:PROJECT_TYPE_NO,P.PROJECT_TYPE_NO)");
    sql.append(" AND P.PROJECT_TYPE=NVL(:PROJECT_TYPE,P.PROJECT_TYPE)");
    sql.append(" AND P.PROJECT_REGION=NVL(:PROJECT_REGION,P.PROJECT_REGION)");
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
    sql.append(" P.ROAD_SIZE_NO \"roadSizeNo\",");
    sql.append(" p.project_status \"projectStatus\",");
    sql.append(" P.PROJECT_LAYOUT_PHOTO \"projectLayoutPhoto\",");
    sql.append(" P.PROJECT_TYPE_NO \"projectTypeNo\",");
    sql.append(" P.PROJECT_REGION \"projectRegion\",");
    sql.append(" A.APPROVAL_ID \"approvalId\",");
    sql.append(" Y.TYPE_NAME \"projectTypeName\",");
    sql.append(" F.FACING_NAME \"facingName\"");
    sql.append(" FROM RL_PROJECT P,RL_RAJUK_APPROVAL A,RL_FACING F, RL_PROJECT_TYPE Y");
    sql.append(" WHERE P.APPROVAL_NO=A.APPROVAL_NO(+) AND P.FACING_NO=F.FACING_NO(+)");
    sql.append(" AND P.PROJECT_TYPE_NO=Y.TYPE_NO");
    sql.append(" AND P.PROJECT_NO=(:PROJECT_NO)");

    Map<String, String> params = new HashMap<>();
    params.put("PROJECT_NO", projectNo);

    return db.queryForMap(sql.toString(), params);
  }
}

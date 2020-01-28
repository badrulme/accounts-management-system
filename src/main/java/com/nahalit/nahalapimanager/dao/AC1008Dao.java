package com.nahalit.nahalapimanager.dao;

import com.nahalit.nahalapimanager.utillibrary.RandomString;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AC1008Dao {
  private final NamedParameterJdbcTemplate db;

  public AC1008Dao(NamedParameterJdbcTemplate db) {
    this.db = db;
  }


  public String getVoucherId(Integer vtypeNo) {
    StringBuilder sql = new StringBuilder();
    Map<String, Integer> params = new HashMap<>();
    params.put("VTYPE_NO", vtypeNo);

    sql.append(" select (select ALIAS from AC_VOUCHERTYPE where VTYPE_NO = :VTYPE_NO) || to_char(sysdate, 'MMRR') || lpad(nvl(max(substr(V_ID, -6)), 0) + 1, 6, 0) ID");
    sql.append(" from ac_voucher v");
    sql.append(" where VTYPE_NO = 1");
    sql.append(" group by 1");

    Map mapCustomerId = db.queryForMap(sql.toString(), params);
    return mapCustomerId.get("ID").toString();
  }

  public List getVoucherRefList() {
    StringBuilder sql = new StringBuilder();
    sql.append(" SELECT V.V_NO           \"vno\",");
    sql.append("        V.V_ID           \"vid\",");
    sql.append("        VTYPE_NO         \"vtypeNo\",");
    sql.append("        NARRATION        \"narration\",");
    sql.append("        POST_FLAG        \"postFlag\",");
    sql.append("        OP_PERIODNO      \"opPeriodno\",");
    sql.append("        V_DATE           \"vdate\",");
    sql.append("        MODULE           \"module\",");
    sql.append("        VOID_FLAG        \"voidFlag\",");
    sql.append("        CHECK_FLAG       \"checkFlag\",");
    sql.append("        CHECK_BY         \"checkBy\",");
    sql.append("        CHECK_DATE       \"checkDate\",");
    sql.append("        POST_BY          \"postBy\",");
    sql.append("        POST_DATE        \"postDate\",");
    sql.append("        FILE_EXT         \"fileExt\",");
    sql.append("        FILE_SIZE        \"file\",");
    sql.append("        V.COMPANY_NO     \"companyNo\",");
    sql.append("        PAID_TO          \"paidTo\",");
    sql.append("        RECEIVE_FROM     \"receiveFrom\",");
    sql.append("        V.SS_CREATOR     \"ssCreator\",");
    sql.append("        V.SS_CREATED_ON  \"ssCreatedOn\",");
    sql.append("        V.SS_MODIFIER    \"ssModifier\",");
    sql.append("        V.SS_MODIFIED_ON \"ssModifiedOn\",");
    sql.append("        P.EMP_NAME_ID    \"preparedBy\",");
    sql.append("        C.EMP_NAME_ID    \"checkedBy\",");
    sql.append("        PO.EMP_NAME_ID   \"postedBy\"");
    sql.append(" FROM AC_VOUCHER V,");
    sql.append("      HR_EMP_V P,");
    sql.append("      HR_EMP_V C,");
    sql.append("      HR_EMP_V PO");
    sql.append(" WHERE V.SS_CREATOR = P.EMP_NO(+)");
    sql.append("   AND V.CHECK_BY = C.EMP_NO(+)");
    sql.append("   AND V.POST_BY = PO.EMP_NO(+)");

    Map params = new HashMap();

    return db.queryForList(sql.toString(), params);
  }

  public void deleteByVNo(Long vNo) {
    Map<String, Long> params = new HashMap<>();
    params.put("V_NO", vNo);
    db.update("DELETE AC_VOUCHERDTL WHERE V_NO=:V_NO", params);
  }

}

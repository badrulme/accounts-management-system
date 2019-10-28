package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RL1019Dao {
  private final NamedParameterJdbcTemplate db;

  public RL1019Dao(NamedParameterJdbcTemplate db) {
    this.db = db;
  }

  public String getTrnId(String trnDate) {
    StringBuilder sql = new StringBuilder();
    Map<String, String> params = new HashMap<>();
    params.put("TRN_DATE", trnDate);
    sql.append(" SELECT MAX(substr(TRN_ID, 6)) + 1");
    sql.append(" FROM RL_TRN T");
    sql.append(" WHERE substr(TRN_ID, 4, 2) = TO_CHAR(:TRN_DATE, 'YY')");

    Map mapId = db.queryForMap(sql.toString(), params);

    return mapId.get("ID").toString();
  }

  public List getTrnList(String trnNo, String customerNo, String itemNo, String ssCreartor) {

    Map<String, String> params = new HashMap();
    params.put("TRN_NO", trnNo);
    params.put("CUSTOMER_NO", customerNo);
    params.put("ITEM_NO", itemNo);

    StringBuilder sql = new StringBuilder();

    sql.append(" SELECT T.TRN_NO \"trnNo\",");
    sql.append("     T.TRN_ID \"trnId\",");
    sql.append("     T.TRN_DATE \"trnDate\",");
    sql.append("     T.ITEM_NO \"itemNo\",");
    sql.append("     T.CUSTOMER_NO \"customerNo\",");
    sql.append("     T.TOTAL_PRICE \"totalPrice\",");
    sql.append("     T.DISCOUNT_PCT \"discountPct\",");
    sql.append("     T.DISCOUNT_AMOUNT \"discountAmount\",");
    sql.append("     T.SETTLEMENT_PRICE \"settlementPrice\",");
    sql.append("     T.BOOKING_REF_PERSON \"bookingRefPerson\",");
    sql.append("     T.REF_CONTACT_NO \"refContactNo\",");
    sql.append("     T.PAYMENT_TYPE \"paymentType\",");
    sql.append("     T.BOOKING_AMOUNT \"bookingAmount\",");
    sql.append("     T.PAYMENT_MODE \"paymentMode\",");
    sql.append("     T.CHEQUE_NO \"chequeNo\",");
    sql.append("     T.CHEQUE_DATE \"chequeDate\",");
    sql.append("     T.BANK_NAME \"bankName\",");
    sql.append("     T.BRANCH_NAME \"branchName\",");
    sql.append("     T.BANK_ACC_NO \"bankAccNo\",");
    sql.append("     T.TRANSACTION_ID \"transactionId\",");
    sql.append("     T.PAYORDER_NO \"payorderNo\",");
    sql.append("     T.PAY_MODE \"payMode\",");
    sql.append("     T.PAID_AMOUNT \"paidAmount\",");
    sql.append("     T.WEB_USER_FLAG \"webUserFlag\",");
    sql.append("     T.SS_CREATOR \"ssCreator\",");
    sql.append("     T.SS_CREATED_ON \"ssCreatedOn\",");
    sql.append("     T.SS_MODIFIER \"ssModifier\",");
    sql.append("     T.SS_MODIFIED_ON \"ssModifiedOn\",");
    sql.append("     T.DD_NO \"ddNo\",");
    sql.append("     T.TT_NO \"ttNo\",");
    sql.append("     T.APPROVE_FLAG \"approveFlag\",");
    sql.append("     DECODE(nvl(T.APPROVE_FLAG,0),1,'Approved',0,'Pending',2,'Canceled') \"approveFlagName\",");
    sql.append("     T.APPROVE_DATE \"approveDate\",");
    sql.append("     T.APPROVE_BY \"approveBy\",");
    sql.append("     C.CUSTOMER_ID \"customerId\",");
    sql.append("     C.CUSTOMER_NAME \"customerName\",");
    sql.append("     I.ITEM_ID \"itemId\",");
    sql.append("     I.ITEM_NAME \"itemName\",");
    sql.append("     y.TYPE_NAME \"itemTypeName\"");
    sql.append(" FROM RL_TRN T,");
    sql.append("     RL_CUSTOMER C,");
    sql.append("     RL_ITEM I,");
    sql.append("     RL_ITEM_TYPE y");
    sql.append(" WHERE T.CUSTOMER_NO= C.CUSTOMER_NO");
    sql.append("   AND T.ITEM_NO=I.ITEM_NO(+)");
    sql.append("   AND I.ITEM_TYPE_NO=y.TYPE_NO");
    sql.append(" AND T.TRN_NO=NVL(:TRN_NO,T.TRN_NO)");
    sql.append(" AND T.CUSTOMER_NO = NVL(:CUSTOMER_NO,T.CUSTOMER_NO)");
    sql.append(" order by t.trn_no");
//    sql.append(" AND T.ITEM_NO = NVL(:ITEM_NO,T.ITEM_NO)");
//    sql.append(" AND T.SS_CREATOR = NVL(:ITEM_NO,T.SS_CREATOR)");

    return db.queryForList(sql.toString(), params);
  }

  public Map getTrnDetails(String trnNo) {

    Map<String, String> params = new HashMap();
    params.put("TRN_NO", trnNo);

    StringBuilder sql = new StringBuilder();

    sql.append(" SELECT T.TRN_NO \"trnNo\",");
    sql.append("     T.TRN_ID \"trnId\",");
    sql.append("     T.TRN_DATE \"trnDate\",");
    sql.append("     T.ITEM_NO \"itemNo\",");
    sql.append("     T.CUSTOMER_NO \"customerNo\",");
    sql.append("     T.TOTAL_PRICE \"totalPrice\",");
    sql.append("     T.DISCOUNT_PCT \"discountPct\",");
    sql.append("     T.DISCOUNT_AMOUNT \"discountAmount\",");
    sql.append("     T.SETTLEMENT_PRICE \"settlementPrice\",");
    sql.append("     T.BOOKING_REF_PERSON \"bookingRefPerson\",");
    sql.append("     T.REF_CONTACT_NO \"refContactNo\",");
    sql.append("     T.PAYMENT_TYPE \"paymentType\",");
    sql.append("     T.BOOKING_AMOUNT \"bookingAmount\",");
    sql.append("     T.PAYMENT_MODE \"paymentMode\",");
    sql.append("     T.CHEQUE_NO \"chequeNo\",");
    sql.append("     T.CHEQUE_DATE \"chequeDate\",");
    sql.append("     T.BANK_NAME \"bankName\",");
    sql.append("     T.BRANCH_NAME \"branchName\",");
    sql.append("     T.BANK_ACC_NO \"bankAccNo\",");
    sql.append("     T.TRANSACTION_ID \"transactionId\",");
    sql.append("     T.PAYORDER_NO \"payorderNo\",");
    sql.append("     T.PAY_MODE \"payMode\",");
    sql.append("     T.PAID_AMOUNT \"paidAmount\",");
    sql.append("     T.WEB_USER_FLAG \"webUserFlag\",");
    sql.append("     T.SS_CREATOR \"ssCreator\",");
    sql.append("     DECODE(nvl(T.APPROVE_FLAG,0),1,'Approved',0,'Pending',2,'Canceled') \"approveFlagName\",");
    sql.append("     y.TYPE_NAME \"itemTypeName\",");
    sql.append("     T.SS_CREATED_ON \"ssCreatedOn\",");
    sql.append("     T.SS_MODIFIER \"ssModifier\",");
    sql.append("     T.SS_MODIFIED_ON \"ssModifiedOn\",");
    sql.append("     T.DD_NO \"ddNo\",");
    sql.append("     T.TT_NO \"ttNo\",");
    sql.append("     T.APPROVE_FLAG \"approveFlag\",");
    sql.append("     T.APPROVE_DATE \"approveDate\",");
    sql.append("     T.APPROVE_BY \"approveBy\",");
    sql.append("     C.CUSTOMER_ID \"customerId\",");
    sql.append("     C.CUSTOMER_NAME \"customerName\",");
    sql.append("     I.ITEM_ID \"itemId\",");
    sql.append("     I.ITEM_NAME \"itemName\"");
    sql.append(" FROM RL_TRN T,");
    sql.append("     RL_CUSTOMER C,");
    sql.append("     RL_ITEM I,");
    sql.append("     RL_ITEM_TYPE y");
    sql.append(" WHERE T.CUSTOMER_NO= C.CUSTOMER_NO");
    sql.append("   AND I.ITEM_TYPE_NO=y.TYPE_NO");
    sql.append("   AND T.ITEM_NO=I.ITEM_NO(+)");
    sql.append(" AND T.TRN_NO=:TRN_NO");

    return db.queryForMap(sql.toString(), params);
  }

}

package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RL1021Dao {
    private final NamedParameterJdbcTemplate db;

    public RL1021Dao(NamedParameterJdbcTemplate db) {
        this.db = db;
    }

    public List getTrnBalanceList() {
        Map<String, String> params = new HashMap<>();

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT CUSTOMER_NAME         \"customerName\",");
        sql.append("        CUSTOMER_ID           \"customerId\",");
        sql.append("        MOBILE                \"mobile\",");
        sql.append("        TRN_NO                \"trnNo\",");
        sql.append("        TRN_ID                \"trnId\",");
        sql.append("        TRN_DATE              \"trnDate\",");
        sql.append("        CUSTOMER_NO           \"customerNo\",");
        sql.append("        SETTLEMENT_PRICE      \"settlementPrice\",");
        sql.append("        BOOKING_AMOUNT        \"bookingAmount\",");
        sql.append("        COLLECTION_AMOUNT     \"collectionAmount\",");
        sql.append("        DOWN_PAYMENT_AMOUNT     \"downPaymentAmount\",");
        sql.append("        DUE_AMOUNT            \"dueAmount\"");
        sql.append("   FROM rl_trn_balance_v");

        return db.queryForList(sql.toString(), params);

    }
}

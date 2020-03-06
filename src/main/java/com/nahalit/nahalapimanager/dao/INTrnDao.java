package com.nahalit.nahalapimanager.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class INTrnDao {
    private final NamedParameterJdbcTemplate db;

    public INTrnDao(NamedParameterJdbcTemplate db) {
        this.db = db;
    }


    public String getTrnId(Date trnDate, Long trnTypeNo) {

        StringBuilder sql = new StringBuilder();
        Map params = new HashMap<>();
        params.put("TRN_DATE", trnDate);
        params.put("TRNTYPE_NO", trnTypeNo);

        sql.append(" SELECT NVL (");
        sql.append("           (  SELECT    (SELECT PREFIX_FORMAT");
        sql.append("                           FROM in_trntype");
        sql.append("                          WHERE TRNTYPE_NO = :TRNTYPE_NO)");
        sql.append("                     || TO_CHAR (NVL (:TRN_DATE, SYSDATE), 'RRMM')");
        sql.append("                     || LPAD (TO_NUMBER (MAX (SUBSTR (TRN_ID, 7)) + 1), 4, 0)");
        sql.append("                FROM IN_TRN");
        sql.append("               WHERE TO_CHAR (TRN_DATE, 'MMRR') =");
        sql.append("                        TO_CHAR (NVL (:TRN_DATE, SYSDATE), 'MMRR')");
        sql.append("                     AND SUBSTR (TRN_ID, 1, 2) = (SELECT PREFIX_FORMAT");
        sql.append("                                                    FROM in_trntype");
        sql.append("                                                   WHERE TRNTYPE_NO = :TRNTYPE_NO)");
        sql.append("            GROUP BY 1),");
        sql.append("              (SELECT PREFIX_FORMAT");
        sql.append("                 FROM in_trntype");
        sql.append("                WHERE TRNTYPE_NO = :TRNTYPE_NO)");
        sql.append("           || TO_CHAR (NVL (:TRN_DATE, SYSDATE), 'RRMM')");
        sql.append("           || '0001')");
        sql.append("           ID");
        sql.append("   FROM DUAL");

        Map mapTrnId = db.queryForMap(sql.toString(), params);

        return mapTrnId.get("ID").toString();
    }


    public void deleteAllTrnddtlByTrnNo(Long trnNo) {
        Map<String, Long> params = new HashMap<>();
        params.put("trn_No", trnNo);
        db.update("DELETE FROM  In_Trndtl T WHERE T.trn_No=:trn_No", params);
    }
}

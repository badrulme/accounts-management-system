package com.nahalit.realestateapimanager.dao.orcl;

import com.nahalit.realestateapimanager.dao.RlCustomerDao;
import com.nahalit.realestateapimanager.service.EmailService;
import com.nahalit.realestateapimanager.utillibrary.RandomString;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RlCustomerDaoOrcl implements RlCustomerDao {
  private final NamedParameterJdbcTemplate db;
  private final EmailService emailService;

  public RlCustomerDaoOrcl(NamedParameterJdbcTemplate _db, EmailService emailService) {
    this.db = _db;
    this.emailService = emailService;
  }

  @Override
  public Map<String, Object> isCustomerLogin(String customerUsername, String password) {
    StringBuilder sql = new StringBuilder();
    Map<String, String> params = new HashMap<>();
    params.put("customerUsername", customerUsername);
    params.put("password", password);

    Map<String, Object> exceptionMessage = new HashMap<>();

    sql.append(" select CUSTOMER_NO,CUSTOMER_ID,CUSTOMER_NAME,EMAIL,MOBILE");
    sql.append("             from RlCustomer");
    sql.append("             where (UPPER(CUSTOMER_ID) = UPPER(:customerUsername) and PASSWORD = :password)");
    sql.append("                or (LOWER(EMAIL) = LOWER(:customerUsername) and PASSWORD = :password)");

    try {
      return db.queryForMap(sql.toString(), params);
    } catch (Exception e) {
      exceptionMessage.put("loginStatus", 0);
      return exceptionMessage;
    }
  }

  @Override
  public String forgotPasswordByMail(String email) {
    Map<String, String> params = new HashMap();
    String randomPassword = RandomString.randomAlphaNumeric(8);
    params.put("EMAIL", email);
    params.put("NEWPASSWORD", randomPassword);
    try {
      int executeStatus = db.update("UPDATE RL_CUSTOMER SET PASSWORD=:NEWPASSWORD WHERE EMAIL=:EMAIL", params);
      if (executeStatus == 1) {
        String[] sendTo = email.trim().split(" ");
        emailService.sendEmail(sendTo, null, null, "Forgot Your Password", "Your updated password: " + randomPassword, false);
        return "Send New Password to " + email;
      } else {
        return "User not found for this email " + email;
      }
    } catch (Exception e) {
      return "User not found for this email " + email;
    }
  }
}

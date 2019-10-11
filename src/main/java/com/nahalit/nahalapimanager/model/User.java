package com.nahalit.nahalapimanager.model;

public class User {
  private Long USER_NO;
  private String USER_NAME;
  private String USER_TYPE;
  private String EMP_ID;
  private Long EMP_NO;
  private String EMP_NAME;
  private String JOBTITLE;
  private String BU_NAME;
  private String SESSION_KEY;
  private Long COMPANY_NO;
  private String COMPANY_NAME;
  private String PASSWORD;

  public Long getUSER_NO() {
    return USER_NO;
  }

  public void setUSER_NO(Long USER_NO) {
    this.USER_NO = USER_NO;
  }

  public String getUSER_NAME() {
    return USER_NAME;
  }

  public void setUSER_NAME(String USER_NAME) {
    this.USER_NAME = USER_NAME;
  }

  public String getUSER_TYPE() {
    return USER_TYPE;
  }

  public void setUSER_TYPE(String USER_TYPE) {
    this.USER_TYPE = USER_TYPE;
  }


  public String getEMP_ID() {
    return EMP_ID;
  }

  public void setEMP_ID(String EMP_ID) {
    this.EMP_ID = EMP_ID;
  }

  public Long getEMP_NO() {
    return EMP_NO;
  }

  public void setEMP_NO(Long EMP_NO) {
    this.EMP_NO = EMP_NO;
  }

  public String getEMP_NAME() {
    return EMP_NAME;
  }

  public void setEMP_NAME(String EMP_NAME) {
    this.EMP_NAME = EMP_NAME;
  }

  public String getJOBTITLE() {
    return JOBTITLE;
  }

  public void setJOBTITLE(String JOBTITLE) {
    this.JOBTITLE = JOBTITLE;
  }

  public String getBU_NAME() {
    return BU_NAME;
  }

  public void setBU_NAME(String BU_NAME) {
    this.BU_NAME = BU_NAME;
  }

  public String getSESSION_KEY() {
    return SESSION_KEY;
  }

  public void setSESSION_KEY(String SESSION_KEY) {
    this.SESSION_KEY = SESSION_KEY;
  }

  public Long getCOMPANY_NO() {
    return COMPANY_NO;
  }

  public void setCOMPANY_NO(Long COMPANY_NO) {
    this.COMPANY_NO = COMPANY_NO;
  }

  public String getCOMPANY_NAME() {
    return COMPANY_NAME;
  }

  public void setCOMPANY_NAME(String COMPANY_NAME) {
    this.COMPANY_NAME = COMPANY_NAME;
  }

  public void setPASSWORD(String PASSWORD) {
    this.PASSWORD = PASSWORD;
  }

  public String getPASSWORD() {
    return PASSWORD;
  }
}

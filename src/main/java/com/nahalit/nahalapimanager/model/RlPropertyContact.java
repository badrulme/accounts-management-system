package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlPropertyContact {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RL_PROPERTY_CONTACT")
  @SequenceGenerator(sequenceName = "S_RL_PROPERTY_CONTACT", allocationSize = 1, name = "RL_PROPERTY_CONTACT")
  private Long contactNo;
  private Long itemNo;
  private String cpName;
  private String cpEmail;
  private String cpMobile;
  private String cpComments;
  private Date contactDate;

  public Long getContactNo() {
    return contactNo;
  }

  public void setContactNo(Long contactNo) {
    this.contactNo = contactNo;
  }

  public Long r() {
    return itemNo;
  }

  public void setItemNo(Long itemNo) {
    this.itemNo = itemNo;
  }

  public String getCpName() {
    return cpName;
  }

  public void setCpName(String cpName) {
    this.cpName = cpName;
  }

  public String getCpEmail() {
    return cpEmail;
  }

  public void setCpEmail(String cpEmail) {
    this.cpEmail = cpEmail;
  }

  public String getCpMobile() {
    return cpMobile;
  }

  public void setCpMobile(String cpMobile) {
    this.cpMobile = cpMobile;
  }

  public String getCpComments() {
    return cpComments;
  }

  public void setCpComments(String cpComments) {
    this.cpComments = cpComments;
  }

  public Date getContactDate() {
    return contactDate;
  }

  public void setContactDate(Date contactDate) {
    this.contactDate = contactDate;
  }
}

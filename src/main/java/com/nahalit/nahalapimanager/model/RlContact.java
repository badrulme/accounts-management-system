package com.nahalit.nahalapimanager.model;

import javax.persistence.*;

@Entity
public class RlContact {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RL_CONTACT")
  @SequenceGenerator(sequenceName = "S_RL_CONTACT", allocationSize = 1, name = "RL_CONTACT")
  private Long contactNo;
  private Long itemNo;
  private String cpName;
  private String cpEmail;
  private String cpMobile;
  private String cpComments;

  public Long getContactNo() {
    return contactNo;
  }

  public void setContactNo(Long contactNo) {
    this.contactNo = contactNo;
  }

  public Long getItemNo() {
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
}

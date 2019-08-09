package com.nahalit.realestateapimanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

//@Table(name = "ReCustomer")
@Entity
public class ReCustomer {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
  @SequenceGenerator(sequenceName = "S_RE_CUSTOMER", allocationSize = 1, name = "CUST_SEQ")
  private Long customerNo;
  private String customerId;

//
//  @NotNull
//  @Size(max = 65)
//  @Column(name = "first_name")
//@Email
//@Column(unique = true)

  private String customerName;
  private String email;
  private String password;
  private String address;
  private String mobile;
  private String identityNumber;
  private String customerImageName;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;

  public Long getCustomerNo() {
    return customerNo;
  }

  public void setCustomerNo(Long customerNo) {
    this.customerNo = customerNo;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getIdentityNumber() {
    return identityNumber;
  }

  public void setIdentityNumber(String identityNumber) {
    this.identityNumber = identityNumber;
  }

  public String getCustomerImageName() {
    return customerImageName;
  }

  public void setCustomerImageName(String customerImageName) {
    this.customerImageName = customerImageName;
  }

  public Long getSsCreator() {
    return ssCreator;
  }

  public void setSsCreator(Long ssCreator) {
    this.ssCreator = ssCreator;
  }

  public Date getSsCreatedOn() {
    return ssCreatedOn;
  }

  public void setSsCreatedOn(Date ssCreatedOn) {
    this.ssCreatedOn = ssCreatedOn;
  }

  public Long getSsModifier() {
    return ssModifier;
  }

  public void setSsModifier(Long ssModifier) {
    this.ssModifier = ssModifier;
  }

  public Date getSsModifiedOn() {
    return ssModifiedOn;
  }

  public void setSsModifiedOn(Date ssModifiedOn) {
    this.ssModifiedOn = ssModifiedOn;
  }

  @Override
  public String toString() {
    return "ReCustomer{" +
        "customerNo=" + customerNo +
        ", customerId='" + customerId + '\'' +
        ", customerName='" + customerName + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", address='" + address + '\'' +
        ", mobile='" + mobile + '\'' +
        ", identityNumber='" + identityNumber + '\'' +
        ", customerImageName='" + customerImageName + '\'' +
        ", ssCreator=" + ssCreator +
        ", ssCreatedOn=" + ssCreatedOn +
        ", ssModifier=" + ssModifier +
        ", ssModifiedOn=" + ssModifiedOn +
        '}';
  }
}

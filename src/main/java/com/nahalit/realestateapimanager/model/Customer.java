package com.nahalit.realestateapimanager.model;

import javax.persistence.*;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
  @SequenceGenerator(sequenceName = "s_customer", allocationSize = 1, name = "CUST_SEQ")
  private Long customerNo;
  private String customerId;
  private String customerName;
  private String email;
  private String userPassword;
  private String address;
  private String mobile;
  private String identityNumber;

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  String userImageName;

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

  public String getUserImageName() {
    return userImageName;
  }

  public void setUserImageName(String userImageName) {
    this.userImageName = userImageName;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "customerNo=" + customerNo +
        ", customerId='" + customerId + '\'' +
        ", customerName='" + customerName + '\'' +
        ", userPassword='" + userPassword + '\'' +
        ", email='" + email + '\'' +
        ", address='" + address + '\'' +
        ", mobile='" + mobile + '\'' +
        ", identityNumber='" + identityNumber + '\'' +
        ", userImageName='" + userImageName + '\'' +
        '}';
  }
}

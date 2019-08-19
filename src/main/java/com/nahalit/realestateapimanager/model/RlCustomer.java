package com.nahalit.realestateapimanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

//@Table(name = "RlCustomer")
@Entity
public class RlCustomer extends RequiredFeild{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
  @SequenceGenerator(sequenceName = "S_RL_CUSTOMER", allocationSize = 1, name = "CUST_SEQ")
  private Long customerNo;
  private String customerId;

  //
//  @NotNull
//  @Size(max = 65)
//  @Column(name = "first_name")
//@Email
//@Column(unique = true)
  @NotNull
  private String customerName;
  @NotNull
  private String email;
  private String password;
  private String address;
  @NotNull
  private String mobile;
  private String identityNumber;
  private String customerImageName;


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

  @Override
  public String toString() {
    return "RlCustomer{" +
            "customerNo=" + customerNo +
            ", customerId='" + customerId + '\'' +
            ", customerName='" + customerName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", address='" + address + '\'' +
            ", mobile='" + mobile + '\'' +
            ", identityNumber='" + identityNumber + '\'' +
            ", customerImageName='" + customerImageName + '\'' +
            '}';
  }
}

package com.nahalit.realestateapimanager.model;

import javax.persistence.*;

@Entity
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_SEQ")
  @SequenceGenerator(sequenceName = "s_user", allocationSize = 1, name = "User_SEQ")
  Long userNo;
  String userId;
  String name;
  String address;
  String mobile;
  String nid;
  String userImageName;
//  File


  @Override
  public String toString() {
    return "User{" +
        "userNo=" + userNo +
        ", userId='" + userId + '\'' +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", mobile='" + mobile + '\'' +
        ", nid='" + nid + '\'' +
        ", userImageName='" + userImageName + '\'' +
        '}';
  }

  public Long getUserNo() {
    return userNo;
  }

  public void setUserNo(Long userNo) {
    this.userNo = userNo;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getNid() {
    return nid;
  }

  public void setNid(String nid) {
    this.nid = nid;
  }

  public String getUserImageName() {
    return userImageName;
  }

  public void setUserImageName(String userImageName) {
    this.userImageName = userImageName;
  }
}

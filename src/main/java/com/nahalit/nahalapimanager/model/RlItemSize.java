package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlItemSize {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item_size")
  @SequenceGenerator(sequenceName = "s_rl_item_size", allocationSize = 1, name = "rl_item_size")
  private Long sizeNo;
  private Long projectNo;
  private String flatType;
  private double flatSize;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;

  public Long getSizeNo() {
    return sizeNo;
  }

  public void setSizeNo(Long sizeNo) {
    this.sizeNo = sizeNo;
  }

  public Long getProjectNo() {
    return projectNo;
  }

  public void setProjectNo(Long projectNo) {
    this.projectNo = projectNo;
  }

  public String getFlatType() {
    return flatType;
  }

  public void setFlatType(String flatType) {
    this.flatType = flatType;
  }

  public double getFlatSize() {
    return flatSize;
  }

  public void setFlatSize(double flatSize) {
    this.flatSize = flatSize;
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
}

package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlFacing {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item_facing")
  @SequenceGenerator(sequenceName = "s_rl_facing", allocationSize = 1, name = "rl_item_facing")
  private Long facingNo;
  private String facingName;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;

  public Long getFacingNo() {
    return facingNo;
  }

  public void setFacingNo(Long facingNo) {
    this.facingNo = facingNo;
  }

  public String getFacingName() {
    return facingName;
  }

  public void setFacingName(String facingName) {
    this.facingName = facingName;
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

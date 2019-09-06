package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class SaLookup {
  @Id
  private Long lookupNo;
  @NotNull
  private String lookupName;
  private String descr;
  private Long canChange;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;

  public Long getLookupNo() {
    return lookupNo;
  }

  public void setLookupNo(Long lookupNo) {
    this.lookupNo = lookupNo;
  }

  public String getLookupName() {
    return lookupName;
  }

  public void setLookupName(String lookupName) {
    this.lookupName = lookupName;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public Long getCanChange() {
    return canChange;
  }

  public void setCanChange(Long canChange) {
    this.canChange = canChange;
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

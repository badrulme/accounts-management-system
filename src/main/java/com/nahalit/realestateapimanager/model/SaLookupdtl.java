package com.nahalit.realestateapimanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class SaLookupdtl {
  @Id
  private Long lookupdtlNo;
  private Long lookupNo;
  @NotNull
  private String dtlName;
  private String descr;
  private Long activeStat;
  private Long LookupdtlNoParent;
  private String shortName;
  private String nls_name;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;

  public Long getLookupdtlNo() {
    return lookupdtlNo;
  }

  public void setLookupdtlNo(Long lookupdtlNo) {
    this.lookupdtlNo = lookupdtlNo;
  }

  public Long getLookupNo() {
    return lookupNo;
  }

  public void setLookupNo(Long lookupNo) {
    this.lookupNo = lookupNo;
  }

  public String getDtlName() {
    return dtlName;
  }

  public void setDtlName(String dtlName) {
    this.dtlName = dtlName;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public Long getActiveStat() {
    return activeStat;
  }

  public void setActiveStat(Long activeStat) {
    this.activeStat = activeStat;
  }

  public Long getGetLookupdtlNoParent() {
    return LookupdtlNoParent;
  }

  public void setGetLookupdtlNoParent(Long getLookupdtlNoParent) {
    this.LookupdtlNoParent = getLookupdtlNoParent;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getNls_name() {
    return nls_name;
  }

  public void setNls_name(String nls_name) {
    this.nls_name = nls_name;
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

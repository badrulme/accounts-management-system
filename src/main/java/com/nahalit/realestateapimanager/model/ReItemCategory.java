package com.nahalit.realestateapimanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
public class ReItemCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAT_SEQ")
  @SequenceGenerator(sequenceName = "S_RE_ITEM_CATEGORY", allocationSize = 1, name = "CAT_SEQ")
  private Long categoryNo;
  private String categoryId;
  @NotNull
  private String categoryName;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;

  public Long getCategoryNo() {
    return categoryNo;
  }

  public void setCategoryNo(Long categoryNo) {
    this.categoryNo = categoryNo;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
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
    return "ReItemCategory{" +
        "categoryNo=" + categoryNo +
        ", categoryId='" + categoryId + '\'' +
        ", categoryName='" + categoryName + '\'' +
        ", ssCreator=" + ssCreator +
        ", ssCreatedOn=" + ssCreatedOn +
        ", ssModifier=" + ssModifier +
        ", ssModifiedOn=" + ssModifiedOn +
        '}';
  }
}

package com.nahalit.realestateapimanager.model;

import java.util.Date;

public class RlItemSlider {
  private Long sliderNo;
  private String imageName;
  private Long itemNo;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;

  public Long getSliderNo() {
    return sliderNo;
  }

  public void setSliderNo(Long sliderNo) {
    this.sliderNo = sliderNo;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public Long getItemNo() {
    return itemNo;
  }

  public void setItemNo(Long itemNo) {
    this.itemNo = itemNo;
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
    return "RlItemSlider{" +
        "sliderNo=" + sliderNo +
        ", imageName='" + imageName + '\'' +
        ", itemNo=" + itemNo +
        ", ssCreator=" + ssCreator +
        ", ssCreatedOn=" + ssCreatedOn +
        ", ssModifier=" + ssModifier +
        ", ssModifiedOn=" + ssModifiedOn +
        '}';
  }
}

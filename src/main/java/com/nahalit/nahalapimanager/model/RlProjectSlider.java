package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class RlProjectSlider {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_project_slider")
  @SequenceGenerator(sequenceName = "s_rl_project_slider", allocationSize = 1, name = "rl_project_slider")
  private Long sliderNo;
  private String imageName;
  @NotNull
  private Long projectNo;
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

  public Long getProjectNo() {
    return projectNo;
  }

  public void setProjectNo(Long projectNo) {
    this.projectNo = projectNo;
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

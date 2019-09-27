package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlProject {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RL_PROJECT")
  @SequenceGenerator(sequenceName = "S_RL_PROJECT", allocationSize = 1, name = "RL_PROJECT")
  private Long projectNo;
  private String projectId;
  private String projectName;
  private String projectType;
  private String descr;
  private Long approvalNo;
  private String projectLocation;
  private Long plotSize;
  private String blockNameFrom;
  private String blockNameTo;
  private Long landArea;
  private Long noOfStoried;
  private Long noOfLift;
  private Long facingNo;
  private Long noOfFlat;
  private Long carParking;
  private Date handOverTime;
  private Long openSpace;
  private Long roadSizeNo;
  private Integer projectTypeNo;
  private Date ssCreatedOn;
  private Long ssCreator;
  private Date ssModifiedOn;
  private Long ssModifier;

  public Long getProjectNo() {
    return projectNo;
  }

  public void setProjectNo(Long projectNo) {
    this.projectNo = projectNo;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getProjectType() {
    return projectType;
  }

  public void setProjectType(String projectType) {
    this.projectType = projectType;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public Long getApprovalNo() {
    return approvalNo;
  }

  public void setApprovalNo(Long approvalNo) {
    this.approvalNo = approvalNo;
  }

  public String getProjectLocation() {
    return projectLocation;
  }

  public void setProjectLocation(String projectLocation) {
    this.projectLocation = projectLocation;
  }

  public Long getPlotSize() {
    return plotSize;
  }

  public void setPlotSize(Long plotSize) {
    this.plotSize = plotSize;
  }

  public String getBlockNameFrom() {
    return blockNameFrom;
  }

  public void setBlockNameFrom(String blockNameFrom) {
    this.blockNameFrom = blockNameFrom;
  }

  public String getBlockNameTo() {
    return blockNameTo;
  }

  public void setBlockNameTo(String blockNameTo) {
    this.blockNameTo = blockNameTo;
  }

  public Long getLandArea() {
    return landArea;
  }

  public void setLandArea(Long landArea) {
    this.landArea = landArea;
  }

  public Long getNoOfStoried() {
    return noOfStoried;
  }

  public void setNoOfStoried(Long noOfStoried) {
    this.noOfStoried = noOfStoried;
  }

  public Long getNoOfLift() {
    return noOfLift;
  }

  public void setNoOfLift(Long noOfLift) {
    this.noOfLift = noOfLift;
  }

  public Long getFacingNo() {
    return facingNo;
  }

  public void setFacingNo(Long facingNo) {
    this.facingNo = facingNo;
  }

  public Long getNoOfFlat() {
    return noOfFlat;
  }

  public void setNoOfFlat(Long noOfFlat) {
    this.noOfFlat = noOfFlat;
  }

  public Long getCarParking() {
    return carParking;
  }

  public void setCarParking(Long carParking) {
    this.carParking = carParking;
  }

  public Date getHandOverTime() {
    return handOverTime;
  }

  public void setHandOverTime(Date handOverTime) {
    this.handOverTime = handOverTime;
  }

  public Long getOpenSpace() {
    return openSpace;
  }

  public void setOpenSpace(Long openSpace) {
    this.openSpace = openSpace;
  }

  public Long getRoadSizeNo() {
    return roadSizeNo;
  }

  public void setRoadSizeNo(Long roadSizeNo) {
    this.roadSizeNo = roadSizeNo;
  }

  public Integer getProjectTypeNo() {
    return projectTypeNo;
  }

  public void setProjectTypeNo(Integer projectTypeNo) {
    this.projectTypeNo = projectTypeNo;
  }

  public Date getSsCreatedOn() {
    return ssCreatedOn;
  }

  public void setSsCreatedOn(Date ssCreatedOn) {
    this.ssCreatedOn = ssCreatedOn;
  }

  public Long getSsCreator() {
    return ssCreator;
  }

  public void setSsCreator(Long ssCreator) {
    this.ssCreator = ssCreator;
  }

  public Date getSsModifiedOn() {
    return ssModifiedOn;
  }

  public void setSsModifiedOn(Date ssModifiedOn) {
    this.ssModifiedOn = ssModifiedOn;
  }

  public Long getSsModifier() {
    return ssModifier;
  }

  public void setSsModifier(Long ssModifier) {
    this.ssModifier = ssModifier;
  }
}

package com.nahalit.realestateapimanager.model;

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
    private Long projectType;
    private String descr;
    private Long approvalNo;
    private String projectLocation;
    private int plotSize;
    private String blockNameFrom;
    private String blockNameTo;
    private int landArea;
    private int noOfStoried;
    private int noOfLift;
    private String facing;
    private int noOfFlat;
    private int carParking;
    private Date handOverTime;
    private int openSpace;
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

    public Long getProjectType() {
        return projectType;
    }

    public void setProjectType(Long projectType) {
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

    public int getPlotSize() {
        return plotSize;
    }

    public void setPlotSize(int plotSize) {
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

    public int getLandArea() {
        return landArea;
    }

    public void setLandArea(int landArea) {
        this.landArea = landArea;
    }

    public int getNoOfStoried() {
        return noOfStoried;
    }

    public void setNoOfStoried(int noOfStoried) {
        this.noOfStoried = noOfStoried;
    }

    public int getNoOfLift() {
        return noOfLift;
    }

    public void setNoOfLift(int noOfLift) {
        this.noOfLift = noOfLift;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public int getNoOfFlat() {
        return noOfFlat;
    }

    public void setNoOfFlat(int noOfFlat) {
        this.noOfFlat = noOfFlat;
    }

    public int getCarParking() {
        return carParking;
    }

    public void setCarParking(int carParking) {
        this.carParking = carParking;
    }

    public Date getHandOverTime() {
        return handOverTime;
    }

    public void setHandOverTime(Date handOverTime) {
        this.handOverTime = handOverTime;
    }

    public int getOpenSpace() {
        return openSpace;
    }

    public void setOpenSpace(int openSpace) {
        this.openSpace = openSpace;
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

package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item")
    @SequenceGenerator(sequenceName = "s_rl_item", allocationSize = 1, name = "rl_item")
    private Long itemNo;
    private String itemId;
    private Long projectNo;
    private Long plotType;
    private Long roadSize;
    private Long facingNo;
    private String blockName;
    private Long plotSize;
    private double price;
    private double totalPrice;
    private double flatSize;
    private Long flatPlaceofStorid;
    private Long flatNo;
    private Long numberOfLift;
    private String decorationCondition;
    private Long bedRoom;
    private Long livingAndDining;
    private Long kitchen;
    private Long varanda;
    private Long toilets;
    private Long swimmingPool;
    private Long gym;
    private Long parkingFlag;
    private double parkingPrice;
    private Long itemType;
    private String flatType;
    private Date ssCreatedOn;
    private Long ssCreator;
    private Date ssModifiedOn;
    private Long ssModifier;

    // Non Databse Column
    @Transient
    private String projectName;
    @Transient
    private String projectType;
    @Transient
    private String projectLocation;
    @Transient
    private String approvalId;

    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Long projectNo) {
        this.projectNo = projectNo;
    }

    public Long getPlotType() {
        return plotType;
    }

    public void setPlotType(Long plotType) {
        this.plotType = plotType;
    }

    public Long getRoadSize() {
        return roadSize;
    }

    public void setRoadSize(Long roadSize) {
        this.roadSize = roadSize;
    }

    public Long getFacingNo() {
        return facingNo;
    }

    public void setFacingNo(Long facingNo) {
        this.facingNo = facingNo;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Long getPlotSize() {
        return plotSize;
    }

    public void setPlotSize(Long plotSize) {
        this.plotSize = plotSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getFlatSize() {
        return flatSize;
    }

    public void setFlatSize(double flatSize) {
        this.flatSize = flatSize;
    }

    public Long getFlatPlaceofStorid() {
        return flatPlaceofStorid;
    }

    public void setFlatPlaceofStorid(Long flatPlaceofStorid) {
        this.flatPlaceofStorid = flatPlaceofStorid;
    }

    public String getFlatType() {
        return flatType;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }

    public Long getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(Long flatNo) {
        this.flatNo = flatNo;
    }

    public Long getNumberOfLift() {
        return numberOfLift;
    }

    public void setNumberOfLift(Long numberOfLift) {
        this.numberOfLift = numberOfLift;
    }

    public String getDecorationCondition() {
        return decorationCondition;
    }

    public void setDecorationCondition(String decorationCondition) {
        this.decorationCondition = decorationCondition;
    }

    public Long getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(Long bedRoom) {
        this.bedRoom = bedRoom;
    }

    public Long getLivingAndDining() {
        return livingAndDining;
    }

    public void setLivingAndDining(Long livingAndDining) {
        this.livingAndDining = livingAndDining;
    }

    public Long getKitchen() {
        return kitchen;
    }

    public void setKitchen(Long kitchen) {
        this.kitchen = kitchen;
    }

    public Long getVaranda() {
        return varanda;
    }

    public void setVaranda(Long varanda) {
        this.varanda = varanda;
    }

    public Long getToilets() {
        return toilets;
    }

    public void setToilets(Long toilets) {
        this.toilets = toilets;
    }

    public Long getSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(Long swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public Long getGym() {
        return gym;
    }

    public void setGym(Long gym) {
        this.gym = gym;
    }

    public Long getParkingFlag() {
        return parkingFlag;
    }

    public void setParkingFlag(Long parkingFlag) {
        this.parkingFlag = parkingFlag;
    }

    public double getParkingPrice() {
        return parkingPrice;
    }

    public void setParkingPrice(double parkingPrice) {
        this.parkingPrice = parkingPrice;
    }

    public Long getItemType() {
        return itemType;
    }

    public void setItemType(Long itemType) {
        this.itemType = itemType;
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

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }
}

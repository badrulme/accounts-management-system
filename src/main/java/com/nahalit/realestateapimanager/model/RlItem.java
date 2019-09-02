package com.nahalit.realestateapimanager.model;

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
  private Long approvalNo;
  private int roadSize;
  private Long facingNo;
  private String blockName;
  private int plotSize;
  private double price;
  private double totalPrice;
  private double flatSize;
  private int flatPlaceofStorid;
  private int flatNo;
  private int numberOfLift;
  private String decorationCondition;
  private int bedRoom;
  private int livingAndDining;
  private int kitchen;
  private int varanda;
  private int toilets;
  private int swimmingPool;
  private int gym;
  private int parkingFlag;
  private double parkingPrice;
  private Long itemType;
  private Date ssCreatedOn;
  private Long ssCreator;
  private Date ssModifiedOn;
  private Long ssModifier;

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

  public Long getApprovalNo() {
    return approvalNo;
  }

  public void setApprovalNo(Long approvalNo) {
    this.approvalNo = approvalNo;
  }

  public int getRoadSize() {
    return roadSize;
  }

  public void setRoadSize(int roadSize) {
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

  public Long getItemType() {
    return itemType;
  }

  public void setItemType(Long itemType) {
    this.itemType = itemType;
  }

  public void setBlockName(String blockName) {
    this.blockName = blockName;
  }

  public int getPlotSize() {
    return plotSize;
  }

  public void setPlotSize(int plotSize) {
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

  public int getFlatPlaceofStorid() {
    return flatPlaceofStorid;
  }

  public void setFlatPlaceofStorid(int flatPlaceofStorid) {
    this.flatPlaceofStorid = flatPlaceofStorid;
  }

  public int getFlatNo() {
    return flatNo;
  }

  public void setFlatNo(int flatNo) {
    this.flatNo = flatNo;
  }

  public int getNumberOfLift() {
    return numberOfLift;
  }

  public void setNumberOfLift(int numberOfLift) {
    this.numberOfLift = numberOfLift;
  }

  public String getDecorationCondition() {
    return decorationCondition;
  }

  public void setDecorationCondition(String decorationCondition) {
    this.decorationCondition = decorationCondition;
  }

  public int getBedRoom() {
    return bedRoom;
  }

  public void setBedRoom(int bedRoom) {
    this.bedRoom = bedRoom;
  }

  public int getLivingAndDining() {
    return livingAndDining;
  }

  public void setLivingAndDining(int livingAndDining) {
    this.livingAndDining = livingAndDining;
  }

  public int getKitchen() {
    return kitchen;
  }

  public void setKitchen(int kitchen) {
    this.kitchen = kitchen;
  }

  public int getVaranda() {
    return varanda;
  }

  public void setVaranda(int varanda) {
    this.varanda = varanda;
  }

  public int getToilets() {
    return toilets;
  }

  public void setToilets(int toilets) {
    this.toilets = toilets;
  }

  public int getSwimmingPool() {
    return swimmingPool;
  }

  public void setSwimmingPool(int swimmingPool) {
    this.swimmingPool = swimmingPool;
  }

  public int getGym() {
    return gym;
  }

  public void setGym(int gym) {
    this.gym = gym;
  }

  public int getParkingFlag() {
    return parkingFlag;
  }

  public void setParkingFlag(int parkingFlag) {
    this.parkingFlag = parkingFlag;
  }

  public double getParkingPrice() {
    return parkingPrice;
  }

  public void setParkingPrice(double parkingPrice) {
    this.parkingPrice = parkingPrice;
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

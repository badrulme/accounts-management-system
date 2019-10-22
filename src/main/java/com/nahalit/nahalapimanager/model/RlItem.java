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
  private String itemName;
  private String descr;
  private String descrBn;
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
  private Long toilets;
  private Long swimmingPool;
  private Long gym;
  private Long parkingFlag;
  private double parkingPrice;
  private Long itemTypeNo;
  private String flatType;
  private Integer itemInventoryFlag;
  private Integer numberOfBalcony;
  private Integer inactiveFlag;
  private Integer securityFlag;
  private Integer cctvFlag;
  private Integer conferenceHallFlag;
  private Integer heatingFlag;
  private Integer coolingFlag;
  private Integer builtYear;
  private Integer discountAmount;
  private Integer internetFlag;
  private Integer cableTvFlag;
  private String itemBrandPhoto;
  private Double discountPct;
  private Double netPrice;
  private String termsAndCondition;
  private String termsAndConditionBn;
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

  public String getItemName() {
    return itemName;
  }

  public String getDescrBn() {
    return descrBn;
  }

  public void setDescrBn(String descrBn) {
    this.descrBn = descrBn;
  }

  public Double getDiscountPct() {
    return discountPct;
  }

  public void setDiscountPct(Double discountPct) {
    this.discountPct = discountPct;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getDescr() {
    return descr;
  }

  public String getItemBrandPhoto() {
    return itemBrandPhoto;
  }

  public void setItemBrandPhoto(String itemBrandPhoto) {
    this.itemBrandPhoto = itemBrandPhoto;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public Long getProjectNo() {
    return projectNo;
  }

  public String getTermsAndCondition() {
    return termsAndCondition;
  }

  public void setTermsAndCondition(String termsAndCondition) {
    this.termsAndCondition = termsAndCondition;
  }

  public String getTermsAndConditionBn() {
    return termsAndConditionBn;
  }

  public void setTermsAndConditionBn(String termsAndConditionBn) {
    this.termsAndConditionBn = termsAndConditionBn;
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

  public Integer getNumberOfBalcony() {
    return numberOfBalcony;
  }

  public void setNumberOfBalcony(Integer numberOfBalcony) {
    this.numberOfBalcony = numberOfBalcony;
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

  public Double getNetPrice() {
    return netPrice;
  }

  public void setNetPrice(Double netPrice) {
    this.netPrice = netPrice;
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

  public Long getItemTypeNo() {
    return itemTypeNo;
  }

  public void setItemTypeNo(Long itemTypeNo) {
    this.itemTypeNo = itemTypeNo;
  }

  public String getFlatType() {
    return flatType;
  }

  public void setFlatType(String flatType) {
    this.flatType = flatType;
  }

  public Integer getItemInventoryFlag() {
    return itemInventoryFlag;
  }

  public void setItemInventoryFlag(Integer itemInventoryFlag) {
    this.itemInventoryFlag = itemInventoryFlag;
  }

  public Integer getInactiveFlag() {
    return inactiveFlag;
  }

  public void setInactiveFlag(Integer inactiveFlag) {
    this.inactiveFlag = inactiveFlag;
  }

  public Integer getSecurityFlag() {
    return securityFlag;
  }

  public void setSecurityFlag(Integer securityFlag) {
    this.securityFlag = securityFlag;
  }

  public Integer getCctvFlag() {
    return cctvFlag;
  }

  public void setCctvFlag(Integer cctvFlag) {
    this.cctvFlag = cctvFlag;
  }

  public Integer getConferenceHallFlag() {
    return conferenceHallFlag;
  }

  public void setConferenceHallFlag(Integer conferenceHallFlag) {
    this.conferenceHallFlag = conferenceHallFlag;
  }

  public Integer getHeatingFlag() {
    return heatingFlag;
  }

  public void setHeatingFlag(Integer heatingFlag) {
    this.heatingFlag = heatingFlag;
  }

  public Integer getCoolingFlag() {
    return coolingFlag;
  }

  public void setCoolingFlag(Integer coolingFlag) {
    this.coolingFlag = coolingFlag;
  }

  public Integer getBuiltYear() {
    return builtYear;
  }

  public void setBuiltYear(Integer builtYear) {
    this.builtYear = builtYear;
  }

  public Integer getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(Integer discountAmount) {
    this.discountAmount = discountAmount;
  }

  public Integer getInternetFlag() {
    return internetFlag;
  }

  public void setInternetFlag(Integer internetFlag) {
    this.internetFlag = internetFlag;
  }

  public Integer getCableTvFlag() {
    return cableTvFlag;
  }

  public void setCableTvFlag(Integer cableTvFlag) {
    this.cableTvFlag = cableTvFlag;
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

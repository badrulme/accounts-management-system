package com.nahalit.realestateapimanager.model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class RlItem {
  private Long itemNo;
  private String itemId;
  private String title;
  private String descr;
  private List<RlItemSlider> rlItemSlider;


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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public List<RlItemSlider> getRlItemSlider() {
    return rlItemSlider;
  }

  public void setRlItemSlider(List<RlItemSlider> rlItemSlider) {
    this.rlItemSlider = rlItemSlider;
  }

  @Override
  public String toString() {
    return "RlItem{" +
        "itemNo=" + itemNo +
        ", itemId='" + itemId + '\'' +
        ", title='" + title + '\'' +
        ", descr='" + descr + '\'' +
        ", rlItemSlider=" + rlItemSlider +
        '}';
  }
}

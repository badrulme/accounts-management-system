package com.nahalit.realestateapimanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class RlItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item")
    @SequenceGenerator(sequenceName = "s_rl_item", allocationSize = 1, name = "rl_item")
    private Long itemNo;
    private String itemId;
    private String title;
    private String descr;
    private Long ssCreator;
    private Date ssCreatedOn;
    private Long ssModifier;
    private Date ssModifiedOn;

    @OneToMany(mappedBy = "rlItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

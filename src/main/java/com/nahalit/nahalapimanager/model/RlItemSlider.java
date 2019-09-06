package com.nahalit.nahalapimanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class RlItemSlider {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item_slider")
    @SequenceGenerator(sequenceName = "s_rl_item_slider", allocationSize = 1, name = "rl_item_slider")
    private Long sliderNo;
    private String imageName;
    @NotNull
    private Long itemNo;
    //    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "item_no")
//    @JsonBackReference
//    private RlItem rlItem;
    private Long ssCreator;
    private Date ssCreatedOn;
    private Long ssModifier;
    private Date ssModifiedOn;

    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
    }

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

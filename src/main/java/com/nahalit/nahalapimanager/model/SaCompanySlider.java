package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SaCompanySlider {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_SLIDER")
    @SequenceGenerator(sequenceName = "S_SA_COMPANY_SLIDER", allocationSize = 1, name = "COMPANY_SLIDER")
    private Long sliderNo;
    private String sliderName;
    private Long companyNo;
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

    public String getSliderName() {
        return sliderName;
    }

    public void setSliderName(String sliderName) {
        this.sliderName = sliderName;
    }

    public Long getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(Long companyNo) {
        this.companyNo = companyNo;
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


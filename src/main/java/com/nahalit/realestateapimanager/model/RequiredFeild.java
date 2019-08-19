package com.nahalit.realestateapimanager.model;

import java.util.Date;

public class RequiredFeild {
    private Long ssCreator;
    private Date ssCreatedOn;
    private Long ssModifier;
    private Date ssModifiedOn;

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

    @Override
    public String toString() {
        return "RequiredFeild{" +
                "ssCreator=" + ssCreator +
                ", ssCreatedOn=" + ssCreatedOn +
                ", ssModifier=" + ssModifier +
                ", ssModifiedOn=" + ssModifiedOn +
                '}';
    }
}

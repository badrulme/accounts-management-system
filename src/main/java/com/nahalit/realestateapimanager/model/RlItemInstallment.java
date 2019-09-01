package com.nahalit.realestateapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlItemInstallment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item_installment")
    @SequenceGenerator(sequenceName = "S_RL_ITEM_INSTALLMENT", allocationSize = 1, name = "rl_item_installment")
    private Long installmentNo;
    private int installmentAmount;
    private Long itemNo;
    private Long ssCreator;
    private Date ssCreatedOn;
    private Long ssModifier;
    private Date ssModifiedOn;

    public RlItemInstallment() {
    }

    public Long getInstallmentNo() {
        return installmentNo;
    }

    public void setInstallmentNo(Long installmentNo) {
        this.installmentNo = installmentNo;
    }

    public int getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(int installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
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

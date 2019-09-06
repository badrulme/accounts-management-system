package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class RlRajukApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RL_RAJUK")
    @SequenceGenerator(sequenceName = "S_RL_RAJUK_APPROVAL", allocationSize = 1, name = "RL_RAJUK")
    private Long approvalNo;
    @NotNull
    private String approvalId;
    private String descr;
    private Long ssCreator;
    private Date ssCreatedOn;
    private Long ssModifier;
    private Date ssModifiedOn;

    public Long getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(Long approvalNo) {
        this.approvalNo = approvalNo;
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
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

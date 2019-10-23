package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlTrnNominee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RL_TRN_NOMINEE")
    @SequenceGenerator(sequenceName = "S_RL_TRN_NOMINEE", allocationSize = 1, name = "RL_TRN_NOMINEE")
    private Long nomineeNo;
    private Long trnNo;
    private String nomineeName;
    private String nomineeEmail;
    private String nomineeFatherName;
    private String nomineeMotherName;
    private String relationWithApplicants;
    private String nomineeMobile;
    private String nomineePresentAddress;
    private String nomineePermanentAddress;
    private String nomineePictureName;
    private Date ssCreatedOn;
    private Long ssCreator;
    private Date ssModifiedOn;
    private Long ssModifier;

    public Long getNomineeNo() {
        return nomineeNo;
    }

    public void setNomineeNo(Long nomineeNo) {
        this.nomineeNo = nomineeNo;
    }

    public Long getTrnNo() {
        return trnNo;
    }

    public void setTrnNo(Long trnNo) {
        this.trnNo = trnNo;
    }

    public String getNomineeName() {
        return nomineeName;
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

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeEmail() {
        return nomineeEmail;
    }

    public void setNomineeEmail(String nomineeEmail) {
        this.nomineeEmail = nomineeEmail;
    }

    public String getNomineeFatherName() {
        return nomineeFatherName;
    }

    public void setNomineeFatherName(String nomineeFatherName) {
        this.nomineeFatherName = nomineeFatherName;
    }

    public String getNomineeMotherName() {
        return nomineeMotherName;
    }

    public void setNomineeMotherName(String nomineeMotherName) {
        this.nomineeMotherName = nomineeMotherName;
    }

    public String getRelationWithApplicants() {
        return relationWithApplicants;
    }

    public void setRelationWithApplicants(String relationWithApplicants) {
        this.relationWithApplicants = relationWithApplicants;
    }

    public String getNomineeMobile() {
        return nomineeMobile;
    }

    public void setNomineeMobile(String nomineeMobile) {
        this.nomineeMobile = nomineeMobile;
    }

    public String getNomineePresentAddress() {
        return nomineePresentAddress;
    }

    public void setNomineePresentAddress(String nomineePresentAddress) {
        this.nomineePresentAddress = nomineePresentAddress;
    }

    public String getNomineePermanentAddress() {
        return nomineePermanentAddress;
    }

    public void setNomineePermanentAddress(String nomineePermanentAddress) {
        this.nomineePermanentAddress = nomineePermanentAddress;
    }

    public String getNomineePictureName() {
        return nomineePictureName;
    }

    public void setNomineePictureName(String nomineePictureName) {
        this.nomineePictureName = nomineePictureName;
    }
}

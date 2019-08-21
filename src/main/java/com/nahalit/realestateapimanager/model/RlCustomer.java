package com.nahalit.realestateapimanager.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

//@Table(name = "RlCustomer")
@Entity
public class RlCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "S_RL_CUSTOMER", allocationSize = 1, name = "CUST_SEQ")
    private Long customerNo;
    @Column(unique = true)
    private String customerId;
    //  @Size(max = 65)
//  @Column(name = "first_name")
//@Email
    @NotNull
    private String customerName;
    private String fatherName;
    private String motherName;
    private String spouseName;
    private String permanetAddress;
    private String presentAddress;
    private Date dob;
    private String religion;
    private String nid;
    private String nationality;
    private String telephone;
    private String mobile;
    @Email
    private String email;
    private String contactPerson;
    private String profession;
    private String designation;
    private String officeAddress;
    private String customerPictureName;
    private String nomineeName;
    private String nomineeFatherName;
    private String nomineeMotherName;
    private String relationWithApplicants;
    private String nomineePresentAddress;
    private String nomineePermanentAddress;
    private String nomineeMobile;
    @Email
    private String nomineeEmail;
    private String nomineePictureName;
    private String password;
    private Long ssCreator;
    private Date ssCreatedOn;
    private Long ssModifier;
    private Date ssModifiedOn;

    public Long getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(Long customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getPermanetAddress() {
        return permanetAddress;
    }

    public void setPermanetAddress(String permanetAddress) {
        this.permanetAddress = permanetAddress;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }


    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getCustomerPictureName() {
        return customerPictureName;
    }

    public void setCustomerPictureName(String customerPictureName) {
        this.customerPictureName = customerPictureName;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
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

    public String getNomineeMobile() {
        return nomineeMobile;
    }

    public void setNomineeMobile(String nomineeMobile) {
        this.nomineeMobile = nomineeMobile;
    }

    public String getNomineeEmail() {
        return nomineeEmail;
    }

    public void setNomineeEmail(String nomineeEmail) {
        this.nomineeEmail = nomineeEmail;
    }

    public String getNomineePictureName() {
        return nomineePictureName;
    }

    public void setNomineePictureName(String nomineePictureName) {
        this.nomineePictureName = nomineePictureName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

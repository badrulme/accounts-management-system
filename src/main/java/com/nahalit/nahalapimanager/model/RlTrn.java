package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlTrn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RL_TRN")
    @SequenceGenerator(sequenceName = "S_RL_TRN", allocationSize = 1, name = "RL_TRN")
    private Long trnNo;
    private String trnId;
    private Date trnDate;
    private Long itemNo;
    private Long customerNo;
    private Double totalPrice;
    private Double discountPct;
    private Double discountAmount;
    private Double settlementPrice;
    private String bookingRefPerson;
    private String refContactNo;
    private String paymentType;
    private String bookingAmount;
    private String paymentMode;
    private String chequeNo;
    private String ddNo;
    private String ttNo;
    private Date chequeDate;
    private String bankName;
    private String branchName;
    private String bankAccNo;
    private String transactionId;
    private String payorderNo;
    private String payMode;
    private String paidAmount;
    private Integer webUserFlag;
    private Integer approveFlag;
    private Date approveDate;
    private Long approveBy;
    private Long ssCreator;
    private Date ssCreatedOn;
    private Long ssModifier;
    private Date ssModifiedOn;

    public Long getTrnNo() {
        return trnNo;
    }

    public void setTrnNo(Long trnNo) {
        this.trnNo = trnNo;
    }

    public String getTrnId() {
        return trnId;
    }

    public void setTrnId(String trnId) {
        this.trnId = trnId;
    }

    public Date getTrnDate() {
        return trnDate;
    }

  public String getRefContactNo() {
    return refContactNo;
  }

    public Integer getApproveFlag() {
        return approveFlag;
    }

    public void setApproveFlag(Integer approveFlag) {
        this.approveFlag = approveFlag;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Long getApproveBy() {
        return approveBy;
    }

    public void setApproveBy(Long approveBy) {
        this.approveBy = approveBy;
    }

    public void setRefContactNo(String refContactNo) {
    this.refContactNo = refContactNo;
  }

  public String getDdNo() {
    return ddNo;
  }

  public void setDdNo(String ddNo) {
    this.ddNo = ddNo;
  }

  public String getTtNo() {
    return ttNo;
  }

  public void setTtNo(String ttNo) {
    this.ttNo = ttNo;
  }

  public void setTrnDate(Date trnDate) {
        this.trnDate = trnDate;
    }

    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
    }

    public Long getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(Long customerNo) {
        this.customerNo = customerNo;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDiscountPct() {
        return discountPct;
    }

    public void setDiscountPct(Double discountPct) {
        this.discountPct = discountPct;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(Double settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public String getBookingRefPerson() {
        return bookingRefPerson;
    }

    public void setBookingRefPerson(String bookingRefPerson) {
        this.bookingRefPerson = bookingRefPerson;
    }

    public String getContractNo() {
        return refContactNo;
    }

    public void setContractNo(String contractNo) {
        this.refContactNo = contractNo;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(String bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPayorderNo() {
        return payorderNo;
    }

    public void setPayorderNo(String payorderNo) {
        this.payorderNo = payorderNo;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Integer getWebUserFlag() {
        return webUserFlag;
    }

    public void setWebUserFlag(Integer webUserFlag) {
        this.webUserFlag = webUserFlag;
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

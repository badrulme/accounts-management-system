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
  private Double totalAmount;
  private Double discountAmount;
  private Double netAmount;
  private Long customerNo;
  private String paymentMethod;
  private String chequeNo;
  private Date chequeDate;
  private String bankName;
  private String branchName;
  private String transactionId;
  private String payorderNo;

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

  public void setTrnDate(Date trnDate) {
    this.trnDate = trnDate;
  }

  public Long getItemNo() {
    return itemNo;
  }

  public void setItemNo(Long itemNo) {
    this.itemNo = itemNo;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Double getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(Double discountAmount) {
    this.discountAmount = discountAmount;
  }

  public Double getNetAmount() {
    return netAmount;
  }

  public void setNetAmount(Double netAmount) {
    this.netAmount = netAmount;
  }

  public Long getCustomerNo() {
    return customerNo;
  }

  public void setCustomerNo(Long customerNo) {
    this.customerNo = customerNo;
  }

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
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
}

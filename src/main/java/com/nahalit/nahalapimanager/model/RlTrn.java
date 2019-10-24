package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
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

}

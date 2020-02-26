package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class SaUser extends Audit{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SA_USER")
  @SequenceGenerator(sequenceName = "S_SA_USER", allocationSize = 1, name = "SA_USER")
  private Long userNo;
  private String userId;
  private String userName;
  private String userPwd;
  private String securityQues1;
  private String securityAns1;
  private String securityQues2;
  private String securityAns2;
  private Date activeFrom;
  private Date activeTo;
  private String description;
  private Integer authType;
  private Long intEmpNo;
  private Long extEmpNo;
  private Integer activeStat;
  private Long ssCreator;
  
  private Long ssModifier;
  
  private Integer nlsFlag;
  private Long companyNo;

}

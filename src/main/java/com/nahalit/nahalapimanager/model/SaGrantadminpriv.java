package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class SaGrantadminpriv extends Audit{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SA_GRANTADMINPRIV")
  @SequenceGenerator(sequenceName = "S_SA_GRANTADMINPRIV", allocationSize = 1, name = "SA_GRANTADMINPRIV")
  private Long grPrivNo;
  private String grPrivId;
  private Long privNo;
  private Long userNo;
  private Long companyNo;
  private Date grantDt;
  private Long ssCreator;
  
  private Long ssModifier;
  
  private Long empNo;
}

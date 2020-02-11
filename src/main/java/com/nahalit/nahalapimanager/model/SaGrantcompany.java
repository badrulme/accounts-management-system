package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class SaGrantcompany {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SA_GRANTCOMPANY")
  @SequenceGenerator(sequenceName = "S_SA_GRANTCOMPANY", allocationSize = 1, name = "SA_GRANTCOMPANY")
  private Long grCompanyNo;
  private Long companyNo;
  private Long userNo;
  private Integer canGrant;
  private Integer grantor;
  private Date grantDate;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;

}

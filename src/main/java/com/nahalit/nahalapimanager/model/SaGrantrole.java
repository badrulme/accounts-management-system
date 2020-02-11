package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class SaGrantrole {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SA_GRANTROLE")
  @SequenceGenerator(sequenceName = "S_SA_GRANTROLE", allocationSize = 1, name = "SA_GRANTROLE")
  private Long grRoleNo;
  private String grRoleId;
  private Long roleNo;
  private Long userNo;
  private Long companyNo;
  private Integer canGrant;
  private Integer grantor;
  private Date grantDt;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;
  private Long empNo;

}

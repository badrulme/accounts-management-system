package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class SaRoledtl {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SA_ROLEDTL")
  @SequenceGenerator(sequenceName = "S_SA_ROLEDTL", allocationSize = 1, name = "SA_ROLEDTL")
  private Long roledtlNo;
  private Long roleNo;
  private Long submenuNo;
  private Integer canView;
  private Integer canModify;
  private Integer canRemove;
  private Integer canCreate;
  private Long companyNo;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;
}

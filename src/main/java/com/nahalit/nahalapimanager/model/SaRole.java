package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Setter
@Getter
public class SaRole extends Audit{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SA_ROLE")
  @SequenceGenerator(sequenceName = "S_SA_ROLE", allocationSize = 1, name = "SA_ROLE")
  private Long roleNo;
  private String roleId;
  private String roleName;
  private String descr;
  private Integer activeStat;
  private Long companyNo;
  private Long ssCreator;
  
  private Long ssModifier;
  
}

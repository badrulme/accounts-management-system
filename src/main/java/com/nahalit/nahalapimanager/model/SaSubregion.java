package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class SaSubregion extends Audit{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SA_SUBREGION")
  @SequenceGenerator(sequenceName = "S_SA_SUBREGION", allocationSize = 1, name = "SA_SUBREGION")
  private Long subregionNo;
  private Long regionNo;
  private String subregionName;
  private Long activeFlag;
  private Long ssCreator;
  
  private Long ssModifier;
  
}

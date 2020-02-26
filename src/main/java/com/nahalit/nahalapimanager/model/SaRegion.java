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
public class SaRegion extends Audit{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SA_REGION")
  @SequenceGenerator(sequenceName = "S_SA_REGION", allocationSize = 1, name = "SA_REGION")
  private Long regionNo;
  private String regionName;
  private Long activeFlag;
  private Long ssCreator;
  
  private Long ssModifier;
  
}

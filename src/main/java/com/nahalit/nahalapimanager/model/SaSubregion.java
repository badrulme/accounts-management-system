package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Setter
@Getter
@Entity
public class SaSubregion {
  private Long subregionNo;
  private Long regionNo;
  private String subregionName;
  private Long activeFlag;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;
}

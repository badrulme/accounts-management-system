package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class HrJobtitle {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HR_JOBTITLE")
  @SequenceGenerator(sequenceName = "S_HR_JOBTITLE", allocationSize = 1, name = "HR_JOBTITLE")
  private Long jobtitleNo;
  private String jobtitleId;
  private String jobtitle;
  private Integer activeStat;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;

}

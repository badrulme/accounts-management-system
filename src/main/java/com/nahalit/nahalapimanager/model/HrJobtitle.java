package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class HrJobtitle extends Audit{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HR_JOBTITLE")
  @SequenceGenerator(sequenceName = "S_HR_JOBTITLE", allocationSize = 1, name = "HR_JOBTITLE")
  private Long jobtitleNo;
  private String jobtitleId;
  private String jobtitle;
  private Integer activeStat;
  private Long ssCreator;
  
  private Long ssModifier;
  

}

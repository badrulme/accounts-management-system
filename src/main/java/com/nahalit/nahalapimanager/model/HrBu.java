package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class HrBu {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HR_BU")
  @SequenceGenerator(sequenceName = "S_HR_BU", allocationSize = 1, name = "HR_BU")
  private Long buNo;
  private Long buNoParent;
  private String buName;
  private String descr;
  private String buAlias;
  private String loc;
  private Long buTypeNo;
  private Long ssCreator;
  private Date ssCreatedOn;
  private Long ssModifier;
  private Date ssModifiedOn;
  private Long ssOgNo;
  private Integer activeStat;
  private Long lookupdtlNo;
  private Date buOpeningDate;
  private String buAddress;
  private String buPhone;
  private String buCategory;
  private Integer contractBy;
  private Integer operationBy;
  private String buLocationType;
  private String buGrade;
  private Integer reportSlNo;
  private String buCategoryFlag;
  private Long baNo;
  private String buNoTree;
  private String buNameTree;
  private Integer isLeaf;
  private String buNameLevel;
  private Long companyNo;
  private String ssUploadedOn;
  private Long ssIsDeleted;
  private Long ssIsUploaded;
  private String buCode;
  private Long rootBuNo;
  private Long refCompanyNo;
  private Integer treeLevel;
  private String buAddress2;
  private String fax;
  private String eMail;
  private String web;
  private Long cashAccNo;
  private Long chequeAccNo;
  private Long lcAccNo;
  private String nlsBuName;
  private String creditFlag;
  private Long buActivityTypeNo;
  private Integer defaltFlag;
  private Long productionActivityNo;
  private Integer displayAttnInHoliday;
  private Integer showLineInSalary;
  private Integer excludeAbsentInactive;
}

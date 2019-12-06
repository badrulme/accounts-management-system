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
public class RlProject {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RL_PROJECT")
  @SequenceGenerator(sequenceName = "S_RL_PROJECT", allocationSize = 1, name = "RL_PROJECT")
  private Long projectNo;
  private String projectId;
  private String projectName;
  private String projectType;
  private String descr;
  private Long approvalNo;
  private String projectLocation;
  private Double plotSize;
  private String blockNameFrom;
  private String blockNameTo;
  private Long landArea;
  private Long noOfStoried;
  private Long noOfLift;
  private Long facingNo;
  private Long noOfFlat;
  private Long carParking;
  private Date handOverTime;
  private Long openSpace;
  private String roadSize;
  private Integer projectTypeNo;
  private Integer numberOfPlot;
  private String projectLayoutPhoto;
  private String projectStatus;
  private String projectRegion;
  private String approvalInformation;
  private Integer generalPlotNo;
  private Integer commercialPlotNo;
  private Integer duplexPlotNo;
  private Integer publishFlag;
  private Integer uomNo;
  private Integer regionNo;
  private Integer subregionNo;
  private Date ssCreatedOn;
  private Long ssCreator;
  private Date ssModifiedOn;
  private Long ssModifier;
}

package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class AcCostcenter extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AC_COSTCENTER")
    @SequenceGenerator(sequenceName = "S_AC_COSTCENTER", allocationSize = 1, name = "AC_COSTCENTER")
    private Long costNo;
    private Long costNoParent;
    private String costName;
    private String descr;
    private Integer inactiveStat;
    private Integer recurringFlag;
    private Long accNo;
    private Long companyNo;
    
    private Long ssCreator;
    
    private Long ssModifier;
}

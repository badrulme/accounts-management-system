package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class AcPeriod extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AC_PERIOD")
    @SequenceGenerator(sequenceName = "S_AC_PERIOD", allocationSize = 1, name = "AC_PERIOD")
    private Long periodNo;
    private Date startPeriodDate;
    private Date endPeriodDate;
    private Integer closeFlag;
    private Long companyNo;
    
    private Long ssCreator;
    
    private Long ssModifier;
}

package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class AcBa extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AC_BA")
    @SequenceGenerator(sequenceName = "S_AC_BA", allocationSize = 1, name = "AC_BA")
    private Long baNo;
    private Long baNoParent;
    @NotBlank(message = "baName can not be null!")
    private String baName;
    private String descr;
    private Integer inactiveStat;
    private Integer masterBaFlag;
    private Long companyNo;
    private Long ssCreator;
    private Long ssModifier;
}

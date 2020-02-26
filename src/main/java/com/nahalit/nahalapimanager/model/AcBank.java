package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class AcBank extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AC_BANK")
    @SequenceGenerator(sequenceName = "S_AC_BANK", allocationSize = 1, name = "AC_BANK")
    private Long bankNo;
    private String alias;
    private String branchName;
    private Long subbankOf;
    private String address;
    private String swiftCode;
    private String phone1;
    private String phone2;
    private String phone3;
    private String mobile;
    private String fax;
    private String email;
    private String web;
    private String note;
    private Integer bankFlag;
    private Integer activeStat;
    private Long companyNo;
    
    private Long ssCreator;
    
    private Long ssModifier;
}

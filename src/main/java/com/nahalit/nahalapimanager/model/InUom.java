package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class InUom extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IN_UOM")
    @SequenceGenerator(sequenceName = "S_IN_UOM", allocationSize = 1, name = "IN_UOM")
    private Long uomNo;
    private String uom;
    private String uomShort;
    private Long companyNo;
    
    private Long ssCreator;
    
    private Long ssModifier;
}

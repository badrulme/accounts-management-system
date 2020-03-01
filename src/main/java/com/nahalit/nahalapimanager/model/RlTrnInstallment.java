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
public class RlTrnInstallment extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RL_TRN_INSTALLMENT")
    @SequenceGenerator(sequenceName = "S_RL_TRN_INSTALLMENT", allocationSize = 1, name = "RL_TRN_INSTALLMENT")
    private Long installmentNo;
    private Double installmentAmount;
    private Long trnNo;
    private Long installmentSl;
    private Date installmentDate;
    private Long payFlag;
    private Long ssCreator;
    
    private Long ssModifier;
    
}

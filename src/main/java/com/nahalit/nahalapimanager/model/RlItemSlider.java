package com.nahalit.nahalapimanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class RlItemSlider extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item_slider")
    @SequenceGenerator(sequenceName = "s_rl_item_slider", allocationSize = 1, name = "rl_item_slider")
    private Long sliderNo;
    private String imageName;
    @NotNull
    private Long itemNo;
    //    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "item_no")
//    @JsonBackReference
//    private RlItem rlItem;
    private Long ssCreator;
    
    private Long ssModifier;
    

}

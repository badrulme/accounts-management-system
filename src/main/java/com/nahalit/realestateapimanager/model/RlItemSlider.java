package com.nahalit.realestateapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlItemSlider extends RequiredFeild {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item_slider")
    @SequenceGenerator(sequenceName = "s_rl_item_slider", allocationSize = 1, name = "rl_item_slider")
    private Long sliderNo;
    private String imageName;

    //    private Long itemNo;, referencedColumnName = "itemNo"
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_no", nullable = false)
    private RlItem rlItem;

    public Long getSliderNo() {
        return sliderNo;
    }

    public void setSliderNo(Long sliderNo) {
        this.sliderNo = sliderNo;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


}

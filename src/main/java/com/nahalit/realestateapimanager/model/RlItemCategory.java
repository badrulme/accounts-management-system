package com.nahalit.realestateapimanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class RlItemCategory extends RequiredFeild {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAT_SEQ")
    @SequenceGenerator(sequenceName = "S_RL_ITEM_CATEGORY", allocationSize = 1, name = "CAT_SEQ")
    private Long categoryNo;
    private String categoryId;
    @NotNull
    private String categoryName;

    public Long getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(Long categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    @Override
    public String toString() {
        return "RlItemCategory{" +
                "categoryNo=" + categoryNo +
                ", categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}

package com.nahalit.realestateapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlItemVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item_video")
    @SequenceGenerator(sequenceName = "S_RL_ITEM_VIDEO", allocationSize = 1, name = "rl_item_video")
    private Long videoNo;
    private String videoTitle;
    private String videoMetaTag;
    private Long itemNo;
    private Long ssCreator;
    private Date ssCreatedOn;
    private Long ssModifier;
    private Date ssModifiedOn;

    public Long getVideoNo() {
        return videoNo;
    }

    public void setVideoNo(Long videoNo) {
        this.videoNo = videoNo;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoMetaTag() {
        return videoMetaTag;
    }

    public void setVideoMetaTag(String videoMetaTag) {
        this.videoMetaTag = videoMetaTag;
    }

    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
    }

    public Long getSsCreator() {
        return ssCreator;
    }

    public void setSsCreator(Long ssCreator) {
        this.ssCreator = ssCreator;
    }

    public Date getSsCreatedOn() {
        return ssCreatedOn;
    }

    public void setSsCreatedOn(Date ssCreatedOn) {
        this.ssCreatedOn = ssCreatedOn;
    }

    public Long getSsModifier() {
        return ssModifier;
    }

    public void setSsModifier(Long ssModifier) {
        this.ssModifier = ssModifier;
    }

    public Date getSsModifiedOn() {
        return ssModifiedOn;
    }

    public void setSsModifiedOn(Date ssModifiedOn) {
        this.ssModifiedOn = ssModifiedOn;
    }
}

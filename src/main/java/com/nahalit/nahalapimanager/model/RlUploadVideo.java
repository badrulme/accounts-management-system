package com.nahalit.nahalapimanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RlUploadVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_upload_video")
    @SequenceGenerator(sequenceName = "S_RL_UPLOAD_VIDEO", allocationSize = 1, name = "rl_upload_video")
    private Long videoNo;
    private String videoTitle;
    private String youtubeVideoLink;
    private Long itemNo;
    private Long projectNo;
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

  public String getYoutubeVideoLink() {
    return youtubeVideoLink;
  }

  public void setYoutubeVideoLink(String youtubeVideoLink) {
    this.youtubeVideoLink = youtubeVideoLink;
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

    public Long getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Long projectNo) {
        this.projectNo = projectNo;
    }
}

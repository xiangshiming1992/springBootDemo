package com.xsm.demo.entity;

import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class HomageBanner {
    /**
     * ID
     *
     * @mbggenerated
     */
    private Long bannerId;

    /**
     * 标题说明
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 图片地址
     *
     * @mbggenerated
     */
    private String bannerUrl;

    /**
     * 1 正常  0下价的
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 是否跳转外部地址
     *
     * @mbggenerated
     */
    private String isJump;

    /**
     * 点击跳转链接地址
     *
     * @mbggenerated
     */
    private String link;

    /**
     * 位置 home_top：页面上部 ，home_mid：页面中部 
     *
     * @mbggenerated
     */
    private String loc;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date rowAddTime;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date rowUpdateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_banner.banner_id
     *
     * @return the value of homage_banner.banner_id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    public Long getBannerId() {
        return bannerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_banner.banner_id
     *
     * @param bannerId the value for homage_banner.banner_id
     *
     * @mbggenerated
     */
    public void setBannerId(Long bannerId) {
        this.bannerId = bannerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_banner.title
     *
     * @return the value of homage_banner.title
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题说明")
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_banner.title
     *
     * @param title the value for homage_banner.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_banner.banner_url
     *
     * @return the value of homage_banner.banner_url
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图片地址")
    public String getBannerUrl() {
        return bannerUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_banner.banner_url
     *
     * @param bannerUrl the value for homage_banner.banner_url
     *
     * @mbggenerated
     */
    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl == null ? null : bannerUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_banner.status
     *
     * @return the value of homage_banner.status
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "1 正常  0下价的")
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_banner.status
     *
     * @param status the value for homage_banner.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_banner.is_jump
     *
     * @return the value of homage_banner.is_jump
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否跳转外部地址")
    public String getIsJump() {
        return isJump;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_banner.is_jump
     *
     * @param isJump the value for homage_banner.is_jump
     *
     * @mbggenerated
     */
    public void setIsJump(String isJump) {
        this.isJump = isJump == null ? null : isJump.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_banner.link
     *
     * @return the value of homage_banner.link
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "点击跳转链接地址")
    public String getLink() {
        return link;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_banner.link
     *
     * @param link the value for homage_banner.link
     *
     * @mbggenerated
     */
    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_banner.loc
     *
     * @return the value of homage_banner.loc
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "位置 home_top：页面上部 ，home_mid：页面中部 ")
    public String getLoc() {
        return loc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_banner.loc
     *
     * @param loc the value for homage_banner.loc
     *
     * @mbggenerated
     */
    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_banner.row_add_time
     *
     * @return the value of homage_banner.row_add_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    public Date getRowAddTime() {
        return rowAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_banner.row_add_time
     *
     * @param rowAddTime the value for homage_banner.row_add_time
     *
     * @mbggenerated
     */
    public void setRowAddTime(Date rowAddTime) {
        this.rowAddTime = rowAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_banner.row_update_time
     *
     * @return the value of homage_banner.row_update_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间")
    public Date getRowUpdateTime() {
        return rowUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_banner.row_update_time
     *
     * @param rowUpdateTime the value for homage_banner.row_update_time
     *
     * @mbggenerated
     */
    public void setRowUpdateTime(Date rowUpdateTime) {
        this.rowUpdateTime = rowUpdateTime;
    }
}
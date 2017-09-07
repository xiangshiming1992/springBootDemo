package com.xsm.demo.entity;

import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class HomageIndustryDynamic {
    /**
     * ID
     *
     * @mbggenerated
     */
    private Long industryDynamicId;

    /**
     * 标题
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 内容介绍，简写
     *
     * @mbggenerated
     */
    private String contenJx;

    /**
     * 内容
     *
     * @mbggenerated
     */
    private String content;

    /**
     * 图片地址
     *
     * @mbggenerated
     */
    private String picUrl;

    /**
     * 来源地址
     *
     * @mbggenerated
     */
    private String dataUrl;

    /**
     * 新闻来源和时间
     *
     * @mbggenerated
     */
    private String sourceTime;

    /**
     * 发布时间
     *
     * @mbggenerated
     */
    private Date sendTime;

    /**
     * NEWS 新闻  FS 风俗文化
     *
     * @mbggenerated
     */
    private String type;

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
     * This method returns the value of the database column homage_industry_dynamic.industry_dynamic_id
     *
     * @return the value of homage_industry_dynamic.industry_dynamic_id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    public Long getIndustryDynamicId() {
        return industryDynamicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.industry_dynamic_id
     *
     * @param industryDynamicId the value for homage_industry_dynamic.industry_dynamic_id
     *
     * @mbggenerated
     */
    public void setIndustryDynamicId(Long industryDynamicId) {
        this.industryDynamicId = industryDynamicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_industry_dynamic.title
     *
     * @return the value of homage_industry_dynamic.title
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.title
     *
     * @param title the value for homage_industry_dynamic.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_industry_dynamic.conten_jx
     *
     * @return the value of homage_industry_dynamic.conten_jx
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内容介绍，简写")
    public String getContenJx() {
        return contenJx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.conten_jx
     *
     * @param contenJx the value for homage_industry_dynamic.conten_jx
     *
     * @mbggenerated
     */
    public void setContenJx(String contenJx) {
        this.contenJx = contenJx == null ? null : contenJx.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_industry_dynamic.content
     *
     * @return the value of homage_industry_dynamic.content
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内容")
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.content
     *
     * @param content the value for homage_industry_dynamic.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_industry_dynamic.pic_url
     *
     * @return the value of homage_industry_dynamic.pic_url
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图片地址")
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.pic_url
     *
     * @param picUrl the value for homage_industry_dynamic.pic_url
     *
     * @mbggenerated
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_industry_dynamic.data_url
     *
     * @return the value of homage_industry_dynamic.data_url
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "来源地址")
    public String getDataUrl() {
        return dataUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.data_url
     *
     * @param dataUrl the value for homage_industry_dynamic.data_url
     *
     * @mbggenerated
     */
    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl == null ? null : dataUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_industry_dynamic.source_time
     *
     * @return the value of homage_industry_dynamic.source_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "新闻来源和时间")
    public String getSourceTime() {
        return sourceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.source_time
     *
     * @param sourceTime the value for homage_industry_dynamic.source_time
     *
     * @mbggenerated
     */
    public void setSourceTime(String sourceTime) {
        this.sourceTime = sourceTime == null ? null : sourceTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_industry_dynamic.send_time
     *
     * @return the value of homage_industry_dynamic.send_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布时间")
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.send_time
     *
     * @param sendTime the value for homage_industry_dynamic.send_time
     *
     * @mbggenerated
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_industry_dynamic.type
     *
     * @return the value of homage_industry_dynamic.type
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "NEWS 新闻  FS 风俗文化")
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.type
     *
     * @param type the value for homage_industry_dynamic.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_industry_dynamic.row_add_time
     *
     * @return the value of homage_industry_dynamic.row_add_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    public Date getRowAddTime() {
        return rowAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.row_add_time
     *
     * @param rowAddTime the value for homage_industry_dynamic.row_add_time
     *
     * @mbggenerated
     */
    public void setRowAddTime(Date rowAddTime) {
        this.rowAddTime = rowAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column homage_industry_dynamic.row_update_time
     *
     * @return the value of homage_industry_dynamic.row_update_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间")
    public Date getRowUpdateTime() {
        return rowUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column homage_industry_dynamic.row_update_time
     *
     * @param rowUpdateTime the value for homage_industry_dynamic.row_update_time
     *
     * @mbggenerated
     */
    public void setRowUpdateTime(Date rowUpdateTime) {
        this.rowUpdateTime = rowUpdateTime;
    }
}
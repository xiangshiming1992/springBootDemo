package com.xsm.demo.entity;

import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;

public class TestUserInfo {
    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    private String username;

    /**
     * 登录密码
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 加盐密码
     *
     * @mbggenerated
     */
    private String salt;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 账号状态 "NORMAL","正常“，"DISABLE", "停用"
     *
     * @mbggenerated
     */
    private String operatorStatus;

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
     * This method returns the value of the database column test_UserInfo.uid
     *
     * @return the value of test_UserInfo.uid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户ID")
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_UserInfo.uid
     *
     * @param uid the value for test_UserInfo.uid
     *
     * @mbggenerated
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_UserInfo.username
     *
     * @return the value of test_UserInfo.username
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录账号")
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_UserInfo.username
     *
     * @param username the value for test_UserInfo.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_UserInfo.password
     *
     * @return the value of test_UserInfo.password
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录密码")
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_UserInfo.password
     *
     * @param password the value for test_UserInfo.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_UserInfo.salt
     *
     * @return the value of test_UserInfo.salt
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "加盐密码")
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_UserInfo.salt
     *
     * @param salt the value for test_UserInfo.salt
     *
     * @mbggenerated
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_UserInfo.name
     *
     * @return the value of test_UserInfo.name
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_UserInfo.name
     *
     * @param name the value for test_UserInfo.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_UserInfo.operator_status
     *
     * @return the value of test_UserInfo.operator_status
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "账号状态 'NORMAL','正常“，'DISABLE', '停用'")
    public String getOperatorStatus() {
        return operatorStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_UserInfo.operator_status
     *
     * @param operatorStatus the value for test_UserInfo.operator_status
     *
     * @mbggenerated
     */
    public void setOperatorStatus(String operatorStatus) {
        this.operatorStatus = operatorStatus == null ? null : operatorStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_UserInfo.row_add_time
     *
     * @return the value of test_UserInfo.row_add_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    public Date getRowAddTime() {
        return rowAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_UserInfo.row_add_time
     *
     * @param rowAddTime the value for test_UserInfo.row_add_time
     *
     * @mbggenerated
     */
    public void setRowAddTime(Date rowAddTime) {
        this.rowAddTime = rowAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_UserInfo.row_update_time
     *
     * @return the value of test_UserInfo.row_update_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间")
    public Date getRowUpdateTime() {
        return rowUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_UserInfo.row_update_time
     *
     * @param rowUpdateTime the value for test_UserInfo.row_update_time
     *
     * @mbggenerated
     */
    public void setRowUpdateTime(Date rowUpdateTime) {
        this.rowUpdateTime = rowUpdateTime;
    }
    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }

    List<TestSysRole> roleList;
    @ApiModelProperty(value = "角色list")
    public List<TestSysRole> getRoleList() {
        return roleList;
    }
    public void setRoleList(List<TestSysRole> roleList) {
        this.roleList = roleList;
    }
}
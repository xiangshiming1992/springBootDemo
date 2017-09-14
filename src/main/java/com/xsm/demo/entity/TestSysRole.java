package com.xsm.demo.entity;

import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;

public class TestSysRole {
    /**
     * 角色ID
     *
     * @mbggenerated
     */
    private Long roleId;

    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的:
     *
     * @mbggenerated
     */
    private String role;

    /**
     * 角色描述,UI界面显示使用
     *
     * @mbggenerated
     */
    private String description;

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
     * This method returns the value of the database column test_SysRole.role_id
     *
     * @return the value of test_SysRole.role_id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色ID")
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_SysRole.role_id
     *
     * @param roleId the value for test_SysRole.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_SysRole.role
     *
     * @return the value of test_SysRole.role
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色标识程序中判断使用,如'admin',这个是唯一的:")
    public String getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_SysRole.role
     *
     * @param role the value for test_SysRole.role
     *
     * @mbggenerated
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_SysRole.description
     *
     * @return the value of test_SysRole.description
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色描述,UI界面显示使用")
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_SysRole.description
     *
     * @param description the value for test_SysRole.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_SysRole.row_add_time
     *
     * @return the value of test_SysRole.row_add_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    public Date getRowAddTime() {
        return rowAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_SysRole.row_add_time
     *
     * @param rowAddTime the value for test_SysRole.row_add_time
     *
     * @mbggenerated
     */
    public void setRowAddTime(Date rowAddTime) {
        this.rowAddTime = rowAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_SysRole.row_update_time
     *
     * @return the value of test_SysRole.row_update_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间")
    public Date getRowUpdateTime() {
        return rowUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_SysRole.row_update_time
     *
     * @param rowUpdateTime the value for test_SysRole.row_update_time
     *
     * @mbggenerated
     */
    public void setRowUpdateTime(Date rowUpdateTime) {
        this.rowUpdateTime = rowUpdateTime;
    }

    private List<TestSysPermission> permissions;

    @ApiModelProperty(value = "权限list")
    public List<TestSysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<TestSysPermission> permissions) {
        this.permissions = permissions;
    }
}
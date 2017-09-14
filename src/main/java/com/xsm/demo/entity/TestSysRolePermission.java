package com.xsm.demo.entity;

import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class TestSysRolePermission {
    /**
     * 主键ID
     *
     * @mbggenerated
     */
    private Long rolePermissionId;

    /**
     * 权限ID
     *
     * @mbggenerated
     */
    private Long permissionId;

    /**
     * 角色ID
     *
     * @mbggenerated
     */
    private Long roleId;

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
     * This method returns the value of the database column test_SysRolePermission.role_permission_id
     *
     * @return the value of test_SysRolePermission.role_permission_id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键ID")
    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_SysRolePermission.role_permission_id
     *
     * @param rolePermissionId the value for test_SysRolePermission.role_permission_id
     *
     * @mbggenerated
     */
    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_SysRolePermission.permission_id
     *
     * @return the value of test_SysRolePermission.permission_id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "权限ID")
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_SysRolePermission.permission_id
     *
     * @param permissionId the value for test_SysRolePermission.permission_id
     *
     * @mbggenerated
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_SysRolePermission.role_id
     *
     * @return the value of test_SysRolePermission.role_id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色ID")
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_SysRolePermission.role_id
     *
     * @param roleId the value for test_SysRolePermission.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_SysRolePermission.row_add_time
     *
     * @return the value of test_SysRolePermission.row_add_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    public Date getRowAddTime() {
        return rowAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_SysRolePermission.row_add_time
     *
     * @param rowAddTime the value for test_SysRolePermission.row_add_time
     *
     * @mbggenerated
     */
    public void setRowAddTime(Date rowAddTime) {
        this.rowAddTime = rowAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_SysRolePermission.row_update_time
     *
     * @return the value of test_SysRolePermission.row_update_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间")
    public Date getRowUpdateTime() {
        return rowUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_SysRolePermission.row_update_time
     *
     * @param rowUpdateTime the value for test_SysRolePermission.row_update_time
     *
     * @mbggenerated
     */
    public void setRowUpdateTime(Date rowUpdateTime) {
        this.rowUpdateTime = rowUpdateTime;
    }
}
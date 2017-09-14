package com.xsm.demo.service.impl;

import com.xsm.demo.common.mybatis.ManagerImpl;
import com.xsm.demo.dao.TestSysRolePermissionMapper;
import com.xsm.demo.entity.TestSysRolePermission;
import com.xsm.demo.entity.TestSysRolePermissionExample;
import com.xsm.demo.service.TestSysRolePermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSysRolePermissionManagerImpl extends ManagerImpl<TestSysRolePermission,TestSysRolePermissionExample,Long> implements TestSysRolePermissionManager{
    private TestSysRolePermissionMapper thisMapper;
    @Autowired
    public TestSysRolePermissionManagerImpl(TestSysRolePermissionMapper thisMapper){
        this.mapper = thisMapper;
        this.thisMapper = thisMapper;
    }
}

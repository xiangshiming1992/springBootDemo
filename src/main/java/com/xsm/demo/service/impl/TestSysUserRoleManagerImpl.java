package com.xsm.demo.service.impl;

import com.xsm.demo.common.mybatis.ManagerImpl;
import com.xsm.demo.dao.TestSysUserRoleMapper;
import com.xsm.demo.entity.TestSysUserRole;
import com.xsm.demo.entity.TestSysUserRoleExample;
import com.xsm.demo.service.TestSysUserRoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSysUserRoleManagerImpl extends ManagerImpl<TestSysUserRole,TestSysUserRoleExample,Long> implements TestSysUserRoleManager {
    private TestSysUserRoleMapper thisMapper;
    @Autowired
    public TestSysUserRoleManagerImpl(TestSysUserRoleMapper thisMapper){
        this.mapper = thisMapper;
        this.thisMapper = thisMapper;
    }
}

package com.xsm.demo.service.impl;

import com.xsm.demo.common.mybatis.ManagerImpl;
import com.xsm.demo.dao.TestSysRoleMapper;
import com.xsm.demo.entity.TestSysRole;
import com.xsm.demo.entity.TestSysRoleExample;
import com.xsm.demo.service.TestSysRoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSysRoleManagerImpl extends ManagerImpl<TestSysRole,TestSysRoleExample,Long> implements TestSysRoleManager {
    private TestSysRoleMapper thisMapper;
    @Autowired
    public  TestSysRoleManagerImpl(TestSysRoleMapper thisMapper){
        this.mapper = thisMapper;
        this.thisMapper = thisMapper;
    }
}

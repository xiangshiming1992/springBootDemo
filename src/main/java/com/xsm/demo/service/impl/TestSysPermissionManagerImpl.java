package com.xsm.demo.service.impl;

import com.xsm.demo.common.mybatis.ManagerImpl;
import com.xsm.demo.dao.TestSysPermissionMapper;
import com.xsm.demo.entity.TestSysPermission;
import com.xsm.demo.entity.TestSysPermissionExample;
import com.xsm.demo.service.TestSysPermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSysPermissionManagerImpl extends ManagerImpl<TestSysPermission,TestSysPermissionExample,Long> implements TestSysPermissionManager{
    private TestSysPermissionMapper thisMapper;
    @Autowired
    public TestSysPermissionManagerImpl(TestSysPermissionMapper thisMapper){
        this.mapper = thisMapper;
        this.thisMapper = thisMapper;
    }
}

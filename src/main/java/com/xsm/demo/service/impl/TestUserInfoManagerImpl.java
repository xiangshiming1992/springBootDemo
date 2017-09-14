package com.xsm.demo.service.impl;

import com.xsm.demo.common.mybatis.ManagerImpl;
import com.xsm.demo.dao.TestUserInfoMapper;
import com.xsm.demo.entity.TestUserInfo;
import com.xsm.demo.entity.TestUserInfoExample;
import com.xsm.demo.service.TestUserInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestUserInfoManagerImpl extends ManagerImpl<TestUserInfo,TestUserInfoExample,Long> implements TestUserInfoManager {
    private TestUserInfoMapper thisMapper;
    @Autowired
    public TestUserInfoManagerImpl(TestUserInfoMapper thisMapper){
        this.mapper = thisMapper;
        this.thisMapper = thisMapper;
    }
}

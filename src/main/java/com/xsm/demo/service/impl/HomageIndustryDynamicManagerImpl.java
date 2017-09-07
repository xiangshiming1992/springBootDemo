package com.xsm.demo.service.impl;

import com.xsm.demo.common.mybatis.ManagerImpl;
import com.xsm.demo.dao.HomageIndustryDynamicMapper;
import com.xsm.demo.entity.HomageIndustryDynamic;
import com.xsm.demo.entity.HomageIndustryDynamicExample;
import com.xsm.demo.service.HomageIndustryDynamicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomageIndustryDynamicManagerImpl extends ManagerImpl<HomageIndustryDynamic, HomageIndustryDynamicExample, Long> implements HomageIndustryDynamicManager {
    @Autowired
    private HomageIndustryDynamicMapper thisMapper;

    @Autowired
    public HomageIndustryDynamicManagerImpl(HomageIndustryDynamicMapper thisMapper) {
        this.mapper = thisMapper;
        this.thisMapper = thisMapper;
    }
}

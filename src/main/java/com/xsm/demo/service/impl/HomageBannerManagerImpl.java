package com.xsm.demo.service.impl;

import com.xsm.demo.common.mybatis.ManagerImpl;
import com.xsm.demo.dao.HomageBannerMapper;
import com.xsm.demo.entity.HomageBanner;
import com.xsm.demo.entity.HomageBannerExample;
import com.xsm.demo.service.HomageBannerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomageBannerManagerImpl extends ManagerImpl<HomageBanner, HomageBannerExample, Long> implements HomageBannerManager {

    @Autowired
    private HomageBannerMapper thisMapper;

    @Autowired
    public HomageBannerManagerImpl(HomageBannerMapper thisMapper) {
        this.mapper = thisMapper;
        this.thisMapper = thisMapper;
    }
}

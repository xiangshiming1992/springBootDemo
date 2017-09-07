package com.xsm.demo.controller;

import com.xsm.demo.common.pageHelper.PageHelper;
import com.xsm.demo.common.result.BasePageResult;
import com.xsm.demo.entity.HomageIndustryDynamic;
import com.xsm.demo.entity.HomageIndustryDynamicExample;
import com.xsm.demo.service.HomageBannerManager;
import com.xsm.demo.service.HomageIndustryDynamicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    HomageBannerManager homageBannerManager;

    @Autowired
    HomageIndustryDynamicManager homageIndustryDynamicManager;
    @ResponseBody
    @RequestMapping(value="/get", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BasePageResult<HomageIndustryDynamic> Testyo(HttpServletRequest req, HttpServletResponse resp,
                                                        @RequestParam Integer pageNum, @RequestParam Integer pageSize){
        BasePageResult<HomageIndustryDynamic> result = new BasePageResult<HomageIndustryDynamic>();
        HomageIndustryDynamicExample example = new HomageIndustryDynamicExample();
        example.or().andTypeEqualTo("FS");
        PageHelper pageable = new PageHelper(pageNum,pageSize);
        Page<HomageIndustryDynamic> page =  homageIndustryDynamicManager.selectPageByExample(pageable,example);
        result.setResult(page);
        return result;

    }
}

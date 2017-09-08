package com.xsm.demo.controller;

import com.xsm.demo.common.pageHelper.PageHelper;
import com.xsm.demo.common.result.BasePageResult;
import com.xsm.demo.entity.HomageIndustryDynamic;
import com.xsm.demo.entity.HomageIndustryDynamicExample;
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
    HomageIndustryDynamicManager homageIndustryDynamicManager;
    /*@Autowired
    RedisTokenManagerImpl redisTokenManagerImpl;*/
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

   /* @ResponseBody
    @RequestMapping(value="/setRedis", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseResult setRedis(HttpServletRequest req, HttpServletResponse resp, @RequestParam String userId){
        BaseObjectResult<TokenModel> result = new BaseObjectResult<TokenModel>("10000","存入成功");
        TokenModel model = redisTokenManagerImpl.createToken(userId);
        result.setResult(model);
        return  result;
    }

    @ResponseBody
    @RequestMapping(value="/getRedis", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseObjectResult<TokenModel> getRedis(HttpServletRequest req, HttpServletResponse resp, @RequestParam String tokenInfo){
        BaseObjectResult<TokenModel> result = new BaseObjectResult<TokenModel>("10000","读取成功");
        TokenModel model = redisTokenManagerImpl.getToken(tokenInfo);
        result.setResult(model);
        return  result;
    }*/
}

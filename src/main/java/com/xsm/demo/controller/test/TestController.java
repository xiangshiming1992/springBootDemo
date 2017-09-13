package com.xsm.demo.controller.test;

import com.xsm.demo.common.pageHelper.PageHelper;
import com.xsm.demo.common.result.BaseObjectResult;
import com.xsm.demo.common.result.BasePageResult;
import com.xsm.demo.common.result.BaseResult;
import com.xsm.demo.common.utils.RedisUtil.RedisCacheUtils;
import com.xsm.demo.common.utils.RedisUtil.RedisTokenUtils;
import com.xsm.demo.entity.HomageIndustryDynamic;
import com.xsm.demo.entity.HomageIndustryDynamicExample;
import com.xsm.demo.service.HomageIndustryDynamicManager;
import com.xsm.demo.service.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    HomageIndustryDynamicManager homageIndustryDynamicManager;
    @Autowired
    RedisTokenUtils redisTokenManagerImpl;
    @Autowired
    RedisCacheUtils redisCacheUtilsManager;

    //###############################数据库分页数据查询#############################
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

    //####################################################redis做用户token校验测试###############################
    @ResponseBody
    @RequestMapping(value="/setRedis", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseObjectResult<TokenModel> setRedis(HttpServletRequest req, HttpServletResponse resp, @RequestParam String userId){
        BaseObjectResult<TokenModel> result = new BaseObjectResult<TokenModel>("10000","存入成功");
        TokenModel model = redisTokenManagerImpl.createToken(userId,86400);
        result.setResult(model);
        return  result;
    }

    @ResponseBody
    @RequestMapping(value="/checkRedis", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseObjectResult<Boolean> getRedis(HttpServletRequest req, HttpServletResponse resp, @RequestBody TokenModel tokenInfo){
        BaseObjectResult<Boolean> result = new BaseObjectResult<Boolean>("10000","检查成功");
        boolean flag = redisTokenManagerImpl.checkToken(tokenInfo);
        result.setResult(flag);
        return  result;
    }

    //#########################################################Redis 做数据缓存测试############################################
    @ResponseBody
    @RequestMapping(value="/setCache", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseResult setCache(HttpServletRequest req, HttpServletResponse resp, @RequestBody SetCatchTestModel test){
        BaseResult result = new BaseResult("10000","存入缓存成功");
        redisCacheUtilsManager.set("110_sp",test,30L);
        return  result;
    }

    @ResponseBody
    @RequestMapping(value="/readCache", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseObjectResult<SetCatchTestModel> readCache(HttpServletRequest req, HttpServletResponse resp, @RequestParam String key){
        BaseObjectResult<SetCatchTestModel> result = new BaseObjectResult<SetCatchTestModel>("10000","读取缓存成功");
        SetCatchTestModel result1 = (SetCatchTestModel) redisCacheUtilsManager.get(key);
        result.setResult(result1);
        return  result;
    }
}

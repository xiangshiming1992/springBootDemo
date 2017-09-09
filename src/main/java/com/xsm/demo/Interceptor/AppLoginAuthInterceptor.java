package com.xsm.demo.Interceptor;
import com.alibaba.fastjson.JSON;
import com.xsm.demo.common.result.BaseResult;
import com.xsm.demo.common.utils.RedisUtil.RedisTokenUtils;
import com.xsm.demo.dao.enums.CodeEnum;
import com.xsm.demo.service.model.TokenModel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppLoginAuthInterceptor extends HandlerInterceptorAdapter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	RedisTokenUtils tokenManager;
	/*@Resource
	TravelinkUserManager travelinkUserManager;*/
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			HandlerMethod _handler=((HandlerMethod) handler);
			AppLoginAuth loginAuth = _handler.getMethodAnnotation(AppLoginAuth.class);
			if (loginAuth == null) {
				return true;
			}
			String tokenInfo = request.getHeader("tokenInfo");
			if(StringUtils.isBlank(tokenInfo)){
				BaseResult baseResult=new BaseResult(CodeEnum.PLEASE_SIGN_IN.getCode(),"请您先登录APP");
				response.setContentType("application/json");  
				response.getWriter().write(JSON.toJSONString(baseResult));
				response.getWriter().close();
				return false;
			}
			TokenModel tokenModel = tokenManager.getToken(tokenInfo);
			if (null == tokenModel) {
				BaseResult baseResult=new BaseResult(CodeEnum.PLEASE_SIGN_IN.getCode(),"请您先登录APP");
				response.setContentType("application/json");  
				response.getWriter().write(JSON.toJSONString(baseResult));
				response.getWriter().close();
				return false;
			}
			//校验token有效性
			boolean flag = tokenManager.checkToken(tokenModel);
			if(!flag){
				BaseResult baseResult=new BaseResult(CodeEnum.PLEASE_SIGN_IN.getCode(),"登录信息已失效，请您重新登录");
				response.setContentType("application/json");  
				response.getWriter().write(JSON.toJSONString(baseResult));
				response.getWriter().close();
				return false;
			}
			String userId = tokenModel.getUserId();
			/*TravelinkUser travelinkUser=travelinkUserManager.selectByPrimaryKey(userId);
			if(null == travelinkUser){
				BaseResult baseResult=new BaseResult(CodeEnum.PLEASE_SIGN_IN.getCode(),"请您先登录APP");
				response.setContentType("application/json");  
				response.getWriter().write(JSON.toJSONString(baseResult));
				response.getWriter().close();
				return false;
			}
			if("BIND_DEL".equals(travelinkUser.getUserStatus())){
				BaseResult baseResult=new BaseResult(CodeEnum.PLEASE_SIGN_IN.getCode(),"登录信息已失效，请您重新登录");
				logger.info("登录信息已失效，请您重新登录");
				response.setContentType("application/json");  
				response.getWriter().write(JSON.toJSONString(baseResult));
				response.getWriter().close();
				return false;
			}
			//判断是否 被管理员禁用账号
			if("DISABLE".equals(travelinkUser.getUserStatus())){
				BaseResult baseResult=new BaseResult(CodeEnum.ACCOUNT_FREEZE.getCode(),"你的帐号被管理员冻结，暂时无法使用,请联系官方处理");
				logger.info("App请先登录（账号被管理员冻结了）...");
				response.setContentType("application/json");  
				response.getWriter().write(JSON.toJSONString(baseResult));
				response.getWriter().close();
				return false;
			}*/
		}
		return super.preHandle(request, response, handler);
	}
}

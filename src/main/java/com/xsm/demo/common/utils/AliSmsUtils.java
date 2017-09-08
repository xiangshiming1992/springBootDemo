package com.xsm.demo.common.utils;/*package com.boken.parking.common.util;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boken.parking.common.exception.BusinessDealException;
import com.boken.parking.common.global.Configure;
import com.boken.parking.dal.enums.SmsTemplateCode;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
*//**
 * 阿里大于发短信工具类
 * @author ShyMe
 *//*
public class AliSmsUtils {
	static Logger logger=LoggerFactory.getLogger(AliSmsUtils.class);

	public static void sendSms(List<String> phones,String templateParam,String templateCode)throws Exception{
		//集合String 转换为 逗号分隔 的String
		String mobiles = StringUtils.join(phones, ",");
		String url=Configure.getSmsSendUrl();
		TaobaoClient client = new DefaultTaobaoClient(url, Configure.getSmsAppKey(), Configure.getSmsAppSecret());
		AlibabaAliqinFcSmsNumSendRequest  req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setRecNum(mobiles);
		req.setSmsFreeSignName("时代众旺");
		req.setSmsTemplateCode(templateCode);
		req.setSmsType("normal");
		req.setSmsParamString(templateParam);
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		logger.info("阿里大鱼发送短信打印日志为："+rsp.getBody());
		String result = rsp.getBody();
		logger.info("阿里大鱼发送短信打印日志为："+result);
		//根据返回的json 判断是否成功
		//{"alibaba_aliqin_fc_sms_num_send_response":{"result":{"err_code":"0","model":"100895428250^1101345707165","success":true},"request_id":"z2baww6w5jth"}}
		if(StringUtils.isBlank(result) || !result.contains("\"success\":true")){
			throw new BusinessDealException("发送短信失败！");
		}
	}
	
	public static void main(String[] args) {
		List<String> phones = new ArrayList<String>();
		phones.add("13628420127");
		String sendCode = "666666";
		String smsParam="{code:\""+sendCode+"\",product:\"云祭网\"}";
		//String smsParam="{code:\"888888\",product:\"您正在注册云祭平台\"}";
		String smsTemplateCode = SmsTemplateCode.USER_CHANGE_PWD.getValue();
		try {
			sendSms(phones, smsParam,smsTemplateCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

*/
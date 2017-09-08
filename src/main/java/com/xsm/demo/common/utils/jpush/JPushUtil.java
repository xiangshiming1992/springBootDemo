package com.xsm.demo.common.utils.jpush;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.alibaba.fastjson.JSON;
import com.xsm.demo.common.global.Configure;
import com.xsm.demo.common.utils.DateUtils;
import com.xsm.demo.common.utils.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.util.*;

public class JPushUtil {
	private static String jPushAppKey= Configure.getJPushAppKey();
	private static String jPushMasterSecret=Configure.getJPushMasterSecret();
	private static String jPushApiUrl = Configure.getJPushApiUrl();
	static Logger logger= LoggerFactory.getLogger(JPushUtil.class);
	/**
	 * 平台用户和极光别名绑定
	 * 参数说明：String user 需要绑定的用户可以是自己平台的userId
	 * String registrationId 设备id由app传参过来
	 */
	@SuppressWarnings("restriction")
	public static void bindingJPush(String userId,String registrationId,String areaCode){
		try{
			String str = jPushAppKey+":"+jPushMasterSecret;
			String token = new BASE64Encoder().encode(str.getBytes());
			String url = jPushApiUrl+"/v3/devices/" + registrationId;
			JPushDevice jpdever = new JPushDevice();
			//设置不同环境tag 和 区域tag
			JPushDevice.Tags tags= jpdever.new Tags();
			//判断当前什么环境启动
			String env = System.getProperty("spring.profiles.active");
			if(!"online".equals(env)){
				env = "test";
			}
			String [] tagsZhi = {env};
			//区域设置tag 按区域推送
			if(StringUtils.isNotBlank(areaCode)){
				tagsZhi = new String[]{env,areaCode};
			}
			if("online".equals(env)){
				tags.setRemove(new String[]{"test"});
			}
			if(!"online".equals(env)){
				tags.setRemove(new String[]{"online"});
			}
			tags.setAdd(tagsZhi);
			jpdever.setTags(tags);
			jpdever.setAlias(userId);
			String requestBody = JSON.toJSONString(jpdever);
			Map<String,String> headerMap = new HashMap<String,String>();
			headerMap.put("Authorization", "Basic " + token);
			headerMap.put("Accept", "application/json");
			String abc = HttpClientUtil.postHttps(url, requestBody, "application/json; charset=utf-8", headerMap);
			logger.info("极光绑定设备日志输出：" + abc);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 推送 --消息  扩展字段
	 * alias别名
	 * tags tag
	 * device 设备
	 */
	public static void senPushMSG_EX(List<String> alias,List<String> tags,String device,JPushChatModel jpModel){
		String env= System.getProperty("spring.profiles.active");
		boolean apns=false;
		if(null == tags){
			tags = new ArrayList<String>();
		}
		if("online".equals(env)){
			apns=true;
			tags.add("online");
		}
		else{
			tags.add("test");
		}
        JPushClient jpushClient = new JPushClient(jPushMasterSecret, jPushAppKey);
        Platform platform = null;
        if (device.equals("0")) {//所有
        	platform = Platform.all();
        } else if (device.equals("1")) {
        	platform = Platform.ios();
        } else {
           	platform = Platform.android();
        }
        Audience audience=null;
		if(null==alias && null!=tags){
			audience=Audience.tag_and(tags);
		}
		if(null!=alias && null==tags){
			audience=Audience.alias(alias);
		}
		if(null!=alias && null!=tags){
			audience=Audience.newBuilder()
					.addAudienceTarget(AudienceTarget.tag_and(tags))
					.addAudienceTarget(AudienceTarget.alias(alias))
					.build();
		}
		PushPayload payload = PushPayload.newBuilder()
				.setMessage(Message.newBuilder().setTitle(jpModel.getTitle()).setMsgContent(jpModel.getContent())
				.addExtra("type", jpModel.getType())
				.addExtra("tuiTime", DateUtils.DateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date()))
				.build())
				.setOptions(Options.newBuilder()
						 .setApnsProduction(apns)
						 .build())
				.setPlatform(platform)
				.setAudience(audience).build();
		try {
			PushResult result = jpushClient.sendPush(payload);
			logger.info("推送日志：" + result);
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIRequestException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 推送 --消息&通知 扩展字段
	 * device 0 所有设备   1 ios设备  2 安卓
	 */
	public static void senPushALERT_MSG_EX(List<String> alias,List<String> tags,String device,JPushChatModel jpModel){
		String env= System.getProperty("spring.profiles.active");
		boolean apns=false;
		if(null == tags){
			tags = new ArrayList<String>();
		}
		if("online".equals(env)){
			apns=true;
			tags.add("online");
		}
		else{
			tags.add("test");
		}
		//建立JpushClient类，用来发送消息的对象
		JPushClient jpushClient = new JPushClient(jPushMasterSecret, jPushAppKey);
        Platform platform = null;
        if (device.equals("0")) {//所有
        	platform = Platform.all();
        } else if (device.equals("1")) {
        	platform = Platform.ios();
        } else {
           	platform = Platform.android();
        }
        Audience audience=null;
		if(null==alias && null!=tags){
			audience=Audience.tag_and(tags);
		}
		if(null!=alias && null==tags){
			audience=Audience.alias(alias);
		}
		if(null!=alias && null!=tags){
			audience=Audience.newBuilder()
					.addAudienceTarget(AudienceTarget.tag_and(tags))
					.addAudienceTarget(AudienceTarget.alias(alias))
					.build();
		}
        PushPayload payload = PushPayload.newBuilder()
				.setMessage(
						Message.newBuilder().setTitle(jpModel.getTitle()).setMsgContent(jpModel.getContent())
						.addExtra("type", jpModel.getType())
						.addExtra("tuiTime", DateUtils.DateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date()))
						.build())
				.setNotification(Notification.newBuilder()
						.setAlert(jpModel.getContent())
						
						.addPlatformNotification(
								IosNotification.newBuilder()
		                        .setAlert(jpModel.getContent())
		                        .addExtra("type", jpModel.getType())
								.addExtra("tuiTime", DateUtils.DateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date()))
		                        .setSound("happy.caf")
                        .build())
						
						.addPlatformNotification(AndroidNotification.newBuilder()
		                        .setAlert(jpModel.getContent())
		                        .addExtra("type", jpModel.getType())
								.addExtra("tuiTime", DateUtils.DateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date()))
		                        .build())
                .build())
				.setOptions(Options.newBuilder()
						 .setApnsProduction(apns)
						 .build())
				.setPlatform(platform)
				.setAudience(audience).build();
        
		try {
			PushResult result = jpushClient.sendPush(payload);
			logger.info("推送日志：" + result);
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIRequestException e) {
			e.printStackTrace();
		}
	}
}

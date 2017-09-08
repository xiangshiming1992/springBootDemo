package com.xsm.demo.common.global;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 初始化加载配置集合
 * @author		xsm
 * @created	2016年5月11日12:36:04
 */
public class InitGlobalConfig{
	private static final Logger logger = LoggerFactory.getLogger(InitGlobalConfig.class);
	/**
	 * 配置参数集合
	 */
	private static Map<String, String> allConfigMap = new HashMap<String, String>();
	
	/**
	 * 支付宝全部参数配置集合
	 */
	private static Map<String, String> aliPayAllConfigMap = new HashMap<String, String>();
	
	/**
	 * 微信支付参数配置
	 */
	private static Map<String, String> wxPublicAllConfigMap = new HashMap<String, String>();
	
	/**
	 * 给支付宝所有配置参数
	 * @return	Map<String, String>
	 * @since	2016年5月11日12:35:59
	 * @author	xsm
	 */
	public static void setAlipayConfigMap() throws Exception{
		Map<String, String> result = new HashMap<String, String>();
		result.put("alipay.notify_url", allConfigMap.get("alipay.notify_url"));
		result.put("alipay.merchant_id", allConfigMap.get("alipay.merchant_id"));
		result.put("alipay.merchant_private_key", allConfigMap.get("alipay.merchant_private_key"));
		result.put("alipay.merchant_public_key", allConfigMap.get("alipay.merchant_public_key"));
		result.put("alipay.ali_public_key", allConfigMap.get("alipay.ali_public_key"));
		result.put("alipay.ali_private.key", allConfigMap.get("alipay.ali_private.key"));
		result.put("alipay.encoding", allConfigMap.get("alipay.encoding"));
		result.put("alipay.seller.Id", allConfigMap.get("alipay.seller.Id"));
		result.put("alipay.refund.notify.url", allConfigMap.get("alipay.refund.notify.url"));
		result.put("alipay.pay_api_url", allConfigMap.get("alipay.pay_api_url"));
		result.put("alipay.app_id", allConfigMap.get("alipay.app_id"));
		result.put("alipay.https.verify.url", allConfigMap.get("alipay.https.verify.url"));
		result.put("alipay.log_path", allConfigMap.get("alipay.log_path"));
		for (String key : result.keySet()) {
            String value = result.get(key);
            logger.info("参数：-------"+key+":"+value);
            if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
            	throw new Exception("系统自启动时发生系统错误:获取支付宝参数时含有空值，参数名为"+key+"，值为:"+value);
            }
        }
		aliPayAllConfigMap = result;
	}
	
	/**
	 * 给微信所有配置参数
	 * @return	Map<String, String>
	 * @since	2016年5月11日12:35:59
	 * @author	xsm
	 */
	public static void setWxPublicAllConfigMap() throws Exception{
		Map<String, String> result = new HashMap<String, String>();
		/*result.put("wx.public.APPID", allConfigMap.get("wx.public.APPID"));
		result.put("wx.public.APP_SECRECT", allConfigMap.get("wx.public.APP_SECRECT"));
		result.put("wx.public.TOKEN", allConfigMap.get("wx.public.TOKEN"));
		result.put("wx.public.MCH_ID", allConfigMap.get("wx.public.MCH_ID"));
		result.put("wx.public.API_KEY", allConfigMap.get("wx.public.API_KEY"));
		result.put("wx.public.SIGN_TYPE", allConfigMap.get("wx.public.SIGN_TYPE"));
		result.put("wx.public.CERT_PATH", allConfigMap.get("wx.public.CERT_PATH"));
		result.put("wx.public.NOTIFY_URL", allConfigMap.get("wx.public.NOTIFY_URL"));
		result.put("wx.public.SUCCESS_URL", allConfigMap.get("wx.public.SUCCESS_URL"));
		result.put("wx.public.REDIRECT_URI", allConfigMap.get("wx.public.REDIRECT_URI"));
		result.put("wx.public.UNIFIED_ORDER_URL", allConfigMap.get("wx.public.UNIFIED_ORDER_URL"));
		result.put("wx.public.REFUND_URL", allConfigMap.get("wx.public.REFUND_URL"));
		result.put("wx.public.CHECK_ORDER_URL", allConfigMap.get("wx.public.CHECK_ORDER_URL"));
		for (String key : result.keySet()) {
            String value = result.get(key);
            if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
            	throw new Exception("系统自启动时发生系统错误:获取微信公众支付参数时含有空值，参数名为"+key+"，值为:"+value);
            }
        }*/
		wxPublicAllConfigMap = result;
	}
	
	/**
	 * 获取支付宝所有配置文件参数集合
	 */
	public static Map<String, String> getAliPayConfigMap(){
		return aliPayAllConfigMap;
	}
	/**
	 * 获取微信公众支付所有配置文件参数集合
	 */
	public static Map<String, String> getWxPublicAllConfigMap(){
		return wxPublicAllConfigMap;
	}
	
	/**
	 * 设置所有配置文件参数集合
	 */
	public static void setAllConfigMap(Map<String, String> paramsMap) throws Exception{
		allConfigMap = paramsMap;
		setAlipayConfigMap();
		setWxPublicAllConfigMap();
	}

	/**
	 * 获取所有配置Map集合
	 * @return Map<String, String>
	 */
	public static Map<String, String> getAllConfigMap() {
		return allConfigMap;
	}
	
}

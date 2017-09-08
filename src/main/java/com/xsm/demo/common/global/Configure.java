package com.xsm.demo.common.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public final class Configure {
	private static final Logger logger = LoggerFactory.getLogger(Configure.class);
	/**
	 * 配置参数集合
	 */
	private static Map<String, String> allConfigMap = new HashMap<String, String>();
	
	//上传文件的路径和URL配置
	private static final String rootPath = "rootPath";
	private static final String rootUrl = "rootUrl";
	//极光推送
	private static final String jPushAppKey="JPushAppKey";
	private static final String jPushMasterSecret="JPushMasterSecret";
	private static final String jPushApiUrl="JPushApiUrl";
	//内部系统调用IP白名单
	private static final String nbip = "nbip";
	
	static {
		String profiles = System.getProperty("spring.profiles.active", "dev");
		logger.info("=========================>>>>在什么环境启动？===>"+profiles);
		String fileName = "config/config-" + profiles +  ".properties";
		allConfigMap = PropertiesUtil.getPropMap(fileName);
	}
	/**
	 * @return the configMap
	 */
	public static Map<String, String> getConfigMap() {
		return allConfigMap;
	}
	
	public static String getValue(String key){
		return allConfigMap.get(key);
	}
	
	/**
	 * 获取所有配置文件参数集合
	 */
	public static void setAllConfigMap(Map<String, String> paramsMap) {
		allConfigMap = paramsMap;
	}

	/**
	 * 获取所有配置Map集合
	 * @return Map<String, String>
	 */
	public static Map<String, String> getAllConfigMap() {
		return allConfigMap;
	}
	//上传文件的路径和URL配置
	public static String getRootPath() {
		return PropertiesUtil.getValue(rootPath);
	}
	public static String getRootUrl() {
		return PropertiesUtil.getValue(rootUrl);
	}
	//极光推送
	public static String getJPushAppKey(){
		return PropertiesUtil.getValue(jPushAppKey);
	}
	public static String getJPushMasterSecret(){
		return PropertiesUtil.getValue(jPushMasterSecret);
	}
	public static String getJPushApiUrl(){
		return PropertiesUtil.getValue(jPushApiUrl);
	}
	//内部系统调用IP白名单
	public static String getNbip(){
		return PropertiesUtil.getValue(nbip);
	}
}

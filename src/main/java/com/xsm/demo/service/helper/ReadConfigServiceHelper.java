package com.xsm.demo.service.helper;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * 启动读取配置
 * @author Mr.ShyMe
 *
 */
@Service
public class ReadConfigServiceHelper {
	
	/** 资源参数配置 **/
	//@Resource TravelinkConfigResourceParamsMapper travelinkConfigResourceParamsMapper;
	
	/**
	 * 初始化所有配置参数Map集合
	 * 包括业务参数、资源参数
	 * @return	Map<String, String>
	 * @since	2016年5月11日12:49:54
	 * @author	Mr.ShyMe
	 */
	@PostConstruct
	public void init() throws Exception{
		System.out.println("加载资源执行了？？？？");
		/*Map<String, String> result = new HashMap<String, String>();
		// 读取所有资源参数
		List<TravelinkConfigResourceParams>  configResourceParamsList = travelinkConfigResourceParamsMapper.selectByExample(null);
		for(TravelinkConfigResourceParams item: configResourceParamsList){
			result.put(item.getConfigKey(), item.getConfigValue());
			System.out.println("............."+item.getConfigKey()+",,"+item.getConfigValue());
		}
		//将查询到的数据库里的配置参数集合赋值给InitGlobalConfig类里的Map集合里面
		InitGlobalConfig.setAllConfigMap(result);*/
	}
	
}

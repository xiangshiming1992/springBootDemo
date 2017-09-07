package com.xsm.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@MapperScan(basePackages="com.xsm.demo.dao")
@ServletComponentScan
public class Application {

	public static void main(String[] args) {
		//###############指定环境和端口启动##########
		setEvnAndPort("dev","8012");
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 指定环境和端口启动
	 * @param env
	 * @param port
	 */
	public static void setEvnAndPort(String env,String port){
		System.setProperty("spring.profiles.active", env);
		System.setProperty("server.port", port);
	}
}

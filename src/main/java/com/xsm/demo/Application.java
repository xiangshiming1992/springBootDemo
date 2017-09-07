package com.xsm.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@MapperScan(basePackages="com.spring.boot.dao")
public class Application {
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

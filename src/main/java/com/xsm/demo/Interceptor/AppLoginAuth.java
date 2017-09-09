package com.xsm.demo.Interceptor;

import java.lang.annotation.*;

/**
 * app是否登录访问接口的注解
 * @author ShyMe
 *
 */
@Documented
@Inherited
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AppLoginAuth {
	
}

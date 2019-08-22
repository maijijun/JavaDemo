package com.maijijun.spring.test;

import com.maijijun.spring.controller.HelloWorld;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springTest {
	@Test
	public void hello(){
		//创建spring的IOC容器对象
		ApplicationContext context = new ClassPathXmlApplicationContext("MATE-INF/applicationContext.xml");
		//从ioc容器中获取bean实例
		HelloWorld helloWorld =(HelloWorld) context.getBean("helloWorld");
		helloWorld.hello();
	}
}

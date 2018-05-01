package com.yy.sample.ch1.controller;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

//用于声明这是一个Spring管理配置Bean
@Configuration
//声明该类为一个切面类
@Aspect 
public class AOPConfig {
	//声明了一个表达式,@within代表目标类有注解  org.springframework.stereotype.Controller 代表有@Controller注解 ,这样就代表所有Controller执行的时候都会执行simpleAOP这个方法
	@Around("@within(org.springframework.stereotype.Controller) ")
	public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable{
		try {
		Object[] args = pjp.getArgs();
		System.out.println("args : " + Arrays.asList(args));
		//调用原有方法
		Object o = pjp.proceed();
		System.out.println("return : " + o);
		return o;
		}catch(Throwable e) {
			throw e;
		}
	}
}

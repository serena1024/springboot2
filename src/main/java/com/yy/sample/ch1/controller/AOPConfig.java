package com.yy.sample.ch1.controller;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

//������������һ��Spring��������Bean
@Configuration
//��������Ϊһ��������
@Aspect 
public class AOPConfig {
	//������һ�����ʽ,@within����Ŀ������ע��  org.springframework.stereotype.Controller ������@Controllerע�� ,�����ʹ�������Controllerִ�е�ʱ�򶼻�ִ��simpleAOP�������
	@Around("@within(org.springframework.stereotype.Controller) ")
	public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable{
		try {
		Object[] args = pjp.getArgs();
		System.out.println("args : " + Arrays.asList(args));
		//����ԭ�з���
		Object o = pjp.proceed();
		System.out.println("return : " + o);
		return o;
		}catch(Throwable e) {
			throw e;
		}
	}
}

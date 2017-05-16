package com.gsafety.advice;

import org.aspectj.lang.JoinPoint;

/**
 * 通知类，横切逻辑
 *
 */
public class Advices {
	public void advicesMath(JoinPoint jp){
		System.out.println("----------前置通知----------");
		System.out.println(jp.getSignature().getName());
	}

	public void advicesMath2(JoinPoint jp){
		System.out.println("----------最终通知----------");
	}
	public void around(JoinPoint jp){
		System.out.println("----------around最终通知----------");
	}
}

package com.yim.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

// around�� ����� advice�� �ݵ�� pjp�� input���� ������ �Ѵ�.
// around�� ���� ����Ŭ���� ó�� �ۿ�ȴ�.
public class AroundAdvice {
	public Object printLogAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE]");
		Object returnObj = pjp.proceed(); // �����ؾ��� ����Ʈ ��
		System.out.println("[AFTER]");
		return returnObj;
	}
}

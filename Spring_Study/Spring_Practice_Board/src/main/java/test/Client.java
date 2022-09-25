package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		// Spring �����̳ʸ� ���۽�ų���ֵ��� �ڵ��ۼ�
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		// Spring �����̳ʾ�, �� �� ��ü�� ������;�!
		// == Lookup
		Phone phone=(Phone)factory.getBean("iphone");
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		factory.close();
		
		/*
		BeanFactory bf=new BeanFactory();
		Phone phone=(Phone)bf.getBean(args[0]);
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		*/
	}
}

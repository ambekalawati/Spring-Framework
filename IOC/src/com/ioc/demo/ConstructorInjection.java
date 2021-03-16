package com.ioc.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjection {
	public static void main(String[] args) {
		ApplicationContext context =new ClassPathXmlApplicationContext("config-constructor.xml");
		Employee employee = context.getBean("emp",Employee.class);
//		System.out.println(employee);
		ApplicationContext context1 =new ClassPathXmlApplicationContext("config-constructor.xml");
		Employee employee1 = context.getBean("emp",Employee.class);
		System.out.println(employee.hashCode()+" "+employee1.hashCode());
		employee.setEmpId(111);
		employee1.setEmpId(222);
		System.out.println(employee);
		System.out.println(employee1);
	}
}

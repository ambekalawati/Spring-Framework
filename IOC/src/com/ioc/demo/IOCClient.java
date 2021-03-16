package com.ioc.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Q1. What is the difference b/w BeanFactory and ApplicationContext?
 * Q2. What is the difference b/w Setter Injection and Constructor Injection and which one is better?
 */
public class IOCClient {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Student stu = context.getBean("stu", Student.class);
		System.out.println(stu.getName() + " " + stu.getSid() + " " + stu.getPhoneNo());
		stu.getEmails().forEach(System.out::println);
		stu.getCourses().forEach(c -> System.out.println(c.getCourseId() + " " + c.getSubject()));
		stu.getSubjects().forEach(System.out::println);
		stu.getProfile().forEach((k, v) -> System.out.println(k + " " + v));
		stu.getMyProps().forEach((k, v) -> System.out.println(k + " " + v));
		System.out.println(stu.getAddress().getCity() + " " + stu.getAddress().getState());
	}
}

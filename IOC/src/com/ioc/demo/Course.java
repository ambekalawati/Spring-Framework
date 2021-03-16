package com.ioc.demo;

public class Course {
	private int courseId;
	private String subject;
	{
		System.out.println("course static");
	}

	public Course() {
		System.out.println("Course default constructor");
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
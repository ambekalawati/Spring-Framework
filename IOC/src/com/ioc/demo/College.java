package com.ioc.demo;

public class College {
	private Student student;
	private String name;
	{
		System.out.println("college static");
	}

	protected College() {
		System.out.println("default constructor from College");
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		System.out.println("container calling setStudent() method ");
		this.student = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setName() of college " + name);
	}

}

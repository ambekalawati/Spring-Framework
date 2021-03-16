package com.ioc.demo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
	private String name;
	private int sid;
	private Long phoneNo;
	private List<String> emails;
	private Set<String> subjects;
	private Map<Integer, String> profile;
	private Properties myProps;
	private Address address;
	private List<Course> courses;
	{
		System.out.println("student static");
	}

	public Student() {
		System.out.println("student constructor");
	}

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	public Map<Integer, String> getProfile() {
		return profile;
	}

	public void setProfile(Map<Integer, String> profile) {
		this.profile = profile;
	}

	public Properties getMyProps() {
		return myProps;
	}

	public void setMyProps(Properties myProps) {
		this.myProps = myProps;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
//	System.out.println("sid");
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
//	System.out.println("phone no");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
//	System.out.println("name");
	}
}
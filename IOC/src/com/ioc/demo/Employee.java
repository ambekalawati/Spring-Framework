package com.ioc.demo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Employee {
	private int empId;
	private String empName;
	private List<String> emails;
	private Address address;
	private List<Department> dept;
	private Properties myProps;
	private Set<String> projects;
	private Map<Integer, String> profile;

	public Employee(int empId, String empName, List<String> emails, Address address, List<Department> dept,
			Properties myProps, Set<String> projects, Map<Integer, String> profile) {
		this.empId = empId;
		this.empName = empName;
		this.emails = emails;
		this.address = address;
		this.dept = dept;
		this.myProps = myProps;
		this.projects = projects;
		this.profile = profile;
	}

	public Employee(int empId, String empName, List<String> emails, Address address, List<Department> dept,
			Properties myProps) {
		this.empId = empId;
		this.empName = empName;
		this.emails = emails;
		this.address = address;
		this.dept = dept;
		this.myProps = myProps;
	}

	public Employee(int empId, String empName, List<String> emails, Address address, List<Department> dept) {
		this.empId = empId;
		this.empName = empName;
		this.emails = emails;
		this.address = address;
		this.dept = dept;
	}

	public Employee(int empId, String empName, List<String> emails, Address address) {
		System.out.println("4 args cons");
		this.empId = empId;
		this.empName = empName;
		this.emails = emails;
		this.address = address;
	}

	public Employee(int empId, String empName, List<String> emails) {
		System.out.println("3 args cons");
		this.empId = empId;
		this.empName = empName;
		this.emails = emails;
	}

	public Employee(int empId, String empName) {
		System.out.println("2 args cons");
		this.empId = empId;
		this.empName = empName;
	}

	public Employee(List<String> emails) {
		System.out.println("1 args cons");
		this.emails = emails;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", emails=" + emails + ", address=" + address
				+ ", dept=" + dept + ", myProps=" + myProps + ", projects=" + projects + ", profile=" + profile + "]";
	}

}
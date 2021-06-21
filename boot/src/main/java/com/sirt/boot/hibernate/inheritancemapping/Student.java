package com.sirt.boot.hibernate.inheritancemapping;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clc_student")
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "stu_type",discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student {
	@Id
	@Column(name = "sid")
	private int sid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "total_fee")
	private double totalFee;

	public Student() {
		super();
	}

	public Student(int sid, String name, String city, String status, double totalFee) {
		super();
		this.sid = sid;
		this.name = name;
		this.city = city;
		this.status = status;
		this.totalFee = totalFee;
	}

	public Student(String name) {
		super();
		this.name = name;
	}
	
	
	
	
}

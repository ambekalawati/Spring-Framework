package com.sirt.boot.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3177268213526882633L;
	@Id
	@Column(name = "emp_no")
	private int employeeNo;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	@Temporal(TemporalType.DATE)
	@Column(name = "hire_date")
	private Date hireDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date birthDate;

}

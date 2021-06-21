package com.sirt.boot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
//	@Column(name = "sid")
	private int sid;
//	@Column(name = "firstName")
	private String firstName;
//	@Column(name = "lastName")
	private String lastName;
//	@Column(name = "state")
	private String state;
}
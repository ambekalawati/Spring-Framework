package com.sirt.boot.hibernate.inheritancemapping;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "week_end_student")
//@PrimaryKeyJoinColumn(name = "sid")
//@DiscriminatorValue("weekend_stu")          
public class WeekEndStudent extends CurrentStudent {
	@Column(name = "ws_company")
	private String wsCompany;

	@Column(name = "ws_email")
	private String wsEmail;

	@Column(name = "ws_ctc")
	private double wsCTC;
	
	public WeekEndStudent() {
		
	}

	public WeekEndStudent(int sid, String name, String city, String status, double totalFee, double feeBalance,
			String timimg, String branch, String wsCompany, String wsEmail, double wsCTC) {
		super(sid, name, city, status, totalFee, feeBalance, timimg, branch);
		this.wsCompany = wsCompany;
		this.wsEmail = wsEmail;
		this.wsCTC = wsCTC;
	}
	
	
}

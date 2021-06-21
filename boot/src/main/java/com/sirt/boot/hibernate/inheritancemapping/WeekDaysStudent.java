package com.sirt.boot.hibernate.inheritancemapping;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
@Table(name = "week_days_student")
//@PrimaryKeyJoinColumn(name = "sid")
//@DiscriminatorValue("weekday_stu")
@AttributeOverrides({
	@AttributeOverride(name = "name",column = @Column(name="name"))
})
public class WeekDaysStudent extends CurrentStudent {
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "percentage")
	private double percentage;
	
	@Column(name = "yop")
	private int yop;
	
	public WeekDaysStudent() {
		
	}

	public WeekDaysStudent(int sid, String name, String city, String status, double totalFee, double feeBalance,
			String timimg, String branch, String qualification, double percentage, int yop) {
		super(sid, name, city, status, totalFee, feeBalance, timimg, branch);
		this.qualification = qualification;
		this.percentage = percentage;
		this.yop = yop;
	}

	public WeekDaysStudent(String name, double feeBalance, String timimg, String branch, String qualification,
			double percentage, int yop) {
		super(name, feeBalance, timimg, branch);
		this.qualification = qualification;
		this.percentage = percentage;
		this.yop = yop;
	}
	
	
	
	
}

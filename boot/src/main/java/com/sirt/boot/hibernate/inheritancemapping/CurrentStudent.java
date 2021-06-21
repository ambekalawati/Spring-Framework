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
@Table(name = "current_student")
//@PrimaryKeyJoinColumn(name = "sid")
//@DiscriminatorValue("cur_stu")
@AttributeOverrides({
	@AttributeOverride(name = "name",column = @Column(name="name"))
})
public class CurrentStudent extends Student {
	@Column(name = "fee_balance")
	private double feeBalance;
	@Column(name = "timing")
	private String timimg;
	@Column(name = "branch")
	private String branch;

	public CurrentStudent() {
		super();
	}

	public CurrentStudent(int sid, String name, String city, String status, double totalFee, double feeBalance,
			String timimg, String branch) {
		super(sid, name, city, status, totalFee);
		this.feeBalance = feeBalance;
		this.timimg = timimg;
		this.branch = branch;
	}

	public CurrentStudent(String name, double feeBalance, String timimg, String branch) {
		super(name);
		this.feeBalance = feeBalance;
		this.timimg = timimg;
		this.branch = branch;
	}

	

}

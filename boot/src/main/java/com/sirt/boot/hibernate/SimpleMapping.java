package com.sirt.boot.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "simple_mapping")
public class SimpleMapping {
	@Id
	@Column(name="account_no")
	private int accountNo;
	@Column(name="account_balance")
	private double accountBalance;
	@Column(name="account_type")
	private String accountType;
	@Temporal(TemporalType.DATE)
	@Column(name="open_date")
	private Date openDate;

}

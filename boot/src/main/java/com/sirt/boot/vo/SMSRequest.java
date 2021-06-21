package com.sirt.boot.vo;

import lombok.Data;

@Data
public class SMSRequest {
	private String phoneNo;
	private String message;
}
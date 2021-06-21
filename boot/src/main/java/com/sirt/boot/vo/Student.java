package com.sirt.boot.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Student {
	@Min(message = "sid minimum length should be 3", value = 3l)
	private int sid;
	@NotBlank(message = "firstName should not be empty")
	private String firstName;
	@NotBlank(message = "lastName should not be empty")
	private String lastName;
	@NotBlank(message = "state should not be empty")
	private String state;
}
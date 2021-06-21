package com.sirt.boot.sms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {
	private String accountSid;
	private String authToken;
	private String trialNumber;

}
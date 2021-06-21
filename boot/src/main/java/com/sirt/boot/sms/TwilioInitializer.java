package com.sirt.boot.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class TwilioInitializer {

	private TwilioConfiguration twilioConfig;

	@Autowired
	public TwilioInitializer(TwilioConfiguration twilioConfig) {
		this.twilioConfig = twilioConfig;
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
		log.info("twilio initialized with accountSid {}", twilioConfig.getAccountSid());

	}

}
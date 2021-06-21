package com.sirt.boot.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sirt.boot.vo.SMSRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class SMSSenderImpl implements SMSSender {
	@Autowired
	private TwilioConfiguration twilioConfig;
	@Override
	public void sendSms(SMSRequest sms) {
		if(isPhoneNumberValid(sms.getPhoneNo())) {
			PhoneNumber to = new PhoneNumber(sms.getPhoneNo());
			PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
			String message = sms.getMessage();
			MessageCreator creator = Message.creator(to,from,message);
			creator.create();
			log.info("message has been send to {}",sms.getPhoneNo());
		}
		else {
			throw new IllegalArgumentException("Phone number "+sms.getPhoneNo()+" is not a valid number");
		}
	}
	private boolean isPhoneNumberValid(String phoneNo) {
//		to do implement phone validation
		return true;
	}

}

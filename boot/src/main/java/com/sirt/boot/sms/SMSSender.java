package com.sirt.boot.sms;

import com.sirt.boot.vo.SMSRequest;

public interface SMSSender {
	public void sendSms(SMSRequest sms);
}
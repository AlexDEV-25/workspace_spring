package vn.base.service;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageInterface {

	@Override
	public String sendMessagge() {
		// TODO Auto-generated method stub
		return "email sending ...... 12345";
	}

}

package vn.base;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageInterface {

	@Override
	public String sendMessagge() {
		// TODO Auto-generated method stub
		return "email sending ...... moi moi";
	}

}

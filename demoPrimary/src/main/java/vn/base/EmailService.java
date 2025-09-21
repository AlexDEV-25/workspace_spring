package vn.base;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailService implements MessageInterface {

	@Override
	public String sendMessagge() {
		// TODO Auto-generated method stub
		return "email sending ...... 12345";
	}

}

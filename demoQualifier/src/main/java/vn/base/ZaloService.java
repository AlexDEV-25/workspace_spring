package vn.base;

import org.springframework.stereotype.Component;

@Component
public class ZaloService implements MessageInterface {

	@Override
	public String sendMessagge() {
		// TODO Auto-generated method stub
		return "zalo sending ...... 12345";
	}

}

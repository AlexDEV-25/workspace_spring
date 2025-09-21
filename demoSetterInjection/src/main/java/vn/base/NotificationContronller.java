package vn.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationContronller {
	private MessageInterface email;

	@GetMapping("/send-email")
	public String sendEmail() {
		return this.email.sendMessagge();
	}

	public MessageInterface getEmail() {
		return email;
	}

	@Autowired
	public void setEmail(MessageInterface email) {
		this.email = email;
	}

}

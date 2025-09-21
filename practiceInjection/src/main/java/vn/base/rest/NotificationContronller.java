package vn.base.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.base.service.MessageInterface;

@RestController
public class NotificationContronller {
	private MessageInterface email;

	@Autowired
	public NotificationContronller(MessageInterface email) {
		this.email = email;
	}

	@GetMapping("/send-email")
	public String sendEmail() {
		return this.email.sendMessagge();
	}

	public MessageInterface getEmail() {
		return email;
	}

	// @Autowired
	public void setEmail(MessageInterface email) {
		this.email = email;
	}

}

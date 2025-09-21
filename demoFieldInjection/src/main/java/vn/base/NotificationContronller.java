package vn.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationContronller {
	@Autowired
	private MessageInterface email; // khong nen dung

	@GetMapping("/send-email")
	public String sendEmail() {
		return this.email.sendMessagge();
	}
}

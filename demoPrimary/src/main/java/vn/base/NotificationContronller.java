package vn.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationContronller {
	private MessageInterface service;

	@Autowired
	public NotificationContronller(MessageInterface service) {
		this.service = service;
	}

	@GetMapping("/send-service")
	public String sendService() {
		return this.service.sendMessagge();
	}

	public MessageInterface getService() {
		return service;
	}
}

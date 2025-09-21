package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private MessageInterface service;
	private MessageInterface service2;

	@Autowired
	public Controller(@Qualifier("zaloService") MessageInterface service,
			@Qualifier("zaloService") MessageInterface service2) {
		this.service = service;
		this.service2 = service2;
	}

	@GetMapping("/")
	public String sendContent() {
		return this.service.send();
	}

	@GetMapping("/check")
	public String check() {
		return "kiem tra bang nhau " + this.service.equals(service2);
	}
}

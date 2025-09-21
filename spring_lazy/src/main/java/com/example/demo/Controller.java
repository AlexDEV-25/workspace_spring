package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private MessageInterface service;

	@Autowired
	public Controller(@Qualifier("emailService") MessageInterface service) {
		this.service = service;

	}

	@GetMapping("/")
	public String sendContent() {
		return this.service.send();
	}

}

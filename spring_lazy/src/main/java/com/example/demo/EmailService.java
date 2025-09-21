package com.example.demo;

import org.springframework.stereotype.Component;

@Component

public class EmailService implements MessageInterface {
	public EmailService() {
		System.out.println("constructor cua Email");
	}

	@Override
	public String send() {
		return "email sending ... ";
	}

}

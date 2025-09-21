package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class EmailService implements MessageInterface {
	public EmailService() {
		System.out.println("constructor cua Email");
	}

	@Override
	public String send() {
		return "email sending ... ";
	}

}

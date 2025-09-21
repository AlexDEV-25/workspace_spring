package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// khong goi duoc phuong thuc Destroy
// khong can khi bao @lazy

public class EmailService implements MessageInterface {
	public EmailService() {
		System.out.println("constructor cua Email");
	}

	@Override
	public String send() {
		return "email sending ... ";
	}

}

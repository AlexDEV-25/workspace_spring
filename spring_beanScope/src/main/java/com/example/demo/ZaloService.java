package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Lazy
public class ZaloService implements MessageInterface {
	public ZaloService() {
		System.out.println("constructor cua zalo");
	}

	@Override
	public String send() {
		return "zalo sending ... ";
	}

}

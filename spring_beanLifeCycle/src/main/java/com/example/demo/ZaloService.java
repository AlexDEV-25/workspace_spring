package com.example.demo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class ZaloService implements MessageInterface {
	@PostConstruct
	public void init() {
		System.out.println("chay ngay sau khi khoi tao constructor " + getClass().getSimpleName());
	}

	@PreDestroy
	public void destroy() {
		System.out.println("chay ngay truoc khi destroy " + getClass().getSimpleName());
	}

	public ZaloService() {
		System.out.println("constructor cua zalo");
	}

	@Override
	public String send() {
		return "zalo sending ... ";
	}

}

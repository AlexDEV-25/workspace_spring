package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class ZaloService implements MessageInterface {
	public ZaloService() {
		System.out.println("constructor cua zalo");
	}

	@Override
	public String send() {
		return "zalo sending ... ";
	}

}

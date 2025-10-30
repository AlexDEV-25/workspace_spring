package com.example.app.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public double cong(double a, double b) {
		return a + b;
	}

	public double tru(double a, double b) {
		return a - b;
	}

	public double nhan(double a, double b) {
		return a * b;
	}

	public double chia(double a, double b) {
//		b = Double.parseDouble("ba");
		return a / b;
	}
}

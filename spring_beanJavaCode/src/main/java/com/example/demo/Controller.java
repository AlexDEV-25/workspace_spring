package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private Calculator myCanCalculator;

	@Autowired
	public Controller(@Qualifier("getCalculator") Calculator myCanCalculator) {
		this.myCanCalculator = myCanCalculator;
	}

	@GetMapping("/canbachai")
	public String tinhCanBacHai(@RequestParam("value") double x) {
		return "SQRT(" + x + ") = " + myCanCalculator.canBacHai(x);
	}

	@GetMapping("/binhphuong")
	public String binhPhuonhg(@RequestParam("value") double x) {
		return "POW(" + x + ",2) = " + myCanCalculator.binhPhuong(x);
	}

}

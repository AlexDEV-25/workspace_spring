package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/sinhvien")
public class Controller {
	public List<SinhVien> danhSach;

	@PostConstruct
	public void taoDanhSach() {
		danhSach = new ArrayList<SinhVien>();
		danhSach.add(new SinhVien(1, "duc", 21, "IT", 10));
		danhSach.add(new SinhVien(2, "d", 21, "IT", 10));
		danhSach.add(new SinhVien(3, "u", 21, "IT", 10));
		danhSach.add(new SinhVien(4, "c", 21, "IT", 10));
	}

	@GetMapping("/")
	public List<SinhVien> getDanhSach() {
		return danhSach;
	}

}

package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/{id}")
	public SinhVien getSinhVien(@PathVariable int id) {
		for (SinhVien sinhVien : danhSach) {
			if (sinhVien.getId() == id) {
				return sinhVien;
			}
		}
		return null;
	}

	@GetMapping("/index/{index}")
	public SinhVien getSinhVien2(@PathVariable int index) {

		SinhVien sinhVien = danhSach.get(index);

		return sinhVien;
	}

}

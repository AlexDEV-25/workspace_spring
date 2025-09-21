package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sinhvien")
public class SinhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ho_dem", length = 45)
	private String hoDem;
	@Column(name = "ten", length = 45)
	private String Ten;
	@Column(name = "email", length = 45)
	private String email;

	public SinhVien(String hoDem, String ten, String email) {
		this.hoDem = hoDem;
		Ten = ten;
		this.email = email;
	}

	public SinhVien() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", hoDem=" + hoDem + ", Ten=" + Ten + ", email=" + email + "]";
	}

}

package com.example.demo;

public class SinhVien {
	private int id;
	private String hoVaten;
	private int tuoi;
	private String nganhHoc;
	private double diemTB;

	public SinhVien(int id, String hoVaten, int tuoi, String nganhHoc, double diemTB) {
		this.id = id;
		this.hoVaten = hoVaten;
		this.tuoi = tuoi;
		this.nganhHoc = nganhHoc;
		this.diemTB = diemTB;
	}

	public SinhVien() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoVaten() {
		return hoVaten;
	}

	public void setHoVaten(String hoVaten) {
		this.hoVaten = hoVaten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getNganhHoc() {
		return nganhHoc;
	}

	public void setNganhHoc(String nganhHoc) {
		this.nganhHoc = nganhHoc;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

}

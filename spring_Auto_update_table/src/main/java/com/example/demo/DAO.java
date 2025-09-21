package com.example.demo;

import java.util.List;

public interface DAO {
	public void create(SinhVien sv);

	public SinhVien getByID(int id);

	public List<SinhVien> getAll();

	public List<SinhVien> getByName(String name);

	public SinhVien update(SinhVien sv);

	public int updateAllName(String name);

	public void delete(SinhVien sv);

	public void deleteByName(String s);
}

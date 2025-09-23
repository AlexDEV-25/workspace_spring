package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentInterfaceDAO {
	public List<Student> findAll();

	public Student getById(int id);

	public Student save(Student s);

	public Student saveAndFlush(Student s);

	public void deleteById(int id);
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	public List<Student> getAllStudent();

	public Student getStudentById(int id);

	public Student addStudent(Student s);

	public Student updateStudent(Student s);

	public void deleteStudentById(int id);

	// truy vấn bằng first_name
	public List<Student> findByFirstName(String first_name);

	// truy vấn bằng first_name and last_name
	public List<Student> findByFirstNameAndLastName(String first_name, String last_name);

	// truy vấn bằng first_name khác với giá trị tìm kiềm
	public List<Student> findByFirstNameNot(String first_name);

	// truy vấn bằng first_name khác với giá trị tìm kiềm dùng Query
	public List<Student> findByFirstNameNotQuery(String first_name);

	// truy vấn bằng first_name không chứa với giá trị tìm kiềm dùng Query
	public List<Student> findByFirstNameNotLikeQuery(String first_name);

}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	public List<Student> getAllStudent();

	public Student getStudentById(int id);

	public Student addStudent(Student s);

	public Student updateStudent(Student s);

	public void deleteStudentById(int id);
}

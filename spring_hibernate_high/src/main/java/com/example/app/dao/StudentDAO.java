package com.example.app.dao;

import com.example.app.entity.Student;

public interface StudentDAO {
	public void save(Student student);

	public Student findStudentById(int id);

	public Student findCourseAndStudentByStudentId(int id);
}

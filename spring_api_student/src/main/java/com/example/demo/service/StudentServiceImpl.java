package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentInterfaceDAO;
import com.example.demo.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentInterfaceDAO sid;

	@Autowired
	public StudentServiceImpl(StudentInterfaceDAO sid) {
		this.sid = sid;
	}

	@Override
	public List<Student> getAllStudent() {
		return this.sid.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return this.sid.getById(id);
	}

	@Override
	@Transactional
	public Student addStudent(Student s) {
		return sid.save(s);
	}

	@Override
	@Transactional
	public Student updateStudent(Student s) {
		return sid.saveAndFlush(s);
	}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
		sid.deleteById(id);
	}

}

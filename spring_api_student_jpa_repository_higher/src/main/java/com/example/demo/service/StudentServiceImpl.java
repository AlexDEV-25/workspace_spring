package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository sr;

	@Autowired
	public StudentServiceImpl(StudentRepository sr) {
		this.sr = sr;
	}

	@Override
	public List<Student> getAllStudent() {
		return this.sr.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return this.sr.getById(id);
	}

	@Override
	@Transactional
	public Student addStudent(Student s) {
		return sr.save(s);
	}

	@Override
	@Transactional
	public Student updateStudent(Student s) {
		return sr.saveAndFlush(s);
	}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
		sr.deleteById(id);
	}

	@Override
	public List<Student> findByFirstName(String first_name) {
		return sr.findByFirstName(first_name);
	}

	@Override
	public List<Student> findByFirstNameAndLastName(String first_name, String last_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByFirstNameNot(String first_name) {
		// TODO Auto-generated method stub
		return sr.findByFirstNameNot(first_name);
	}

	@Override
	public List<Student> findByFirstNameNotQuery(String first_name) {
		return sr.findByFirstNameNotQuery(first_name);
	}

	@Override
	public List<Student> findByFirstNameNotLikeQuery(String first_name) {
		return sr.findByFirstNameNotLikeQuery(first_name);
	}

}

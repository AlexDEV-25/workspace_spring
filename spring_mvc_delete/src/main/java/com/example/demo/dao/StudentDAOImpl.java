package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOImpl implements StudentInterfaceDAO {

	private EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Student> findAll() {
		String jpql = "SELECT s FROM Student s";
		return entityManager.createQuery(jpql, Student.class).getResultList();
	}

	@Override
	public Student getById(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public Student save(Student s) {
		entityManager.persist(s);
		return s;
	}

	@Override
	public Student saveAndFlush(Student s) {
		s = entityManager.merge(s);
		entityManager.flush();
		return s;
	}

	@Override
	public void deleteById(int id) {
		Student s = entityManager.find(Student.class, id);
		entityManager.remove(s);
	}

}

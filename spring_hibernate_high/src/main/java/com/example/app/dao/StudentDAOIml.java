package com.example.app.dao;

import org.springframework.stereotype.Repository;

import com.example.app.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOIml implements StudentDAO {
	private EntityManager entityManager;

	public StudentDAOIml(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findStudentById(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public Student findCourseAndStudentByStudentId(int id) {
		TypedQuery<Student> query = entityManager
				.createQuery("select c from Student c JOIN FETCH c.courses  where c.id=:x", Student.class);
		query.setParameter("x", id);
		Student student = query.getSingleResult();
		return student;
	}

}

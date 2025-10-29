package com.example.app.dao;

import org.springframework.stereotype.Repository;

import com.example.app.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CourseDAOIml implements CourseDAO {
	private EntityManager entityManager;

	public CourseDAOIml(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public void save(Course course) {
		entityManager.persist(course);
	}

}

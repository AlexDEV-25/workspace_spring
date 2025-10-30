package com.example.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.app.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

	@Override
	public List<Course> findCourseByTeacherId(int id) {
		TypedQuery<Course> query = entityManager.createQuery("from Course where teacher.id=:x", Course.class);
		query.setParameter("x", id);
		List<Course> courses = query.getResultList();
		return courses;
	}

}

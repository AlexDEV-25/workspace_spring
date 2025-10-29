package com.example.app.dao;

import org.springframework.stereotype.Repository;

import com.example.app.entity.TeacherDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class TeacherDetailDAOIml implements TeacherDetailDAO {
	private EntityManager entityManager;

	public TeacherDetailDAOIml(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public void save(TeacherDetail teacherDetail) {
		entityManager.persist(teacherDetail);
	}

}

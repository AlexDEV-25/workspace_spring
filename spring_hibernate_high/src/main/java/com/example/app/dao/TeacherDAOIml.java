package com.example.app.dao;

import org.springframework.stereotype.Repository;

import com.example.app.entity.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class TeacherDAOIml implements TeacherDAO {
	private EntityManager entityManager;

	public TeacherDAOIml(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public void save(Teacher teacher) {
		entityManager.persist(teacher);
	}

	@Override
	public Teacher findTeacherById(int id) {
		return entityManager.find(Teacher.class, id);
	}

	@Override
	public void deleteTeacherById(int id) {
		Teacher teacher = entityManager.find(Teacher.class, id);
		if (teacher != null) {
			entityManager.remove(teacher);
		}

	}

	@Transactional
	@Override
	public void update(Teacher teacher) {
		entityManager.merge(teacher);
		entityManager.flush();

	}

	@Override
	public Teacher findTeacherByIdJoinFetch(int id) {
		TypedQuery<Teacher> query = entityManager.createQuery(
				"select t from Teacher t JOIN FETCH t.courses JOIN FETCH t.teacherDetail where t.id=:x", Teacher.class);
		query.setParameter("x", id);
		Teacher teacher = query.getSingleResult();
		return teacher;
	}

}

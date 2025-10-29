package com.example.app.dao;

import com.example.app.entity.Teacher;

public interface TeacherDAO {
	public void save(Teacher teacher);

	public Teacher findTeacherById(int id);

	public void deleteTeacherById(int id);

	public void update(Teacher teacher);
}

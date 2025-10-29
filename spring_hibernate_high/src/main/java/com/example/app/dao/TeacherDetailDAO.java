package com.example.app.dao;

import com.example.app.entity.TeacherDetail;

public interface TeacherDetailDAO {
	public void save(TeacherDetail teacherDetail);

	public TeacherDetail findTeacherDetailById(int id);

	public void deleteTeacherDetailById(int id);
}

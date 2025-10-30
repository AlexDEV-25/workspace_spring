package com.example.app.dao;

import java.util.List;

import com.example.app.entity.Course;

public interface CourseDAO {
	public void save(Course course);

	public List<Course> findCourseByTeacherId(int id);
}

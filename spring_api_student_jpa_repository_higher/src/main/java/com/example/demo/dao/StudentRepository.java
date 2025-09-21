package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	// truy vấn bằng first_name
	public List<Student> findByFirstName(String first_name);

	// truy vấn bằng first_name and last_name
	public List<Student> findByFirstNameAndLastName(String first_name, String last_name);

	// truy vấn bằng first_name khác với giá trị tìm kiềm
	public List<Student> findByFirstNameNot(String first_name);

	// truy vấn bằng first_name khác với giá trị tìm kiềm dùng Query
	@Query("SELECT s FROM Student s WHERE s.firstName<>?1")
	public List<Student> findByFirstNameNotQuery(String first_name);

	// truy vấn bằng first_name không chứa với giá trị tìm kiềm dùng Query
	@Query("SELECT s FROM Student s WHERE s.firstName NOT Like ?1")
	public List<Student> findByFirstNameNotLikeQuery(String first_name);
}

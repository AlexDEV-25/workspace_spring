package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	private StudentService ss;

	@Autowired
	public StudentController(StudentService ss) {
		this.ss = ss;
	}

	@GetMapping
	public List<Student> getAllStudent() {
		return this.ss.getAllStudent();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student s = ss.getStudentById(id);
		if (s != null) {
			return ResponseEntity.ok(s);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Student> addStudent(@RequestBody Student s) {
		s.setId(0);// khi lấy dữ liệu dù có truyền id thì nó cũng không được tính
		Student student = ss.addStudent(s);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student s) {
		Student studentExist = ss.getStudentById(id);
		if (studentExist != null) {
			studentExist.setFirst_name(s.getFirst_name());
			studentExist.setLast_name(s.getLast_name());
			studentExist.setEmail(s.getEmail());
			Student student = ss.updateStudent(studentExist);
			return ResponseEntity.ok(student);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
		Student studentExist = ss.getStudentById(id);
		if (studentExist != null) {
			ss.deleteStudentById(id);
			return ResponseEntity.ok().build();
		} else {
			throw new Error("khong co gi de xoa ay oi");
		}
	}
}

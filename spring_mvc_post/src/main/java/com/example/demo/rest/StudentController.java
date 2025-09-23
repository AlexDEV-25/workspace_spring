package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	private StudentService ss;

	@Autowired
	public StudentController(StudentService ss) {
		this.ss = ss;
	}

	@GetMapping("/list")
	public String listAll(Model model) {
		List<Student> students = ss.getAllStudent();
		model.addAttribute("students", students);
		return "student/students";
	}

	@GetMapping("/create")
	public String creat(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student/students_form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("student") Student s) {
		ss.addStudent(s);
		return "redirect:/students/list";
	}

}

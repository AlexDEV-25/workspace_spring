package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		ss.updateStudent(s);
		return "redirect:/students/list";
	}

	@GetMapping("/update")
	public String update(@RequestParam("id") Integer id, Model model) {
		Student student = ss.getStudentById(id);
		model.addAttribute("student", student);
		return "student/students_form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id, Model model) {
		ss.deleteStudentById(id);
		return "redirect:/students/list";
	}

}

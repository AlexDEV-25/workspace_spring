package vn.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class WebController {

	@Autowired
	private StudentRepository studentRepository;

	// Hiển thị danh sách
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "students";
	}

	// Form thêm
	@GetMapping("/new")
	public String showAddForm(Model model) {
		model.addAttribute("student", new Student());
		return "add-student";
	}

	@PostMapping
	public String save(@ModelAttribute Student student) {
		studentRepository.save(student);
		return "redirect:/students";
	}

	// Form sửa
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentRepository.findById(id).orElseThrow());
		return "edit-student";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Student student) {
		student.setId(id);
		studentRepository.save(student);
		return "redirect:/students";
	}

	// Xóa
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		studentRepository.deleteById(id);
		return "redirect:/students";
	}
}

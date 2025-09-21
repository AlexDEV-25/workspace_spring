package vn.base;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

	@Autowired
	private StudentService service;

	// Lấy danh sách sinh viên (có tìm kiếm theo keyword)
	@GetMapping
	public List<Student> list(@RequestParam(value = "keyword", required = false) String keyword) {
		if (keyword != null && !keyword.trim().isEmpty()) {
			return service.search(keyword.trim());
		}
		return service.getAll();
	}

	// Lấy 1 sinh viên theo id
	@GetMapping("/{id}")
	public ResponseEntity<Student> getOne(@PathVariable Long id) {
		Optional<Student> student = service.findById(id);
		return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// Thêm sinh viên
	@PostMapping
	public ResponseEntity<Student> create(@RequestBody Student student) {
		Student saved = service.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	// Sửa sinh viên
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
		Optional<Student> exist = service.findById(id);
		if (exist.isPresent()) {
			student.setId(id); // giữ nguyên id cũ
			return ResponseEntity.ok(service.save(student));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Xóa sinh viên
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (service.findById(id).isPresent()) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}

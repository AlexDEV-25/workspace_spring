package vn.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	public List<Student> getAll() {
		return repo.findAll();
	}

	public Optional<Student> findById(Long id) {
		return repo.findById(id);
	}

	public Student save(Student student) {
		return repo.save(student);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public List<Student> search(String keyword) {
		return repo.findByFullNameContainingIgnoreCase(keyword);
	}
}

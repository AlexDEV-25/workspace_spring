package vn.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

	// Tìm theo mã hoặc tên (có thể nhập một từ khóa bất kỳ)
	@Query("SELECT s FROM Student s " + "WHERE LOWER(s.studentCode) LIKE LOWER(CONCAT('%', :keyword, '%')) "
			+ "   OR LOWER(s.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Student> searchByCodeOrName(@Param("keyword") String keyword);

	List<Student> findByStudentCodeContainingIgnoreCase(String code);

	// tìm theo tên sinh viên gần đúng
	List<Student> findByFullNameContainingIgnoreCase(String name);

	// tìm theo lớp
	List<Student> findByClassNameContainingIgnoreCase(String className);

	// tìm theo khoa
	List<Student> findByDepartmentContainingIgnoreCase(String department);

}

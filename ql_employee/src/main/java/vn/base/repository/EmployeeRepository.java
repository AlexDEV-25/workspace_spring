package vn.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.base.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

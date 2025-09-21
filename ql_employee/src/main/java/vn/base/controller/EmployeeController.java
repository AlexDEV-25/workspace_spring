package vn.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.base.model.Employee;
import vn.base.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/duc/")
public class EmployeeController {
	private EmployeeRepository employeeRepository;

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping("/employees")
	public List<Employee> getallEmployees() {
		return employeeRepository.findAll();
	}

}

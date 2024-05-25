package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.spring.dao.EmployeeRepository;
import com.spring.entity.Department;
import com.spring.entity.Employee;
import com.spring.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServices {
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Transactional
	public Employee updateEmployee(Long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));
		employee.setName(employeeDetails.getName());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		employee.setSalary(employeeDetails.getSalary());
		employee.setAddress(employeeDetails.getAddress());
		employee.setRole(employeeDetails.getRole());
		employee.setJoiningDate(employeeDetails.getJoiningDate());
		employee.setYearlyBonusPercentage(employeeDetails.getYearlyBonusPercentage());
		employee.setDepartment(employeeDetails.getDepartment());
		employee.setReportingManager(employeeDetails.getReportingManager());
		return employeeRepository.save(employee);
	}

	@Transactional
	public Page<Employee> getAllEmployees(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

	@Transactional
	public Page<Employee> getAllEmployees() {
		return getAllEmployees(Pageable.unpaged());
	}

	@Transactional
	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
		return employeeRepository.findByDepartmentId(departmentId);
	}

	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));
		employeeRepository.delete(employee);
	}

	@Transactional
	public Employee updateEmployeeDepartment(Long id, Long departmentId) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));
		Department department = new Department();
		employee.setDepartment(department);
		return employeeRepository.save(employee);
	}

}

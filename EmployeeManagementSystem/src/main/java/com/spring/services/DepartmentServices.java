package com.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.dao.DepartmentRepository;
import com.spring.dao.EmployeeRepository;
import com.spring.entity.Department;
import com.spring.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class DepartmentServices {
	@Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional
    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + id));

        department.setName(departmentDetails.getName());
        department.setCreationDate(departmentDetails.getCreationDate());
        department.setDepartmentHead(departmentDetails.getDepartmentHead());

        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + id));

        if (!employeeRepository.findByDepartmentId(id).isEmpty()) {
            throw new RuntimeException("Cannot delete department with employees");
        }

        departmentRepository.delete(department);
    }

    @Transactional
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Transactional
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + id));
    }

    @Transactional
    public Department getDepartmentWithEmployees(Long id) {
        Department department = getDepartmentById(id);
        department.setEmployees(employeeRepository.findByDepartmentId(id));
        return department;
    }

}

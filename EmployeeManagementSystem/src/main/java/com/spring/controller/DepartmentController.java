package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.entity.Department;
import com.spring.services.DepartmentServices;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	 @Autowired
	    private DepartmentServices departmentService;

	    @PostMapping
	    public Department createDepartment(@RequestBody Department department) {
	        return departmentService.createDepartment(department);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
	        return ResponseEntity.ok(departmentService.updateDepartment(id, departmentDetails));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
	        departmentService.deleteDepartment(id);
	        return ResponseEntity.ok().build();
	    }

	    @GetMapping
	    public Page<Department> getAllDepartments(Pageable pageable) {
	        return departmentService.getAllDepartments(pageable);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id, @RequestParam(required = false) String expand) {
	        if ("employee".equals(expand)) {
	            return ResponseEntity.ok(departmentService.getDepartmentWithEmployees(id));
	        } else {
	            return ResponseEntity.ok(departmentService.getDepartmentById(id));
	        }
	    }

}

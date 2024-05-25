package com.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Department;
@Repository
public interface DepartmentRepository
		extends PagingAndSortingRepository<Department, Long>, CrudRepository<Department, Long> {

}

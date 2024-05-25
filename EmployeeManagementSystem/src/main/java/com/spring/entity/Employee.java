package com.spring.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate dateOfBirth;
	private double salary;
	private String address;
	private String role;
	private LocalDate joiningDate;
	private double yearlyBonusPercentage;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reporting_manager_id")
	private Employee reportingManager;

	public Employee() {
		super();

	}

	public Employee(String name, LocalDate dateOfBirth, double salary, String address, String role,
			LocalDate joiningDate, double yearlyBonusPercentage, Department department, Employee reportingManager) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.address = address;
		this.role = role;
		this.joiningDate = joiningDate;
		this.yearlyBonusPercentage = yearlyBonusPercentage;
		this.department = department;
		this.reportingManager = reportingManager;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public double getYearlyBonusPercentage() {
		return yearlyBonusPercentage;
	}

	public void setYearlyBonusPercentage(double yearlyBonusPercentage) {
		this.yearlyBonusPercentage = yearlyBonusPercentage;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(Employee reportingManager) {
		this.reportingManager = reportingManager;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary
				+ ", address=" + address + ", role=" + role + ", joiningDate=" + joiningDate
				+ ", yearlyBonusPercentage=" + yearlyBonusPercentage + ", department=" + department
				+ ", reportingManager=" + reportingManager + "]";
	}

}

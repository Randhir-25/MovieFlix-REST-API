package com.shubhamyeole.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shubhamyeole.entity.Employee;

@Repository
public interface EmployeeRepository {
	public List<Employee> findAll();
	public Employee findOne(String id);
	public Employee create(Employee emp);
	public void delete(Employee emp);
	public Employee findByEmail(String email);
	Employee update(Employee emp);
}

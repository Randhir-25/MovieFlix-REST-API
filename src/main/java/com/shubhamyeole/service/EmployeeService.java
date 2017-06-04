package com.shubhamyeole.service;

import java.util.List;
import com.shubhamyeole.entity.Employee;
public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findOne(String id);
	public Employee create(Employee emp);
	public Employee update(Employee emp);
	public void delete(String id);
}

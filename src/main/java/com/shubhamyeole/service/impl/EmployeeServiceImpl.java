package com.shubhamyeole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shubhamyeole.entity.Employee;
import com.shubhamyeole.exception.EntityAlreadyExistException;
import com.shubhamyeole.exception.EntityNotFoundException;
import com.shubhamyeole.repository.EmployeeRepository;
import com.shubhamyeole.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee findOne(String id) {
		Employee emp = repository.findOne(id);
		if(emp==null){
			throw new EntityNotFoundException("Employee with "+id+" not found");
		}
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public Employee create(Employee emp) {
		Employee exist = repository.findByEmail(emp.getEmail());
		if(exist!=null){
			throw new EntityAlreadyExistException("Employee with "+emp.getEmail()+" is already in use");
		}
		return repository.create(emp);
	}

	@Override
	@Transactional
	public Employee update(Employee emp) {
		Employee exist = repository.findOne(emp.getId());
		if(exist!=null){
			throw new EntityNotFoundException("Employee with "+emp.getId()+" not found");
		}
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Employee exist = repository.findOne(id);
		if(exist!=null){
			throw new EntityNotFoundException("Employee with "+id+" not found");
		}
		repository.delete(exist);
	}

}

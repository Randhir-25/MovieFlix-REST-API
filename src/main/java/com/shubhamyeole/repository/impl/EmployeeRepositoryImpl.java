package com.shubhamyeole.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shubhamyeole.entity.Employee;
import com.shubhamyeole.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findOne(String id) {
		return em.find(Employee.class, id);
	}

	@Override
	public Employee create(Employee emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public void delete(Employee emp) {
		em.remove(emp);
	}

	@Override
	public Employee findByEmail(String email) {
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findByEmail", Employee.class);
		query.setParameter("pEmail", email);
		List<Employee> emp = query.getResultList();
		
		if(emp!=null && emp.size()==1) return emp.get(0);
		return null;
	}


	@Override
	public Employee update(Employee emp) {
		return em.merge(emp);
	}

}

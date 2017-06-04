package com.shubhamyeole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubhamyeole.entity.Employee;
import com.shubhamyeole.service.EmployeeService;

//@RestController // is combination of @Controller and @ResponseBody
@Controller
@ResponseBody
@RequestMapping(path="/employees")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Employee> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee findOne(@PathVariable("id") String empId){
		return service.findOne(empId);

	}
	
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee create(@RequestBody Employee emp){
		return service.create(emp);

	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee update(@PathVariable("id") String empId, @RequestBody Employee emp){
		return service.update(emp);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id") String empId){

	}
}

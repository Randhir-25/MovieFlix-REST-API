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
import com.shubhamyeole.entity.Movie;
import com.shubhamyeole.entity.MovieCast;
import com.shubhamyeole.entity.MovieTemp;
import com.shubhamyeole.entity.User;
import com.shubhamyeole.service.MovieCastService;
import com.shubhamyeole.service.MovieService;
import com.shubhamyeole.service.UserService;

//@RestController // is combination of @Controller and @ResponseBody
@Controller
@ResponseBody
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	UserService u_service;

	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		return u_service.findAll();
	}

	//	@RequestMapping(method=RequestMethod.GET, path="{id}" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	//	public Employee findOne(@PathVariable("id") String empId){
	//		return m_service.findOne(empId);
	//
	//	}
//	MovieTemp
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user){
		Movie mov = new Movie();
		u_service.create(user);
		return user;
	}


	//	@RequestMapping(method=RequestMethod.POST)
	//	public String create(@RequestParam(required=false, value="fname") String fname){
	//		System.out.println(fname);
	//		return fname;
	//	}

	//	@RequestMapping(method=RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	//	public Employee update(@PathVariable("id") String empId, @RequestBody Employee emp){
	//		return m_service.update(emp);
	//	}

	//	@RequestMapping(method=RequestMethod.DELETE, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	//	public void delete(@PathVariable("id") String empId){
	//
	//	}
}

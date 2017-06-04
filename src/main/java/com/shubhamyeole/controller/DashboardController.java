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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shubhamyeole.entity.Employee;
import com.shubhamyeole.entity.Genre;
import com.shubhamyeole.entity.Movie;
import com.shubhamyeole.service.EmployeeService;
import com.shubhamyeole.service.GenreService;
import com.shubhamyeole.service.LanguageService;
import com.shubhamyeole.service.MovieCastService;
import com.shubhamyeole.service.MovieService;

//@RestController // is combination of @Controller and @ResponseBody
@Controller
@ResponseBody
@RequestMapping(path="/dashboard")
public class DashboardController {

	@Autowired
	MovieService m_service;

	@Autowired
	GenreService g_service;

	@Autowired
	LanguageService l_service;

	@Autowired
	MovieCastService mc_service;

	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView findAll(){
		ModelAndView mav = new ModelAndView("../index.html");
		mav.addObject("Hello", m_service.findAll());
		mav.addObject(m_service.findAll());
		return mav;
	}

	//	@RequestMapping(method=RequestMethod.GET, path="{id}" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	//	public Employee findOne(@PathVariable("id") String empId){
	//		return m_service.findOne(empId);
	//
	//	}

	@RequestMapping(method=RequestMethod.POST)
	public Movie create(@RequestBody Movie movie){
		System.out.println(movie.getTitle());
		return movie;
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

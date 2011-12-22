package com.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping ("/greet")
	public ModelAndView greet() {
		return new ModelAndView("index", "name", "greet1");
	}
	
	@RequestMapping ("/greet2")
	public ModelAndView greet2() {
		return new ModelAndView("index","name", "greet2");
	}
	
	@RequestMapping("/login")
	public ModelAndView helloWorld(HttpServletRequest request){
		String name = request.getParameter("uname");
		System.out.println(name);
		return new ModelAndView("index","name", name);
	}
}

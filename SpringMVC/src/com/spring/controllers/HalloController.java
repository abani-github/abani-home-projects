package com.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springapp.domain.Product;


@Controller
public class HalloController {
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld(HttpServletRequest request){
		System.out.println("HalloController.helloWorld() " + request.getRemoteHost());
		return new ModelAndView("index","name", "hello");
	}
	@RequestMapping(value="/show", headers="Accept=application/xml, application/json")
	public @ResponseBody Product getProduct () {
		return new Product("Almond Oil",55.00);
	}
}

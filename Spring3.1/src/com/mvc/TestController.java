package com.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.domain.products.Product;
import com.service.products.ProductsService;

@Controller
public class TestController {

	@Autowired ProductsService productsService;
	
	@RequestMapping("/listall")
	public ModelAndView listAll (){
		List<Product> products = productsService.listAll();
		System.out.println("TestController.listAll() " + products);
		return new ModelAndView("products","products",products);
	}
	
	public ModelAndView delete(){
		return null;
	}
}

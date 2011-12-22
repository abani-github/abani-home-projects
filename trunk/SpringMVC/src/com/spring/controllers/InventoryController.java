package com.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springapp.domain.Product;
import springapp.service.ProductManager;

@Controller
public class InventoryController {
	@Autowired
	private ProductManager productManager;
	
	@RequestMapping ("/listAll")
	public ModelAndView listAllProducts (HttpServletRequest request, HttpServletResponse response) {
		List<Product> products = this.productManager.getProducts();
		System.out.println("InventoryController.listAllProducts() " + products);
		return new ModelAndView("products", "products", products);
	}
	@RequestMapping ("/list/{desc}")
	public  ModelAndView getProduct (HttpServletRequest request,
											@PathVariable String desc ){
		System.out.println("InventoryController.listAllProducts() desc " + desc);
		List<Product> products = new ArrayList<Product>(1);
		products.add(this.productManager.getProduct(desc));
		return new ModelAndView("products", "products", products);
	}
	
	/*public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }*/
}	

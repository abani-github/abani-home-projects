/**
 * 
 */
package com.service.products;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.domain.products.Product;

/**
 * @author CHIKI
 *
 */
public class ProductsImpl implements ProductsService {

	/* (non-Javadoc)
	 * @see com.service.products.ProductsService#listAll()
	 */
	@Override
	@Cacheable (value="products")
	public List<Product> listAll() {
		System.out.println("ProductsImpl.listAll() calling start");
		List<Product> products = new ArrayList<Product>(3);
		Product p1 = new Product(1,"Soap","Lux");
		Product p2 = new Product(2,"Soap","Cinthol");
		Product p3 = new Product(5,"Soap","Lirol");
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		System.out.println("ProductsImpl.listAll() calling end");
		return products;
	}

}

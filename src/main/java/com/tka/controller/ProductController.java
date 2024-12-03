package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entities.Category;
import com.tka.entities.Product;
import com.tka.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/products")
	public String createProduct(@RequestBody Product product) {
		int status = productService.createProduct(product);
		switch (status) {
		case 1: {
			return "Product Added Successfully";
			
		}
		case 2: {
			return "Product Already Exists";
			
		}
		case 3: {
			return "Something went wrong";
			
		}
		case 4:{
			return "Unknown category";
		}
		default:
			return "";
		}
	}
	
	@GetMapping("products/{id}")
	public Object getProductById(@PathVariable long id) {
		
		Product product = productService.getProductById(id);
		return product;
	}
	
	
	 @GetMapping("/products")
	    public List<Product> getProducts(@RequestParam(defaultValue = "1") int page) {
	        return productService.getProductsByPage(page);
	    }
	 
	 @PutMapping("/products/{id}")
		public Object updateProduct(@PathVariable long id, @RequestBody Product product) {

			Product updateProduct = productService.updateProduct(id, product);
			if (updateProduct != null) {
				return updateProduct;
			} else {
				return null;
			}
		}
	 
	 @DeleteMapping("/products/{id}")
		public String deleteProduct(@PathVariable long id) {
		int status = productService.deleteProduct(id);
		
		switch (status) {
		case 1: {
			return "Product Deleted Successfully";
			
		}
		case 2: {
			return "Product Not Exists";
			
		}
		case 3: {
			return "Something went wrong";
			
		}
		default:
			return "";
		}
	}
}
package com.tka.service;

import java.util.List;
import com.tka.entities.Product;

public interface ProductService {

	public int createProduct(Product product);
	public Product updateProduct(long id,Product product);
	public Product getProductById(long id);
	public int deleteProduct(long id);
	
	 public List<Product> getProductsByPage(int pageNumber);

}

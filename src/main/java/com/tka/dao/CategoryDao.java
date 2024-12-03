package com.tka.dao;

import java.util.List; 
import com.tka.entities.Category;
import com.tka.entities.Product;

public interface CategoryDao {
	public int createCategory(Category category);
	public Category getCategoryById(long id);
	public int deleteCategory(long categoryId);
	public List<Product> getCategoriesByPage(int page);
	
	public Category updateCategory(long id,Category category);

}

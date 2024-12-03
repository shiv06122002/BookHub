package com.tka.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.CategoryDao;
import com.tka.entities.Category;
import com.tka.entities.Product;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	public int createCategory(Category category) {
		int status = categoryDao.createCategory(category);
		return status;
	}
	
	@Override
	public Category updateCategory(long id, Category category) {

		return categoryDao.updateCategory(id, category);
	}

	@Override
	public int deleteCategory(long categoryId) {
		
		int status = categoryDao.deleteCategory(categoryId);
		return status;
	}
	
	@Override
	public Category getCategoryById(long id) {
		Category category = categoryDao.getCategoryById(id);
		return category;
		
	}

	@Override
	public List<Product> getCategoriesByPage(int page) {
		return categoryDao.getCategoriesByPage(page);
	}
}

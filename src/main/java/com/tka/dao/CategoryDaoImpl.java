package com.tka.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.exceptions.ResourceNotFoundException;

import com.tka.entities.Category;
import com.tka.entities.Product;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private static final int PAGE_SIZE = 2;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createCategory(Category category) {

		try {
			Session session = sessionFactory.openSession();
			Category dbCategory = session.get(Category.class, category.getCategoryId());
			if (dbCategory == null) {
				session.save(category);
				session.beginTransaction().commit();
				return 1;
			} else {
				return 2;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

	
	@Override
	public Category updateCategory(long id, Category category) {

		try {
			Session session = sessionFactory.openSession();
			Category dbCategory = session.get(Category.class, id);
			if(dbCategory!=null) {
				
				dbCategory.setCategoryName(category.getCategoryName());
				session.update(dbCategory);
				session.beginTransaction().commit();
				return dbCategory;
				
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
		
	}

	@Override
	public int deleteCategory(long categoryId) {
		try {
			Session session = sessionFactory.openSession();
			
			Category dbCategory = session.get(Category.class,categoryId);
			
			if(dbCategory!=null) {
				session.delete(dbCategory);
				session.beginTransaction().commit();
				return 1;
			}
			else {
				return 2;
			}
			
		}
		 catch(Exception e) {
			e.printStackTrace();
			return 3;
		}
		
	}


	@Override
	public Category getCategoryById(long id) {
		Category category = null;
		try {
			Session session = sessionFactory.openSession();
			category=session.get(Category.class, id);
			if(category!=null) {
				return category;
			}else {
				throw new ResourceNotFoundException("Category not exists for id = " +id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("Category not exists for id = " +id);
		}
		
	}


	@Override
	public List<Product> getCategoriesByPage(int pageNumber) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Product p ORDER BY p.pId";

			Query<Product> query = session.createQuery(hql, Product.class);

			int firstResult = (pageNumber - 1) * PAGE_SIZE;
			query.setFirstResult(firstResult);
			query.setMaxResults(PAGE_SIZE);

			return query.list();
		} finally {
			session.close();

		}
	}
}

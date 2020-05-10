package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOImplementationTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		
		context.refresh();
		
		CategoryDAO categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
		//Category category = new Category();
		Category category = categoryDAO.getCategory(2);
		category.setCategoryName("MI");
		category.setCategoryDesc("all models");
		
		//categoryDAO.addCategory(category);
		categoryDAO.updateCategory(category);



	}

}

package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTest {

	static CategoryDAO categorydao; 
	@BeforeClass
	public static void intialize(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		
		context.refresh();
		
		categorydao = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	@Test
	public void addCategoryTest(){
		Category category = new Category();
		category.setCategoryDesc("All mobiles are available");
		category.setCategoryName("Mobile");
		assertTrue("problem in adding category:",categorydao.addCategory(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest(){
		Category category = categorydao.getCategory(10);
	
		category.setCategoryDesc("all model mobile");
		category.setCategoryName("Redmi");
		assertTrue("problem in updating category:",categorydao.updateCategory(category));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest(){
		Category category = categorydao.getCategory(12);
		category.setCategoryName("All mobiles are available");
		assertTrue("problem in deleting category:",categorydao.deleteCategory(category));
	}
	@Ignore
	@Test
	public void listCategoryTest(){
		
		List<Category> listcategory =categorydao.listCategory();
		assertNotNull("problem in listing:",listcategory);
		
		for(Category category:listcategory){
			System.out.print(category.getCategoryID()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc());
		}
		
		
		
		
		
	}


}

package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDAOTest {

	static UserDAO userdao; 
	
	@BeforeClass
	public static void intialize(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userdao = (UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void registerUserTest(){
		
		User user = new User();
		user.setCustomerName("Niit");
		user.setEmailID("niit@gmail.com");
		user.setEnabled("enabled");
		user.setMobileNo("12345");
		user.setPassword("admin");
		user.setRole("admin");
		user.setUserName("admin");
		assertTrue("error in registering user:",userdao.registerUser(user));
	}

}

package com.niit.shopcart.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopcart.dao.UserDAO;
import com.niit.shopcart.model.User;

public class TestBackend {
static AnnotationConfigApplicationContext context;
	
	public TestBackend()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopingcart");
		context.refresh();
	}
	
	public static void createUser(User user)
	{
		
		UserDAO  userDAO =  (UserDAO) context.getBean("userDAO");
		userDAO.saveOrUpdate(user);
	}
}
		


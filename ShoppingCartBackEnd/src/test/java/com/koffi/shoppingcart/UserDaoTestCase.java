package com.koffi.shoppingcart;

import static org.junit.Assert.assertEquals;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.koffi.shoppingcart.dao.UserDAO;
import com.koffi.shoppingcart.domain.User;

public class UserDaoTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static UserDAO userDAO;
	
	@Autowired 
	private static User user;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.koffi");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
		user = (User)context.getBean("user");
	}
	
	@Test
	public void saveUserTestCase()
	{
		user.setEmailID("m@gmail.com");
		user.setAddress("AAAAAA");
		user.setMobile("875218557");
		user.setName("Anil");
		user.setRegisteredDate(new Date());
		user.setPassword("111");
		user.setRole("USER_ROLE");
		boolean status = userDAO.save(user);
		assertEquals("save user", true, status);
	}
	
	
	@Test
	public void updateUserTestCase()
	{
		user.setEmailID("a@gmail.com");
		user.setMobile("999999999");
		user.setName("Jean Claude");
		user.setPassword("123");
		user.setRegisteredDate(new Date());
		user.setRole("Admin");
		boolean status = userDAO.update(user);
		assertEquals("update test case", true,status );
		System.out.println("Success.........");
	}
	
	/*
	@Test
	public void deleteUserSuccessTestCase()
	{
		boolean status =	userDAO.delete("john@gmail.com");
		assertEquals("delete user succss test case" , true, status);
	
	}
	
	@Test
	public void deleteUserFailureTestCase()
	{
		boolean status =	userDAO.delete("arpith@gmail.com");
		assertEquals("delete user failure test case" , false, status);
	
	}
	
	@Test
	public void getUserSuccessTestCase()
	{
		
		user= userDAO.get("koffi@gmail.com");
		assertNotNull("get user test case", user);
	}
	
	@Test
	public void getUserFailureTestCase()
	{
		
		user= userDAO.get("jaya@gmail.com");
		assertNull("get user test case", user);
	}
	
	@Test
	public void getAllUsersTestCase()
	{
		List<User>	users = userDAO.list();
		assertEquals("get all usres " , 6, users.size() );
	
	}
	
	@Test
	public void validateCredentailsTestCase()
	{
		user = 	userDAO.validate("koffi@gmail.com", "123");
		assertNotNull("Validate test case",user );
	
	}*/
}


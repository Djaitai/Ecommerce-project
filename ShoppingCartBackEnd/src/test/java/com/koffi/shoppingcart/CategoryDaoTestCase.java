package com.koffi.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.koffi.shoppingcart.dao.CategoryDAO;
import com.koffi.shoppingcart.domain.Category;

public class CategoryDaoTestCase {
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired 
	private static Category category;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.koffi");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		category = (Category)context.getBean("category");
	}
	
	@Test
	public void saveCategoryTestCase()
	{
		category.setCategory_Id("Cat_001");
		category.setCategory_description("Electronic category");
		category.setCategory_name("Electronic");
		boolean status = categoryDAO.save(category);
		assertEquals("save category",true, status);
	}
	
	@Test
	public void updateCategoryTest()
	{
		category.setCategory_Id("Cat_000");
		category.setCategory_description("Tablets category");
		category.setCategory_name("Electronic....");
		boolean status = categoryDAO.update(category);
		assertEquals("Update category",true, status);
	}
	
	/*
	@Test
	public void getCategorySuccessTestCase()
	{
		category = categoryDAO.getCategory("Cat_002");
		assertNotNull("Category test case", category);
	}
	
	@Test
	public void getCategoryFallureTestCase()
	{
		category = categoryDAO.getCategory("Cat_008");
		assertNull("category faillure",category);
	}
	
	@Test
	public void deleteCategorySuccessTestCase()
	{
		boolean status = categoryDAO.delete("Cat_009");
		assertEquals("delete category succss test case" , true, status);
	
	}
	
	@Test
	public void deleteCategoryFailureTestCase()
	{
		boolean status =	categoryDAO.delete("Cat_008");
		assertEquals("delete category failure test case" , false, status);
	
	}
	
	@Test
	public void getAllCategoryTestCase()
	{
		List<Category>	category = categoryDAO.list();
		assertEquals("get all category " , 2, category.size() );
	
	}*/
}


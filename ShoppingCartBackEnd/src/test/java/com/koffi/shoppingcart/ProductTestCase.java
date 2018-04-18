package com.koffi.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.koffi.shoppingcart.dao.CategoryDAO;
import com.koffi.shoppingcart.dao.ProductDAO;
import com.koffi.shoppingcart.dao.SupplierDAO;
import com.koffi.shoppingcart.domain.Category;
import com.koffi.shoppingcart.domain.Product;
import com.koffi.shoppingcart.domain.Supplier;

public class ProductTestCase {

private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static ProductDAO productDAO;
	
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	
	@Autowired
	private static CategoryDAO categoryDAO;
	@Autowired 
	private static Product product;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.koffi");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");

		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		
		//product = (Product)context.getBean("product");
	}
	
	@Test
	public void saveProductTestCase()
	{
		Product product=new Product();
		product.setProduct_Id("Prod_001");
		product.setBrand("Laptop");
		//product.setImage_name("v1.jpg");
		product.setPrice(2000.0);
		product.setProduct_description("Apple MacBook Air Core i5 5th Gen");
		product.setStock(5);
		product.setProduct_name("Apple MacBook");
		
		/*Supplier supplier = supplierDAO.getSupplier("Sup_000");	
		Category category = categoryDAO.getCategory("Cat_000"); can check later*/
		//System.out.println(category.getCategory_Id()+" -------------------------"+supplier.getSupplier_Id());
		
		Supplier supplier = new Supplier();
		supplier.setSupplier_Id("Sup_000");
		
		/*product.setSupplier_Id("Sup_000");Work fine		
		product.setCategory_Id("Cat_000");Work fine*/
		
		
		Category category = new Category();
		category.setCategory_Id("Cat_000");
		
		/*product.setCategory_Id(category.getCategory_Id());
		product.setSupplier_Id(supplier.getSupplier_Id());
		boolean status = productDAO.save(product);
		assertEquals("save product",true, status);
			*/
	}

	/*
	@Test
	public void updateProductTest()
	{
		product.setProduct_Id("Cat_000");
		product.setProduct_description("Tablets product");
		product.setProduct_name("Tablets");
		boolean status = productDAO.update(product);
		assertEquals("Update product",true, status);
	}
	
	@Test
	public void getProductSuccessTestCase()
	{
		product = productDAO.getProduct("Cat_002");
		assertNotNull("Product test case", product);
	}
	
	@Test
	public void getProductFallureTestCase()
	{
		product = productDAO.getProduct("Cat_008");
		assertNull("product faillure",product);
	}
	
	@Test
	public void deleteProductSuccessTestCase()
	{
		boolean status = productDAO.delete("Cat_009");
		assertEquals("delete product succss test case" , true, status);
	
	}
	
	@Test
	public void deleteProductFailureTestCase()
	{
		boolean status =	productDAO.delete("Cat_008");
		assertEquals("delete product failure test case" , false, status);
	
	}
	
	@Test
	public void getAllProductTestCase()
	{
		List<Product>	product = productDAO.list();
		assertEquals("get all product " , 2, product.size() );
	
	}*/
}

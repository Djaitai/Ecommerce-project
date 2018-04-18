package com.koffi.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.koffi.shoppingcart.dao.CartDAO;
import com.koffi.shoppingcart.domain.Cart;

public class CartTestCase {

private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CartDAO cartDAO;
	
	@Autowired 
	private static Cart cart;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.koffi");
		context.refresh();
		cartDAO = (CartDAO)context.getBean("cartDAO");
		cart = (Cart)context.getBean("cart");
	}
	
	@Test
	public void saveCartTestCase()
	{
		//cart.setId();
		cart.setEmailID("koffi@gmail.com");
		cart.setPrice(200.0);
		cart.setProduct_Id("Pro_000");
		cart.setProduct_name("Jacket");
		cart.setQuantity(2);
		cart.setTotal(3);
		boolean status = cartDAO.insert(cart);
		assertEquals("save cart",true, status);
	}
	
/*	@Test
	public void updateCartTest()
	{
		cart.setProduct_name("iPhone");
		boolean status = cartDAO.update(cart);
		assertEquals("Update cart",true, status);
	}
	
	@Test
	public void getCartSuccessTestCase()
	{
		cart = cartDAO.getCart("Cat_002");
		assertNotNull("Cart test case", cart);
	}
	
	@Test
	public void getCartFallureTestCase()
	{
		cart = cartDAO.getCart("Cat_008");
		assertNull("cart faillure",cart);
	}
	
	@Test
	public void deleteCartSuccessTestCase()
	{
		boolean status = cartDAO.delete("Cat_009");
		assertEquals("delete cart succss test case" , true, status);
	
	}
	
	@Test
	public void deleteCartFailureTestCase()
	{
		boolean status =	cartDAO.delete("Cat_008");
		assertEquals("delete cart failure test case" , false, status);
	
	}
	
	@Test
	public void getAllCartTestCase()
	{
		List<Cart>	cart = cartDAO.list();
		assertEquals("get all cart " , 2, cart.size() );
	
	}*/

}

package com.koffi.shoppingcart.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koffi.shoppingcart.dao.CartDAO;
import com.koffi.shoppingcart.dao.CategoryDAO;
import com.koffi.shoppingcart.dao.OrdersDAO;
import com.koffi.shoppingcart.dao.ProductDAO;
import com.koffi.shoppingcart.dao.UserDAO;
import com.koffi.shoppingcart.domain.Cart;
import com.koffi.shoppingcart.domain.Orders;
import com.koffi.shoppingcart.domain.User;

@Controller
public class CartController {
	
	//int a;
	String a;
	@Autowired
	ProductDAO productDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	CartDAO cartDAO;

	/*@Autowired
	OrdersDao orderDao;*/

	@Autowired
	CategoryDAO categoryDAO;
	
	
	@Autowired
	OrdersDAO orderDAO;
	
	
	@ModelAttribute
	public void addAttributes(Model model) {
	   model.addAttribute("categories", categoryDAO.list());
	} 
	
	

	@RequestMapping(value="/addToCart",method=RequestMethod.POST)
	public ModelAndView addToCart(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		try {
			Principal principal = request.getUserPrincipal();
			String userEmail = principal.getName();
			String pid = request.getParameter("product_Id");
			//a=pid;
			Double price = Double.parseDouble(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quant"));
			String productName=request.getParameter("product_name");
			String imgName=request.getParameter("image_name");
			Cart cartExist=cartDAO.getCartById(pid, userEmail);
			if(cartExist==null){
				Cart cart = new Cart();

				cart.setPrice(price);
                cart.setProduct_Id(pid);
                
				cart.setCart_image(imgName);
				cart.setQuantity(quantity);
				cart.setProduct_name(productName);
				
				cart.setEmailID(userEmail);
				//User u = userDao.findbyUserId(userEmail);
				
				cartDAO.insert(cart);
				
			}
			else
			{
               Cart cart = new Cart();
               cart.setCart_Id(cartExist.getCart_Id());
               cart.setPrice(price);

               cart.setProduct_Id(pid);
               cart.setCart_image(imgName);
               cart.setProduct_name(productName);
               cart.setQuantity(cartExist.getQuantity()+quantity);
				//User user = userDAO.getUser(userEmail);
				//cart.setCartUserDetails(user);
               cart.setEmailID(userEmail);
				cartDAO.update(cart);
			}
			
			//Product product = productDao.findbyId(pid);

			// mav.addObject("product", product);

			modelAndView.addObject("cartInfo", cartDAO.findCartById(userEmail));

			//mav.addObject("product", product);
			modelAndView.setViewName("cart");

			return modelAndView;
		} catch (Exception ex) 
		{
			ex.printStackTrace();
			modelAndView.setViewName("loginModal");
			return modelAndView;
		}
	}
	
	@RequestMapping("/showCart")
	public ModelAndView showCart(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cartInfo", cartDAO.findCartById(userEmail));
		modelAndView.setViewName("cart");

		return modelAndView;
	}
	

	@RequestMapping("/checkout")
	public ModelAndView checkout(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("checkout");
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		//User user = userDAO.findbyUserId(userEmail);
		User user = userDAO.getUser(userEmail);
		List<Cart> cart = cartDAO.findCartById(userEmail);

		modelAndView.addObject("user", user);
		modelAndView.addObject("cart", cart);
		return modelAndView;

	}

	@RequestMapping(value = "/invoiceprocess", method = RequestMethod.POST)
	public ModelAndView orderSave(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("invoice");
		Orders orders = new Orders();
		Double d = Double.parseDouble(request.getParameter("total"));
		String payment = request.getParameter("payment");
		Principal principal = request.getUserPrincipal();
		String emailID = principal.getName();
		//User user = userDAO.findbyUserId(email);
		User user = userDAO.getUser(emailID);

		orders.setUser(user);
		orders.setTotal(d);
		orders.setPayment(payment);
		orderDAO.addOrder(orders);

		
		cartDAO.deleteByEmailID(emailID);
		modelAndView.addObject("userDetails", user);
		return modelAndView;
	}

	@RequestMapping(value = "/ackAction")
	public ModelAndView invoiceaction(HttpServletRequest request) {
		return new ModelAndView("acknowledgement");
	}
	
	
	
	
	@RequestMapping(value="/deletePCart/{card_Id}")
	public ModelAndView deleteProductFromCart(@PathVariable("card_Id") int cart_Id,
			HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Principal principal = request.getUserPrincipal();
		String emailID = principal.getName();
		cartDAO.delete(cart_Id);
		modelAndView.addObject("cartInfo", cartDAO.findCartById(emailID));
		modelAndView.setViewName("cart");
		return modelAndView;
	}
	

}

package com.koffi.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koffi.shoppingcart.dao.CategoryDAO;
import com.koffi.shoppingcart.dao.ProductDAO;
import com.koffi.shoppingcart.dao.SupplierDAO;
import com.koffi.shoppingcart.dao.UserDAO;
import com.koffi.shoppingcart.domain.Category;
import com.koffi.shoppingcart.domain.Product;
import com.koffi.shoppingcart.domain.Supplier;
import com.koffi.shoppingcart.domain.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired HttpSession httpSession;
	
	@ModelAttribute
	public void addAttributes(Model model) {
	   model.addAttribute("categories", categoryDAO.list());
	}
	
	@RequestMapping(value= {"/manageUsers"} , method = RequestMethod.GET)
	public ModelAndView adminClickedUsers() {				
		ModelAndView modelAndView = new ModelAndView("admin/adminHome");
		modelAndView.addObject("isAdminClickedUsers", true);
		List<Category> categories = categoryDAO.list();
		modelAndView.addObject("categories", categories);
		//httpSession.setAttribute("categories", categories);
		modelAndView.addObject("user", new User());
		modelAndView.addObject("users",userDAO.list());
		return modelAndView;
	}
	
	@RequestMapping(value= {"/manageCategories"} , method = RequestMethod.GET)
	public ModelAndView admincClickedCategories()
	{
		ModelAndView modelAndView = new ModelAndView("admin/adminHome");
		//1 - check whether user logged or not
	String loggedInUserID= (String)httpSession.getAttribute("loggedInUserID");
	/*if(loggedInUserID==null) come back
	{
		//if not logged, "Please loging to do this opertaion
		modelAndView.addObject("errorMessage", "Please login to do this operation");
		return modelAndView;
	}*/
			//2 - the already logged in
			//  check what is role of the user
		/*
		Boolean isAdmin =(Boolean)  httpSession.getAttribute("isAdmin"); come back
			//if the role of user is not admin
			//"You are not authorized to do this operation
		 if(isAdmin ==null  || isAdmin==false)
		 {
			 mv.addObject("errorMessage", "You are not autheroized to do this operations.");
			 return mv;
		 }*/
			//log.debug("starting of the method admincClickedCategories"); come back
			
			modelAndView.addObject("isAdminClickedManageCategories", true);
			//fetch all the categories again 
			List<Category> categories = categoryDAO.list();
			modelAndView.addObject("categories", categories);
			//and set to http session.
			//httpSession.setAttribute("categories", categories);
			//log.debug("ending of the method admincClickedCategories");come back
			return modelAndView;
		}
	
	
	@RequestMapping("/manageSuppliers")
	public ModelAndView admincClickedSupplier()
	{
		//log.debug("starting of the method admincClickedSupplier");
		//ModelAndView mv = new ModelAndView("home");
		ModelAndView modelAndView = new ModelAndView("admin/adminHome");
		modelAndView.addObject("isAdminClickedManageSuppliers", true);
		
		List<Supplier> suppliers =  supplierDAO.list();
		modelAndView.addObject("suppliers", suppliers);
		//httpSession.setAttribute("suppliers", suppliers);
		//log.debug("ending of the method admincClickedSupplier");
		return modelAndView;
	}
	
	
	@RequestMapping("/manageProducts")
	public ModelAndView admincClickedProducts()
	{
		//log.debug("starting of the method admincClickedProducts");
		ModelAndView modelAndView = new ModelAndView("admin/adminHome");
		modelAndView.addObject("isAdminClickedManageProducts", true);
		//we suppsed to fetch all categories and suppliers
		//and set it to http sesion.
		 List<Category> categories = categoryDAO.list();
		 List<Supplier> suppliers = supplierDAO.list();
		 List<Product> products = productDAO.list();
		 
		 
		 /*httpSession.setAttribute("categories", categories);
		 httpSession.setAttribute("suppliers", suppliers);
		 httpSession.setAttribute("products", products);*/
		 
		 modelAndView.addObject("categories", categories);
		 modelAndView.addObject("suppliers", suppliers);
		 modelAndView.addObject("products", products);
		// log.debug("ending of the method admincClickedProducts");
		return modelAndView;
	}	
}

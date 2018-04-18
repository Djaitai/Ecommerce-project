package com.koffi.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koffi.shoppingcart.dao.CategoryDAO;
import com.koffi.shoppingcart.dao.ProductDAO;

@Controller
public class HomeController {
	
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/home"})
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("categories", categoryDAO.list());
		return modelAndView;
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
	   model.addAttribute("catList", categoryDAO.list());
	} 

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	/*@RequestMapping("/register")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		return modelAndView;
	}*/
	
	@RequestMapping("/details")
	public ModelAndView productDetails() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("details");
		return mav;
	}

}

package com.koffi.shoppingcart.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.koffi.shoppingcart.dao.CartDAO;
import com.koffi.shoppingcart.dao.CategoryDAO;
import com.koffi.shoppingcart.dao.ProductDAO;
import com.koffi.shoppingcart.dao.UserDAO;
import com.koffi.shoppingcart.domain.Category;
import com.koffi.shoppingcart.domain.Product;
import com.koffi.shoppingcart.domain.User;

@Controller
public class UserController {
	
	@Autowired
	private User user;
	@Autowired
	UserDAO userDAO;

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	CartDAO cartDAo;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registration(){
		//ModelAndView modelAndView = new ModelAndView("home");
		//modelAndView.addObject("isUserClickedRegister", true);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		//modelAndView.setViewName("register");
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/saveRegister", method = RequestMethod.POST)
	public ModelAndView registration(@Valid @ModelAttribute("user") User user, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors())
		{
			
			//modelAndView.setViewName("register");
			modelAndView.setViewName("registration");
			return modelAndView;
		} else {
			user.setRegisteredDate(new Date());
			user.setRole("ROLE_USER");
			//user.setEnabled(true); check with tech mentor
			userDAO.save(user);
			modelAndView.setViewName("redirect:/login");
			return modelAndView;
		}
	}
	
	@RequestMapping("/errorPage")
	public  String errorPage(){
		ModelAndView modelAndView = new ModelAndView("errorPage");
		List<Category> categories = categoryDAO.list();
		modelAndView.addObject("categories", categories); 
		return "errorPage";	
	}
	/*
	@RequestMapping("errorPage")
	public ModelAndView error(){
		//ModelAndView modelAndView = new ModelAndView("home");
		//modelAndView.addObject("isUserClickedRegister", true);
		ModelAndView modelAndView = new ModelAndView();
		<List>
		return modelAndView;
	}*/
	
	@RequestMapping("/userLogged")
	public  String userLogged(){
		return "redirect:/";		
	}
	
	
	@RequestMapping("/user/update/")
	public ModelAndView updateUser(@ModelAttribute User user) {
		// navigate to home page
		ModelAndView mv = new ModelAndView("home");

		// call save method of userDAO
		if (userDAO.update(user) == true) {
			// add success message
			mv.addObject("successMessage", "The user updated successfully");
		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not update the user.");

		}
		return mv;

	}

	@RequestMapping("/user/delete")
	public ModelAndView deleteUser(@RequestParam String emailID) {
		System.out.println("going to delete user : " + emailID);
		// navigate to home page
		ModelAndView mv = new ModelAndView("redirect:/manageUsers");
		// we supposed to fetch the latest users
		// and add to httpSession
		// based on id, fetch the details from userDAO
		if (userDAO.delete(emailID) == true) {
			// add success message
			mv.addObject("successMessage", "The user deleted successfully");

		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not delete the user.");

		}

		return mv;

	}

	@RequestMapping("/user/edit")
	public ModelAndView editUser(@RequestParam String emailID) {
		//ModelAndView modelAndView = new ModelAndView("redirect:/manageUsers");
		ModelAndView modelAndView = new ModelAndView("admin/updateUser");
		// based on user id fetch user details.
		user = userDAO.getUser(emailID);	
		modelAndView.addObject("user", user);
		//System.out.println("USER INFO: "+user.getEmailID()+"================");//see after
		//httpSession.setAttribute("selectedUser", user);
		return modelAndView;
	}

	@RequestMapping("/users")
	public ModelAndView getAllCategories() {
		ModelAndView mv = new ModelAndView("home");
		List<User> users = userDAO.list();
		mv.addObject("users", users);
		return mv;
	}

	@ModelAttribute
	public void addAttributes(Model model) {
	   model.addAttribute("categories", categoryDAO.list());
	} 
	
	
	@RequestMapping(value="/productCustList/{cid}") 
	public ModelAndView displayCustProducts(@PathVariable String cid)
	{ 
		System.out.println("pcl-----"+cid); 
	ModelAndView mv=new ModelAndView(); 
	//mv.getModelMap().addAttribute("custProducts",productDAO.getProductsByCategory(cid));
	List<Product> pp=productDAO.getProductsByCategory(cid);
	
	System.out.println(pp);
	System.out.println("---------------------"+pp.size());
	mv.addObject("custProducts",pp);
	mv.setViewName("categoryProductListPage");
	return mv; 
	}

	@RequestMapping(value="/productDescription/{product_Id}")
	public ModelAndView productDescription(@PathVariable String product_Id)
	
	{
		
		ModelAndView mav=new ModelAndView();
		
		Product product=productDAO.getProduct(product_Id);
		
		mav.addObject("product", product);
		
		mav.setViewName("details");
		return mav;	
	}
	@RequestMapping("/allProductList")
	public ModelAndView allProductsList()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("productlist", productDAO.list());
		modelAndView.setViewName("allProductList");
		return modelAndView;
	}
	
}

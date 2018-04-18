package com.koffi.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.koffi.shoppingcart.dao.CategoryDAO;
import com.koffi.shoppingcart.domain.Category;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	
	// we need to call CategoryDAO methods
			// get,save,update,delete,list

			// 1. inject the CategoryDAO and Category
			@Autowired
			private CategoryDAO categoryDAO;

			@Autowired
			private Category category;

			@Autowired
			HttpSession httpSession;
			
			@RequestMapping("/category/save")
			public ModelAndView saveCategory(@RequestParam("category_Id") String category_Id,
											  @RequestParam("category_name") String category_name,
											  @RequestParam("category_description") String category_description) {
				ModelAndView modelAndView = new ModelAndView("redirect:/admin/manageCategories");
				category.setCategory_Id(category_Id);
				category.setCategory_name(category_name);
				category.setCategory_description(category_description);
				if (categoryDAO.save(category)==true) {
					modelAndView.addObject("categorySuccessMessage", "The category created successfully");
				} else {
					modelAndView.addObject("categoryErrorMessage", "Could not able to create category.  please contact admin");
				}
				return modelAndView;
			}
			
			@RequestMapping("/category/update/")
			public ModelAndView updateCategory(@ModelAttribute Category category) {
				// navigate to home page
				ModelAndView modelAndView = new ModelAndView("home");

				// call save method of categoryDAO
				if (categoryDAO.update(category) == true) {
					// add success message
					modelAndView.addObject("successMessage", "The category updated successfully");
				} else {
					// add failure message
					modelAndView.addObject("errorMessage", "Could not update the category.");
				}
				return modelAndView;
			}
			
			@RequestMapping("/category/delete")
			public ModelAndView deleteCategory(@RequestParam String category_Id) {
				//System.out.println("going to delete category : " + category_Id);
				// navigate to home page
				ModelAndView modelAndView = new ModelAndView("redirect:/manageCategories");
				// we supposed to fetch the latest categories
				// and add to httpSession
				// based on id, fetch the details from categoryDAO
				if (categoryDAO.delete(category_Id) == true) {
					// add success message
					modelAndView.addObject("successMessage", "The category deleted successfully");
				} else {
					// add failure message
					modelAndView.addObject("errorMessage", "Could not delete the category.");
				}
				return modelAndView;
			}
			
			@RequestMapping("category/edit")
			public ModelAndView editCategory(@RequestParam String category_Id) {
				ModelAndView modelAndView = new ModelAndView("redirect:/manageCategories");
				// based on category id fetch category details.
				category = categoryDAO.getCategory(category_Id);
				// mv.addObject("selectedCategory", category);
				httpSession.setAttribute("selectedCategory", category);
				return modelAndView;
			}

			@RequestMapping("/categories")
			public ModelAndView getAllCategories() {
				ModelAndView modelAndView = new ModelAndView("home");
				List<Category> categories = categoryDAO.list();
				modelAndView.addObject("categories", categories);
				return modelAndView;
			}

}

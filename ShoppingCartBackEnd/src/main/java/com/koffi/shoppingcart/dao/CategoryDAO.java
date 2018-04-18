package com.koffi.shoppingcart.dao;

import java.util.List;

import com.koffi.shoppingcart.domain.Category;

public interface CategoryDAO {

	// Create a category
			public boolean save(Category category);
			
			//Update existing category details
			public  boolean   update(Category category);
			
			public Category getCategory(String category_id);
			
			//Delete the specified category
			public boolean delete(String category_id);
			
			
			// List all the categories
		    public List<Category> list();
}

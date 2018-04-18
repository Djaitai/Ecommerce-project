package com.koffi.shoppingcart.dao;

import java.util.List;

import com.koffi.shoppingcart.domain.Product;

public interface ProductDAO {
	
	// Create a product
		public boolean save(Product product);
			
		//Update existing product details
		public  boolean   update(Product product);
			
		public Product getProduct(String product_Id);
		
		//Delete the specified product
		public boolean delete(String product_Id);
			
		// List the product
		public List<Product> list();
		
		//later added
		public List<Product>    search(String searchString);
		
		public List<Product>    search(String searchString, int maxPrice);
		
		public List<Product>    search(String searchString, int minPrice , int maxPrice);
		
		public List<Product> getProductsByCategory(String cid);

}

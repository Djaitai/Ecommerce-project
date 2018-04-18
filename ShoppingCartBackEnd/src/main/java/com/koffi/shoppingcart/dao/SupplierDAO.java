package com.koffi.shoppingcart.dao;

import java.util.List;

import com.koffi.shoppingcart.domain.Supplier;

public interface SupplierDAO {
	
	// Create a supplier
		public boolean save(Supplier supplier);
			
		//Update existing supplier details
		public  boolean   update(Supplier supplier);
			
		public Supplier getSupplier(String supplier_id);
			
		//Delete the specified supplier
		public boolean delete(String supplier_id);
		
		// List the supplier
		public List<Supplier> list();


}

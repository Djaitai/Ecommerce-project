package com.koffi.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.koffi.shoppingcart.dao.SupplierDAO;
import com.koffi.shoppingcart.domain.Supplier;

public class SupplierestCase {

private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired 
	private static Supplier supplier;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.koffi");
		context.refresh();
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplier = (Supplier)context.getBean("supplier");
	}
	
	@Test
	public void saveSupplierTestCase()
	{
		supplier.setSupplier_Id("Sup_001");
		supplier.setSupplier_mobile("8785214025");
		supplier.setSupplier_name("John");
		supplier.setSupplier_address("M. G. Road");
		boolean status = supplierDAO.save(supplier);
		assertEquals("save supplier",true, status);
	}
	
	@Test
	public void updateSupplierTest()
	{
		supplier.setSupplier_Id("Sup_000");
		supplier.setSupplier_name("Kone");
		supplier.setSupplier_address("Abidjan");
		supplier.setSupplier_mobile("8585828252");
		boolean status = supplierDAO.update(supplier);
		assertEquals("Update supplier",true, status);
	}
	/*
	@Test
	public void getSupplierSuccessTestCase()
	{
		supplier = supplierDAO.getSupplier("Sup_005");
		assertNotNull("Supplier test case", supplier);
	}
	
	@Test // Cause problem, to checked later
	public void getSupplierFallureTestCase()
	{
		supplier = supplierDAO.getSupplier("Sup_0018");
		assertNull("supplier faillure",supplier);
	}
	
	@Test
	public void deleteSupplierSuccessTestCase()
	{
		boolean status = supplierDAO.delete("Sup_006");
		assertEquals("delete supplier succss test case" , true, status);
	
	}
	
	@Test
	public void deleteSupplierFailureTestCase()
	{
		boolean status =	supplierDAO.delete("Sup_00118");
		assertEquals("delete supplier failure test case" , false, status);
	
	}
	
	@Test
	public void getAllSupplierTestCase()
	{
		List<Supplier>	supplier = supplierDAO.list();
		assertEquals("get all supplier " , 7, supplier.size() );
	
	}*/
}


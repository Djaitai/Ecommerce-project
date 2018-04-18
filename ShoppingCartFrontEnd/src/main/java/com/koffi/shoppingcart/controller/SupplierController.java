package com.koffi.shoppingcart.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.koffi.shoppingcart.dao.CategoryDAO;
import com.koffi.shoppingcart.dao.SupplierDAO;
import com.koffi.shoppingcart.domain.Supplier;

@Controller
@RequestMapping("/admin")
public class SupplierController {
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	HttpSession httpSession;


	/*@RequestMapping(name = "/getSupplier/", method = RequestMethod.GET)
	public ModelAndView getSupplier(@RequestParam String id) {
		// based on id, fetch the details from categoryDAO
		supplier = supplierDAO.get(id);
		// navigate to home page
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("supplier", supplier);
		return mv
	}*/

	
	@ModelAttribute
	public void addAttributes(Model model) {
	   model.addAttribute("categories", categoryDAO.list());
	}
	
	
	@RequestMapping("/supplier/save")
	public ModelAndView saveSupplier(@RequestParam("supplier_Id") String supplier_Id,
			@RequestParam("supplier_name") String supplier_name,
			@RequestParam("supplier_mobile") String supplier_mobile,
			@RequestParam("supplier_address") String supplier_address) {
		//System.out.println("saveSupplier method is calling");
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/manageSuppliers");
		supplier.setSupplier_Id(supplier_Id);
		supplier.setSupplier_name(supplier_name);
		supplier.setSupplier_mobile(supplier_mobile);
		supplier.setSupplier_address(supplier_address);
		if (supplierDAO.save(supplier)) {
			modelAndView.addObject("supplierSuccessMessage", "The supplier created successfully");
		} else {
			modelAndView.addObject("supplierErrorMessage", "Coulc not able to create supplier.  please contact admin");
		}
		return modelAndView;
	}

	
	
	@RequestMapping("/supplier/update/")
	public ModelAndView updateSupplier(@ModelAttribute Supplier supplier) {
		// navigate to home page
		ModelAndView modelAndView = new ModelAndView("home");	
		if (supplierDAO.update(supplier) == true) {
			// add success message
			modelAndView.addObject("successMessage", "The supplier updated successfully");
		} else {
			// add failure message
			modelAndView.addObject("errorMessage", "Could not update the supplier.");
		}
		return modelAndView;
	}
	
	

	@RequestMapping("/supplier/delete/")
	public ModelAndView deleteSupplier(@RequestParam String supplier_Id) {
		// navigate to home page
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/manageSuppliers");
		// we supposed to fetch the latest categories
		// and add to httpSession	
		if (supplierDAO.delete(supplier_Id) == true) {
			// add success message
			modelAndView.addObject("supplierSuccessMessage", "The supplier deleted successfully");
		} else {
			// add failure message
			modelAndView.addObject("supplierErrorMessage", "Could not delete the supplier.");
		}
		return modelAndView;
	}

	
	
	@RequestMapping("/supplier/edit/")
	public ModelAndView editSupplier(@RequestParam String supplier_Id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/manageSuppliers");		
		supplier = supplierDAO.getSupplier(supplier_Id);	
		httpSession.setAttribute("selectedSupplier", supplier);
		return modelAndView;
	}

	
	
	@RequestMapping("/suppliers")
	public ModelAndView getAllSuppliers() {
		ModelAndView modelAndView = new ModelAndView("home");
		List<Supplier> suppliers = supplierDAO.list();
		modelAndView.addObject("suppliers", suppliers);
		return modelAndView;
	}
}


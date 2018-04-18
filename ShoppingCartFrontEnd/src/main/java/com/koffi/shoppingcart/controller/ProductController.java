package com.koffi.shoppingcart.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koffi.shoppingcart.dao.CategoryDAO;
import com.koffi.shoppingcart.dao.ProductDAO;
import com.koffi.shoppingcart.dao.SupplierDAO;
import com.koffi.shoppingcart.domain.Category;
import com.koffi.shoppingcart.domain.Product;
import com.koffi.shoppingcart.domain.Supplier;
//import com.koffi.shoppingcart.util.FileUtil;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	
	@Autowired
	private SupplierDAO supplierDAO;


	@Autowired
	private Product product;
	
	//@Autowired
	//FileUtil fileUtil;
	
	@Autowired
	HttpSession httpSession;
	
	
	
	
	@RequestMapping("/product/get/{product_Id}")
	public ModelAndView getSelectedProduct(@PathVariable("product_Id") String product_Id, RedirectAttributes redirectAttributes) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		redirectAttributes.addFlashAttribute("selectedProduct",  productDAO.getProduct(product_Id));
		redirectAttributes.addFlashAttribute("isUserSelectedProduct",  true);
	//	redirectAttributes.addFlashAttribute("productID", rootPath +File.separator +imageDirectory +File.separator +id + ".PNG");
		return modelAndView;

	}
	
	
	@RequestMapping("/product/save")
	public ModelAndView saveProduct(@RequestParam("product_Id") String product_Id,
									@RequestParam("product_name") String product_name,
									@RequestParam("product_description") String product_description,
									@RequestParam("price") double price,
									@RequestParam("brand") String brand,
									@RequestParam("stock") int stock,
									@RequestParam("category_Id") String category_Id,
									@RequestParam("supplier_Id") String supplier_Id,HttpServletRequest request,
									@RequestParam("file") MultipartFile file) {

		ModelAndView modelAndView = new ModelAndView("redirect:/admin/manageProducts");
		product.setProduct_Id(product_Id);
		product.setBrand(brand);
		product.setProduct_description(product_description);
		product.setProduct_name(product_name);
		product.setPrice(price);
		product.setStock(stock);
		Category category=categoryDAO.getCategory(category_Id);
		
		System.out.println("CID------------------->"+category.getCategory_Id());
		
		product.setCategory(category);
		Supplier supplier=supplierDAO.getSupplier(supplier_Id);
		product.setSupplier(supplier);
		
		/*product.setCategory_Id(category_Id);
		product.setSupplier_Id(supplier_Id);*/
		String filepath = request.getSession().getServletContext().getRealPath("/");
		String filname = file.getOriginalFilename();
		product.setImage_name(filname);
		
		
		System.out.println("File path File" + filepath + " " + filname);

		try {
			// byte imagebyte[] = product.getPimage().getBytes();
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(
					new FileOutputStream(filepath + "/resources/image/" + filname));
			fos.write(imagebyte);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (productDAO.save(product)) {
			modelAndView.addObject("productSuccessMessage", "The product created successfully");
			// call upload image method
			/*if(fileUtil.fileCopyNIO(file, product_Id +".PNG"))
			{
				modelAndView.addObject("uploadMessage", "product image successfully updated");
			}
			else
			{
				modelAndView.addObject("uploadMessage", "Coulod not upload image");
			}*/
		} else {
			modelAndView.addObject("productErrorMessage", "Could not able to create product.  please contact admin");
		}
		return modelAndView;

	}

	@RequestMapping("/product/update/")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		// navigate to home page
		ModelAndView modelAndView = new ModelAndView("home");

		// call save method of productDAO
		if (productDAO.update(product) == true) {
			// add success message
			modelAndView.addObject("successMessage", "The product updated successfully");
		} else {
			// add failure message
			modelAndView.addObject("errorMessage", "Could not update the product.");

		}
		return modelAndView;

	}

	@RequestMapping("/product/delete")
	public ModelAndView deleteProduct(@RequestParam String product_Id) {
		//System.out.println("going to delete product : " + product_Id);
		// navigate to home page
		ModelAndView mv = new ModelAndView("redirect:/admin/manageProducts");
		// we supposed to fetch the latest categories
		// and add to httpSession
		// based on id, fetch the details from productDAO
		if (productDAO.delete(product_Id) == true) {
			// add success message
			mv.addObject("successMessage", "The product deleted successfully");

		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not delete the product.");

		}

		return mv;

	}

	@RequestMapping("/product/edit")
	public ModelAndView editProduct(@RequestParam String product_Id) {
		ModelAndView mv = new ModelAndView("redirect:/admin/manageProducts");
		// based on product id fetch product details.
		product = productDAO.getProduct(product_Id);
		// mv.addObject("selectedProduct", product);
		httpSession.setAttribute("selectedProduct", product);
		return mv;
	}

	@RequestMapping("/products")
	public ModelAndView getAllCategories() {
		ModelAndView modelAndView = new ModelAndView("home");
		List<Product> categories = productDAO.list();
		modelAndView.addObject("products", categories);
		return modelAndView;
	}
	
	@RequestMapping("search")
	public ModelAndView searchProduct(@RequestParam("searchString") String searchString)
	{
		ModelAndView mv = new ModelAndView("home");
		List<Product> products =  productDAO.search(searchString);
		mv.addObject("products", products);
		mv.addObject("isUserSelectedProduct", true);
		//log.info("Number of products with search string " +searchString +  " is/are : " + products.size());
		return mv;		
	}
}
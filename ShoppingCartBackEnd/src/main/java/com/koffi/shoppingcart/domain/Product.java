package com.koffi.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="product")
public class Product {
	
	@Id
	private String product_Id;

	private String brand;
	private String product_name;
	
	@Lob
	private String product_description;
	/*private String category_Id;
	private String supplier_Id;*/
	private double price;
	private int stock;
	private String image_name;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name = "category_Id", updatable = false, insertable = false )
	@JoinColumn(name="category_Id")
	private Category category;

	@ManyToOne
	//@JoinColumn(name = "supplier_Id", nullable = false, updatable = false)
	@JoinColumn(name="supplier_Id")
	private Supplier supplier;
	
	public String getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
/*	public String getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(String category_Id) {
		this.category_Id = category_Id;
	}
	public String getSupplier_Id() {
		return supplier_Id;
	}
	public void setSupplier_Id(String supplier_Id) {
		this.supplier_Id = supplier_Id;
	}*/
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public void setCategory(Category category) {
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	

	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}	
}
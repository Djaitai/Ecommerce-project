package com.koffi.shoppingcart.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "supplier")
public class Supplier {
	
	@Id
	private String supplier_Id;
	
	private String supplier_mobile;
	private String supplier_name;	
	private String supplier_address;
	
	@OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
	private Set<Product> products;
	
	public String getSupplier_Id() {
		return supplier_Id;
	}
	public void setSupplier_Id(String supplier_Id) {
		this.supplier_Id = supplier_Id;
	}
	public String getSupplier_mobile() {
		return supplier_mobile;
	}
	public void setSupplier_mobile(String supplier_mobile) {
		this.supplier_mobile = supplier_mobile;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_address() {
		return supplier_address;
	}
	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
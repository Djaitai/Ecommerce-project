package com.koffi.shoppingcart.domain;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component  //create singleton instance
@Entity     //to specify it is going to map to table
@Table(name="cart")
public class Cart {
	
	@Id    //to specify that it is primary key
	@GeneratedValue//(strategy=GenerationType.AUTO)
	private int cart_Id;
	
	//@OneToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "emailID")
	private String emailID;
	
	private String product_name;
	private String product_Id;
	private double price;
	private int quantity;
	private String cart_image;
	
	@Transient     ///we are not going persist/save this data in table.
	private int total;
	
	public String getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
	/*public Cart(int cart_Id, String emailID, String product_name, String product_Id, double price, int quantity,
			String cart_image, int total) {
		//super();
		this.cart_Id = cart_Id;
		this.emailID = emailID;
		this.product_name = product_name;
		this.product_Id = product_Id;
		this.price = price;
		this.quantity = quantity;
		this.cart_image = cart_image;
		this.total = total;
	}*/
	
	
	/*public int getId() {
		return id;
	}
	public void setId() {
		this.id = new Random().nextInt();
	}*/
	
	public int getCart_Id() {
		return cart_Id;
	}
	public void setCart_Id(int cart_Id) {
		this.cart_Id = cart_Id;
	}
	
	
	public String getEmailID() {
		return emailID;
	}
	
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCart_image() {
		return cart_image;
	}
	public void setCart_image(String cart_image) {
		this.cart_image = cart_image;
	}
	
	
}
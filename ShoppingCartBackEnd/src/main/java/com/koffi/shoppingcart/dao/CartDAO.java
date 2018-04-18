package com.koffi.shoppingcart.dao;

import java.util.List;

import com.koffi.shoppingcart.domain.Cart;
import com.koffi.shoppingcart.domain.User;

public interface CartDAO {
	
	/*public boolean save(Cart cart);

	// update the existing cart
	public boolean update(Cart cart);

	// related to order
	public boolean update(String emailID);

	// get the cart detail
	public Cart getCart(String cart_Id, String emailID);

	// delete the cart
	public boolean delete(String cart_Id);

	// to get all the carts add by a particular user
	public List<Cart> list(String emailID);*/

	 boolean insert(Cart cart);
	
	List<Cart> findCartById(String userId);
	
	//Delete cart by email id
	public boolean deleteByEmailID( String emailID);
	
	
	public void delete(int cart);
	
	public void update(Cart cart);
	
	public Cart getCartById(String pid,String userEmail);

}

package com.koffi.shoppingcart.dao;

import java.util.List;

import com.koffi.shoppingcart.domain.User;

public interface UserDAO {
	
			//Create a user
			public boolean save(User user);
			
			//Update existing user details
			public  boolean   update(User user);
			
			// GET USER BY EMAIL
			public User getUser(String emailID);
			
			//Delete the specified user by email
			public boolean delete(String emailID);
			
			//GET ALL USER
			public List<User> list();
			
			//validate whether the credentials are correct or not.
			public User validate(String emailID, String password);	

}

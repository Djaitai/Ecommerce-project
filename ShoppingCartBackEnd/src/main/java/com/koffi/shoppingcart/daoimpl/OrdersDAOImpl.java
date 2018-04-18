package com.koffi.shoppingcart.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.koffi.shoppingcart.dao.OrdersDAO;
import com.koffi.shoppingcart.domain.Orders;


@Transactional
@Repository("ordersDAO")
public class OrdersDAOImpl implements OrdersDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	public void addOrder(Orders order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
         
		session.saveOrUpdate(order);
		session.getTransaction().commit();
		
	}

}

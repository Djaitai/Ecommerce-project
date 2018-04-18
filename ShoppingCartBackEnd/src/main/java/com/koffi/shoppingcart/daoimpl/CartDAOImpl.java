package com.koffi.shoppingcart.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.koffi.shoppingcart.dao.CartDAO;
import com.koffi.shoppingcart.domain.Cart;

@Transactional
@Repository("cartDAO") // will create instance of CartDAOImpl and the name will cartDAO
public class CartDAOImpl implements CartDAO {

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private Cart cart;

	public boolean insert(Cart cart) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Cart> findCartById(String emailID) {
		Session session = sessionFactory.openSession();
		List<Cart> p = null;
		try {
			// session.beginTransaction();
			/* p= session.get(CartModel.class, userId); */
			/*
			 * p= (CartModel)
			 * session.createQuery("from CartModel where userMailId="+userId).uniqueResult()
			 * ;
			 */

			p = (List<Cart>) session.createQuery(" from Cart  where emailID = :emailID").setString("emailID", emailID)
					.list();
			// session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			// session.getTransaction().rollback();
		}
		return p;

	}

	public void delete(int cart_Id) {
		Session session = sessionFactory.openSession();
		// session.beginTransaction();
		try {
			session.beginTransaction();
			Cart cart = (Cart) session.get(Cart.class, cart_Id);
			session.delete(cart);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// session.getTransaction().commit();
	}

	public void update(Cart cart) {
		// TODO Auto-generated method stub

	}

	public Cart getCartById(String pid, String emailID) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("deprecation")
		Cart cart = (Cart) session.createQuery(" from Cart  where emailID = :emailID and product_Id=:product_Id")
				.setString("emailID", emailID).setString("product_Id", pid).uniqueResult();
		return cart;
	}


	public boolean deleteByEmailID(String emailID) {
		try { 		
			Query query=sessionFactory.getCurrentSession().createQuery("delete Cart where emailID=:emailID");
		    query.setParameter("emailID", emailID);
		    query.executeUpdate();
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	
	
	
	
	
	/*Logger log = LoggerFactory.getLogger(CartDAOImpl.class);

	public boolean save(Cart cart) { // store in the database. try {
	  //cart.setId(); sessionFactory.getCurrentSession().save(cart); return true; }
	  catch (HibernateException e) { e.printStackTrace(); return false; } }

	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) { // TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(String emailID) {
	  //log.debug("Starting of the method update"); Come back
	  //log.debug("Goiig to place order of " + emailID);Come back String hql =
	  "update Cart set status = 'O' where emailid='" + emailID +"'";
	  
	 //log.info("The given query : " + hql);Come back
	  
	  try { sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	  //log.debug("Ending of the method update");Come back return true; } catch
	  (Exception e) { return false; } }

	public Cart getCart(String cart_Id) { // it will fetch the record based on id and store in Cart class return
	  sessionFactory.getCurrentSession().get(Cart.class, cart_Id); }

	public boolean delete(String cart_Id)
	{ try 
	{ cart = getCart(cart_Id); 
	if
}
	 (cart == null) { return false; }
	  sessionFactory.getCurrentSession().delete(cart);
	  
	  return true; } catch (HibernateException e) { // TODO Auto-generated catch
	 block e.printStackTrace(); return false; } }

	@SuppressWarnings({ "unchecked", "deprecation" }) public List<Cart>
	  list(String emailID) { //select * from cart where emialID = ? return
	  sessionFactory.getCurrentSession().createCriteria(Cart.class)
	  dd(Restrictions.eq("emailID", emailID)).list(); }
*/
}
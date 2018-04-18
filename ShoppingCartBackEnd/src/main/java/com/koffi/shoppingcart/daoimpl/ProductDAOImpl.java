package com.koffi.shoppingcart.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.koffi.shoppingcart.dao.ProductDAO;
import com.koffi.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO") // will create instance of ProductDAOImpl and name will be userDao
public class ProductDAOImpl implements ProductDAO {

	// first inject hibernate session
	@Autowired // session factory will automatically inject in the class
	private SessionFactory sessionFactory;

	@Autowired
	Product product = new Product();

	public boolean save(Product product) {
		// store in the database.
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Product getProduct(String product_Id) {
		// it will fetch the record based on emailID and store in Product class
		return sessionFactory.getCurrentSession().get(Product.class, product_Id);
	}

	public boolean delete(String product_Id) {
		try {
			product = getProduct(product_Id);
			if (product == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(product);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * public List<Product> list() { return
	 * sessionFactory.getCurrentSession().createQuery("from Product").list(); }
	 */

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Product> list() {
		return (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> search(String searchString) {
		String hql = "from Product where description like '%" + searchString + "%'";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> search(String searchString, int maxPrice) {
		String hql = "from Product where description like '%" + searchString + "%'  and price < " + maxPrice;
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	public List<Product> search(String searchString, int minPrice, int maxPrice) {
		// SELECT * from product where description like '%book%' and price between 3000
		// and 4000
		return null;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductsByCategory(String cid) {
		Session session=sessionFactory.openSession();
		List<Product> products = null;
		//session.beginTransaction();
		/*Query q= session.createSQLQuery("select * from product where category_id=:category_id");  
		
		q.setParameter("category_id", cid);
		products=q.getResultList();*/
		
		
		Query q=session.createQuery("from Product where category_id=:category_id");
		q.setParameter("category_id", cid);
		products=q.getResultList();
		
		//session.getTransaction().commit();
		 return products;
		}
}
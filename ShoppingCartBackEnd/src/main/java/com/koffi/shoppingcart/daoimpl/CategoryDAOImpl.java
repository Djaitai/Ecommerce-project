package com.koffi.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.koffi.shoppingcart.dao.CategoryDAO;
import com.koffi.shoppingcart.domain.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
		// first inject hibernate session
		@Autowired // session factory will automatically inject in the class
		private SessionFactory sessionFactory;

		@Autowired
		Category category = new Category();

		public boolean save(Category category) {
			// store in the database.
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(category);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		public boolean update(Category category) {
			try {
				sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		public Category getCategory(String category_id) {
			// it will fetch the record based on id and store in Category class
			return sessionFactory.getCurrentSession().get(Category.class, category_id);
		}

		public boolean delete(String category_id) {
			try {
				category = getCategory(category_id);
				if (category == null) {
					return false;
				}

				sessionFactory.getCurrentSession().delete(category);

				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		@SuppressWarnings({ "unchecked", "deprecation" })
		public List<Category> list() {
			// return sessionFactory.getCurrentSession().createQuery("from
			// Category").list();
			return (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		}
}
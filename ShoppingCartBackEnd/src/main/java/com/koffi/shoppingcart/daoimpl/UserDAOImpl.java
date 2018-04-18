package com.koffi.shoppingcart.daoimpl;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.koffi.shoppingcart.dao.UserDAO;
import com.koffi.shoppingcart.domain.User;

@Transactional
@Repository("userDAO") // will create instance of UserDAOImpl and the name will userDAO
//@SuppressWarnings("deprecation")
public class UserDAOImpl implements UserDAO {

	// private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private User user;

	//
	public boolean save(User user) {
		//log.debug("Starting of the save method");
		// store in the database.
		try {
			//user.setRole('C');

			//user.setRegisteredDate(new Date(System.currentTimeMillis()) + "");
			sessionFactory.getCurrentSession().save(user);
			//log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}


	public boolean update(User user) {
		// log.debug("Starting of the update method");
		try {
			sessionFactory.getCurrentSession().update(user);
			// log.debug("Ending of the update method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// log.error(" error occured in update method " + e.getMessage());
			return false;
		}
	}

	public User getUser(String emailID) {
		// log.debug("Starting of the get method");
		// it will fetch the record based on emailID and store in User class
		return sessionFactory.getCurrentSession().get(User.class, emailID);
	}

	public boolean delete(String emailID) {
		// log.debug("Starting of the delete method");
		try {
			user = getUser(emailID);
			if (user == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(user);
			// log.debug("Ending of the delete method");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			// log.error(" error occured in delete method " + e.getMessage());
			return false;
		}
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<User> list() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@SuppressWarnings("deprecation")
	public User validate(String emailID, String password) {
		// select * from user where emailID = 'jaskaran1@gmail.com' and password =
		// 'jas123'
		/*
		 * log.debug("Starting of the validate method"); log.info(" user " + emailID +
		 * " trying to login");
		 */
		user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("emailID", emailID)).add(Restrictions.eq("password", password)).uniqueResult();

		return user;
	}
}
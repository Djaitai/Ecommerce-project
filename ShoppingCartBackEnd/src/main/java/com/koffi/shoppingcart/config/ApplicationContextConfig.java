package com.koffi.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.koffi.shoppingcart.domain.Cart;
import com.koffi.shoppingcart.domain.Category;
import com.koffi.shoppingcart.domain.Orders;
import com.koffi.shoppingcart.domain.Product;
import com.koffi.shoppingcart.domain.Supplier;
import com.koffi.shoppingcart.domain.User;

	@Configuration
	@ComponentScan("com.koffi.shoppingcart")
    @EnableTransactionManagement
public class ApplicationContextConfig {
	
	private final static String database_url = "jdbc:h2:tcp://localhost/~/shoppingCartDB";
	private final static String database_driver = "org.h2.Driver";
	private final static String database_dialect = "org.hibernate.dialect.H2Dialect";
	private final static String database_username = "";
	private final static String database_password = "";
	
	//dataSource bean will be available

		@Bean(name = "dataSource")
		public DataSource getDataSource()
		{
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(database_driver);
			dataSource.setUrl(database_url);
			dataSource.setUsername(database_username);
			dataSource.setPassword(database_password);			
			return dataSource;
		}
		
		private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.dialect",database_dialect);
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.hbm2ddl.auto", "update");
			return properties;
		}
		
		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory() {			
			LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
			
			//Properties properties = new Properties();
			
			localSessionFactoryBuilder.addAnnotatedClass(User.class);	
			localSessionFactoryBuilder.addAnnotatedClass(Category.class);
			localSessionFactoryBuilder.addAnnotatedClass(Supplier.class);
			localSessionFactoryBuilder.addAnnotatedClass(Cart.class);
			localSessionFactoryBuilder.addAnnotatedClass(Product.class);
			localSessionFactoryBuilder.addAnnotatedClass(Orders.class);
			//localSessionFactoryBuilder.scanPackages("com.koffi.shoppingcart.domain");
			//localSessionFactoryBuilder.addProperties(properties);
			localSessionFactoryBuilder.addProperties(getHibernateProperties());
			return localSessionFactoryBuilder.buildSessionFactory();	
		}
		
		
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}	
}


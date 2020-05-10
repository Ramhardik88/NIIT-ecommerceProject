package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CategoryDAOImplementation;
import com.niit.dao.ProductDAOImplementation;
import com.niit.dao.SupplierDAOImplementation;
import com.niit.dao.UserDAOImplementation;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.OrderDetail;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {
	
	@Bean(name="DataSource")
	public DataSource getmysqlDataSource()
	
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/Onlineshopping?useSSL=false");
		datasource.setUsername("root");
		datasource.setPassword("Ramkumar@123");
		System.out.println("Data source");
		return datasource;
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionfactory() 
	{
		
		Properties hibernateproperties=new Properties();
		hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		hibernateproperties.setProperty("hibernate.hbm2ddl.auto","create");
		LocalSessionFactoryBuilder localSessionFactory= new LocalSessionFactoryBuilder(getmysqlDataSource());
		localSessionFactory.addProperties(hibernateproperties);
		localSessionFactory.addAnnotatedClass(Category.class);
		localSessionFactory.addAnnotatedClass(Supplier.class);
		localSessionFactory.addAnnotatedClass(Product.class);
		localSessionFactory.addAnnotatedClass(User.class);
		localSessionFactory.addAnnotatedClass(CartItem.class);
		localSessionFactory.addAnnotatedClass(OrderDetail.class);
		SessionFactory sessionFactory=localSessionFactory.buildSessionFactory();
		System.out.println("session Factory ");
		return sessionFactory;
	}
	
	@Bean(name="transactionmanager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionfactory){
		System.out.println("Transaction Factory ");
		return new HibernateTransactionManager(sessionfactory);
	}
	
	@Bean(name="categoryDAO")
	public CategoryDAOImplementation getCategoryDAOImplementation(){
		return new CategoryDAOImplementation();
	}
	
	@Bean(name="supplierDAO")
	public SupplierDAOImplementation getSupplierDAOImplementation(){
		return new SupplierDAOImplementation();
	}
	
	@Bean(name="productDAO")
	public ProductDAOImplementation getProductDAOImplementation(){
		return new ProductDAOImplementation();
	}
	
	@Bean(name="userDAO")
	public UserDAOImplementation getUserDAOImplementation(){
		return new UserDAOImplementation();
	}

}

package com.jsp.hibernate_case_study_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_case_study_entity.Cart;
import com.jsp.hibernate_case_study_entity.Product;

public class App1 {
public static void main(String[] args) {
	Cart cart= new Cart();
	
	Product p= new Product();
	p.setProductName("laptop");
	p.setProductPrice(10000.0);
	p.setProductQuantity(5);
	
	Product p1= new Product();
	p1.setProductName("capp");
	p1.setProductPrice(100.0);
	p1.setProductQuantity(3);
	
	cart.getProducts().add(p);
	cart.getProducts().add(p1);
	

	Configuration cfg= new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory sf = cfg.buildSessionFactory();
	Session session = sf.openSession();
	Transaction transaction = session.beginTransaction();
	
	session.save(cart);
	session.save(p);
	session.save(p1); 
	
	transaction.commit();
	session.close();
	
			
}
}

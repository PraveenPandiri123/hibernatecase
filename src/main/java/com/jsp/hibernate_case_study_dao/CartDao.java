package com.jsp.hibernate_case_study_dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_case_study_entity.Cart;
import com.jsp.hibernate_case_study_entity.Product;

public class CartDao {
	Configuration cfg= new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory sf= cfg.buildSessionFactory();
	 Scanner sc= new Scanner(System.in);
	public String createCart(Cart cart) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(cart);
		transaction.commit();
		session.close();
		return "Cart Create Successfully";
		
	}
	public Cart getCart(int nextInt) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Cart cart = session.get(Cart.class, nextInt);
		transaction.commit();
		session.close();
		return cart;
	}
	public String addProductToCart(Cart cart) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(cart);
		transaction.commit();
		session.close();
		return "product add successfully";	
	}
	public String removeCart(Cart cart2) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(cart2);;
		transaction.commit();
		session.close();
		return "removed success";	
	}
	

	

}

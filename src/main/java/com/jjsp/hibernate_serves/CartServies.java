package com.jjsp.hibernate_serves;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.jsp.hibernate_case_study_dao.CartDao;
import com.jsp.hibernate_case_study_dao.ProductDao;
import com.jsp.hibernate_case_study_entity.Cart;
import com.jsp.hibernate_case_study_entity.Product;

public class CartServies {
	Scanner sc= new Scanner(System.in);
	CartDao cartdao= new CartDao();
	Cart cart= new Cart();
	ProductDao productdao=new ProductDao();
	public void createCart() {
		String string = cartdao.createCart(cart);
		System.out.println(string);
	}
	public void getCart() {
		System.out.println("enter Cart Id");
		Cart cart2 = cartdao.getCart(sc.nextInt());
		System.out.println(cart2.getProducts());
		
	}
	public void addProductCart() {
		System.out.println("enter Cart Id to add Product");
		Cart cart2 = cartdao.getCart(sc.nextInt());
		if(cart2!=null)
		{
			System.out.println("ente product id");
			Product product = productdao.getProductById1(sc.nextInt());
			cart2.getProducts().add(product);
			cartdao.addProductToCart(cart2);
		}
		else
			System.out.println("entered id is invalid");
	}
	public void removeCartById() {
		System.out.println("enter cart id to remove");
		Cart cart2 = cartdao.getCart(sc.nextInt());
		String removeCart = cartdao.removeCart(cart2);
		System.out.println(removeCart);
	}

}

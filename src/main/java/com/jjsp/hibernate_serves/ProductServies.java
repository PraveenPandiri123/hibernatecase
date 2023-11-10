package com.jjsp.hibernate_serves;

import java.util.List;
import java.util.Scanner;

import javax.naming.Context;

import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsp.hibernate_case_study_dao.ProductDao;
import com.jsp.hibernate_case_study_entity.Product;

public class ProductServies {
	
Scanner sc= new Scanner(System.in);
//ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
//ProductDao productDao = context.getBean(ProductDao.class);
ProductDao productDao= new ProductDao();
public void addproduct()
{  
    Product product= new Product();
	System.out.println("productName");
	product.setProductName(sc.next());
	System.out.println("productprice");
	product.setProductPrice(sc.nextDouble());
	System.out.println("no of quantity of product");
	product.setProductQuantity(sc.nextInt());
	productDao.addProduct(product);
}
public void getProductById1() {
	System.out.println("enter Id");
	int productid= sc.nextInt();
	Product product = productDao.getProductById1(productid);
	System.out.println(product.getProductId()+" "+product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity());
}
public void getAllproduct() {
	List<Product> products = productDao.getAllProducts();
	products.forEach(System.out::println);
}
public void updateProduct()
{
	System.out.println("enter product id to be updated");
	Product product = productDao.getProductById1(sc.nextInt());
	if(product!=null)
	{
		System.out.println("Enter \n 1.to UpdateName \n 2.update product price \n 3.to update product Quantity \n4.update All");
		int choice= sc.nextInt();
		switch (choice) {
		case 1:System.out.println("enter new name to product");
		       product.setProductName(sc.next());
			   productDao.updateProduct(product); 
			break;
		case 2:System.out.println("enter new price to product");
	       product.setProductPrice(sc.nextDouble());
		   productDao.updateProduct(product); 
		break;
		case 3:System.out.println("enter new quantity to product");
	       product.setProductQuantity(sc.nextInt());
		   productDao.updateProduct(product); 
		break;
		case 4:System.out.println("enter Allproduct details");
		System.out.println("product name");
		product.setProductName(sc.next());
		System.out.println("product price ");
		product.setProductPrice(sc.nextDouble());
		System.out.println("product Quamtity");
	    product.setProductQuantity(sc.nextInt());
		productDao.updateProduct(product); 
		break;
		default:System.out.println("enterd valuve id invalid");
			break;
			
		}
	}
	else
		System.out.println("enter value is invalid");
	
}
public void deleteProductById()
{System.out.println("enter product id");
String product = productDao.deleteProduct(sc.nextInt());
System.out.println(product);
	
}
}

package com.jsp.hibernate_case_study_dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_case_study_entity.Product;

public class ProductDao {
	
	
 Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
 SessionFactory sf= cfg.buildSessionFactory();
 Scanner sc= new Scanner(System.in);
	
public  void  addProduct(Product p)//save()
{
	Session session = sf.openSession();
	Transaction transaction = session.beginTransaction();
	session.save(p);
	transaction.commit();
	session.close();
	System.out.println("add successfully");
}
public Product getProductById1(int id)//get()
{
	 
	
	 Session session = sf.openSession();
	Transaction transaction = session.beginTransaction();
	Product product = session.get(Product.class,id);
	System.out.println(product);
	transaction.commit();
	session.close();
	return product;

}
public List<Product> getAllProducts()//hql
{
	
	Session session = sf.openSession();
	Transaction transaction = session.beginTransaction();
	
	Query<Product> query = session.createQuery("from Product");
	List<Product> list = query.list();
	transaction.commit();
	session.close();
	return list;
	/*
	NativeQuery nativeQuery = session.createNativeQuery("select * from Product");
	List<Object[]> list = nativeQuery.list();
	for (Object[] objects : list) {
		System.out.println(Arrays.deepToString(objects));
	}
	
	*/
}
public String updateProduct( Product product)//update()
{
	Session session = sf.openSession();
	Transaction transaction = session.beginTransaction();
	session.update(product);
	transaction.commit();
	session.close();
	return "updated successfully";
}
public String deleteProduct(int productid)//Delete()
{
	Session session = sf.openSession();
	Transaction transaction = session.beginTransaction();
	CriteriaBuilder builder = session.getCriteriaBuilder();
	CriteriaDelete<Product> criteriaDelete = builder.createCriteriaDelete(Product.class);
	Root<Product> root = criteriaDelete.from(Product.class);
	criteriaDelete.where(builder.equal(root.get("productId"), productid));
	Query query = session.createQuery(criteriaDelete);
	int update = query.executeUpdate();
	transaction.commit();
	session.close();
	return "Deleted successfully";
}

}

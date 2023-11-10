package com.jsp.hibernate_case_study_1;

import java.util.Scanner;

import com.jjsp.hibernate_serves.CartServies;
import com.jjsp.hibernate_serves.ProductServies;
import com.jsp.hibernate_case_study_dao.ProductDao;

/**
 * Hello world!
 *
 */
public class App 
{
//    private static ProductDao productDao;

	public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        ProductServies ps= new ProductServies();
        CartServies cs= new CartServies();
        System.out.println("entet \n1.Toaddproduct\n2.TOgetProductById\n3.TOgetAllproducts\n4.ToUpdateProduct\n"
        		+ "5.TODelete\n6.createcort\n7.addproductcart\n8.getCart\n9.cart delate by Id");
        int choice = sc.nextInt();
        switch (choice) {
		case 1: ps.addproduct();
		break;
		case 2: ps.getProductById1();
		break;
        case 3: ps.getAllproduct();
		break;
        case 4: ps.updateProduct();
		break;
        case 5: ps.deleteProductById();
		break;
        case 6: cs.createCart();
		break;
		
        case 7: cs.addProductCart();
		break;
        case 8: cs.getCart();
		break;
        case 9: cs.removeCartById();
		break;
		default:
			System.err.println("invalid value");
			break;
			
        }
          
    }
}

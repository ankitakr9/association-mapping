
package org.jsp.ManyToOneOrOneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

public class FilterProductsBetweenPrice {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();

		Query q=(Query) em.createQuery(
				"select p from Product p where p.price between ?1 and ?2");

		
		System.out.println("Enter the minimum price: ");
		q.setParameter(1, new Scanner(System.in).nextDouble());

		System.out.println("Enter the maximum price: ");
		q.setParameter(2, new Scanner(System.in).nextDouble());

		List<Product> products = q.getResultList();

		if(products.isEmpty()) {
			System.err.println("No product found in this price range.");
		} else {
			System.out.println("Products found successfully.");
			for(Product p : products) {
				System.out.println(p);
			}
		}
	}
}


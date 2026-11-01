
package org.jsp.ManyToOneOrOneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

public class FindProductsByCategory {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();

		Query q=(Query) em.createQuery("select p from Product p where p.category=?1");

		System.out.println("Enter the category: ");
		q.setParameter(1, new Scanner(System.in).next());

		List<Product> products = q.getResultList();

		if(products.isEmpty()) {
			System.err.println("No product found with this category.");
		} else {
			System.out.println("Products found successfully.");
			for(Product p : products) {
				System.out.println(p);
			}
		}
	}
}


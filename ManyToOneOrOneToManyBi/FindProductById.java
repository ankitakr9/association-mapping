
package org.jsp.ManyToOneOrOneToManyBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

public class FindProductById {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();
		
		Query q=(Query) em.createQuery("select p from Product p where p.id=?1");

		System.out.println("Enter the product id: ");
		q.setParameter(1, new Scanner(System.in).nextInt());

		try {
			Product p = (Product) q.getSingleResult();
			System.out.println("Product found successfully.");
			System.out.println(p);

		} catch (Exception e) {
			System.err.println("Invalid product id.");
		}
	}
}



package org.jsp.ManyToOneOrOneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

public class FindProductsByMerchantIdPass {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();

		Query q=(Query) em.createQuery(
				"select p from Product p where p.m.id=?1 and p.m.password=?2");

		System.out.println("Enter the merchant id: ");
		q.setParameter(1, new Scanner(System.in).nextInt());

		System.out.println("Enter the password: ");
		q.setParameter(2, new Scanner(System.in).next());

		List<Product> products = q.getResultList();

		if(products.isEmpty()) {
			System.err.println("Invalid merchant id or password.");
		} else {
			System.out.println("Products found successfully.");
			for(Product p : products) {
				System.out.println(p);
			}
		}
	}
}

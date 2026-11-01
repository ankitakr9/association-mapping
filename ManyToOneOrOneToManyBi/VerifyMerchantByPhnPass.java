package org.jsp.ManyToOneOrOneToManyBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;


public class VerifyMerchantByPhnPass {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();
		Query q=(Query) em.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");

		System.out.println("Enter the phone: ");
		q.setParameter(1, new Scanner(System.in).nextLong());

		System.out.println("Enter the password: ");
		q.setParameter(2, new Scanner(System.in).next());

		try {
			Merchant e = (Merchant) q.getSingleResult();
			System.out.println("Merchant verified successfully.");
			System.out.println(e);

		} catch (Exception e) {
			System.err.println("Invalid phone or password.");

		}
	}
}

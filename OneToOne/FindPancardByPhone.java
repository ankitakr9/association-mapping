package org.com.OneToOne;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPancardByPhone {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select p.card from Person p where p.phone=?1");
		
		System.out.println("Enter the Phone Number:");
		
		q.setParameter(1, new Scanner(System.in).nextLong());
		Pancard pancard = (Pancard) q.getSingleResult();
		System.out.println(pancard);
		
		em.close();
		emf.close();
	}
}

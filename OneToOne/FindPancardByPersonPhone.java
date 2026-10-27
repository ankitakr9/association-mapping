package org.com.OneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPancardByPersonPhone {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("Select p.card from Person p where p.phone=?1");
		System.out.println("Enter the phoneNo: ");
		q.setParameter(1, new Scanner(System.in).nextLong());
		try {
			Pancard card=(Pancard) q.getSingleResult();
			System.out.println(card);
		}catch(NoResultException e) {
			System.err.println("No record found");
		}
	}
}

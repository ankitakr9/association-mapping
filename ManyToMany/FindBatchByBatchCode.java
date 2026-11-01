package org.jsp.ManyToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchByBatchCode {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Batch Code:");
		String code = sc.next();

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("M15");

		EntityManager em = emf.createEntityManager();

		String jpql = "select b from Batch b where b.batch_code = ?1";

		Batch batch = em.createQuery(jpql, Batch.class)
				.setParameter(1, code)
				.getSingleResult();

		System.out.println("Batch Found:");
		System.out.println(batch);

		em.close();
		emf.close();
		sc.close();
	}
}
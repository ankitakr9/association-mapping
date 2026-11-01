package org.jsp.ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchesByStudentPhone {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Phone:");
		long phone = sc.nextLong();

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("M15");

		EntityManager em = emf.createEntityManager();

		String jpql = "select b from Batch b join b.students s "
				+ "where s.phone = ?1";

		List<Batch> batches = em.createQuery(jpql, Batch.class)
				.setParameter(1, phone)
				.getResultList();

		if (batches.isEmpty()) {
			System.out.println("No batch found for phone: " + phone);
		} else {

			System.out.println("Batches found:");

			for (Batch batch : batches) {
				System.out.println(batch);
			}
		}

		em.close();
		emf.close();
		sc.close();
	}
}
package org.jsp.ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchByTrainer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Trainer Name:");
		String trainer = sc.nextLine();

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("M15");

		EntityManager em = emf.createEntityManager();

		String jpql = "select b from Batch b where b.trainer = ?1";

		List<Batch> batches = em.createQuery(jpql, Batch.class)
				.setParameter(1, trainer)
				.getResultList();

		if (batches.isEmpty()) {
			System.out.println("No batch found for trainer: " + trainer);
		} else {
			System.out.println("Batches handled by " + trainer + ":");

			for (Batch batch : batches) {
				System.out.println(batch);
			}
		}

		em.close();
		emf.close();
		sc.close();
	}
}
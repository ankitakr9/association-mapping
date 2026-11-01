package org.jsp.ManyToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchById {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Batch ID:");
		int id = sc.nextInt();

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("M15");

		EntityManager em = emf.createEntityManager();

		Batch batch = em.find(Batch.class, id);

		if (batch != null) {
			System.out.println("Batch Found");
			System.out.println(batch);
		} else {
			System.out.println("Batch Not Found");
		}

		em.close();
		emf.close();
		sc.close();
	}
}
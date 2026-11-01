package org.jsp.ManyToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentByPhone {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Phone:");
		long phone = sc.nextLong();

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("M15");

		EntityManager em = emf.createEntityManager();

		String jpql = "select s from Student s where s.phone = ?1";

		try {

			Student student = em.createQuery(jpql, Student.class)
					.setParameter(1, phone)
					.getSingleResult();

			System.out.println("Student Found:");
			System.out.println(student);

		} catch (Exception e) {

			System.out.println("Student Not Found");
		}

		em.close();
		emf.close();
		sc.close();
	}
}
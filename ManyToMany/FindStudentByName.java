package org.jsp.ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentByName {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Name:");
		String name = sc.next();

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("M15");

		EntityManager em = emf.createEntityManager();

		String jpql = "select s from Student s where s.name = ?1";

		List<Student> students = em.createQuery(jpql, Student.class)
				.setParameter(1, name)
				.getResultList();

		if (students.isEmpty()) {
			System.out.println("Student Not Found");
		} else {

			System.out.println("Students Found:");

			for (Student student : students) {
				System.out.println(student);
			}
		}

		em.close();
		emf.close();
		sc.close();
	}
}
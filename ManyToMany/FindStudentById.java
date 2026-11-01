package org.jsp.ManyToMany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentById {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student ID:");
		int id = sc.nextInt();

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("M15");

		EntityManager em = emf.createEntityManager();

		Student student = em.find(Student.class, id);

		if (student != null) {
			System.out.println("Student Found:");
			System.out.println(student);
		} else {
			System.out.println("Student Not Found");
		}

		em.close();
		emf.close();
		sc.close();
	}
}
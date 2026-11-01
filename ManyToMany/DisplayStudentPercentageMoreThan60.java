package org.jsp.ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DisplayStudentPercentageMoreThan60 {

	public static void main(String[] args) {

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("M15");

		EntityManager em = emf.createEntityManager();

		String jpql = "select s from Student s where s.marks > ?1";

		List<Student> students = em.createQuery(jpql, Student.class)
				.setParameter(1, 60.0)
				.getResultList();

		if (students.isEmpty()) {
			System.out.println("No student found");
		} else {

			System.out.println("Student details whose percentage is more than 60:");

			for (Student student : students) {
				System.out.println(student);
			}
		}

		em.close();
		emf.close();
	}
}
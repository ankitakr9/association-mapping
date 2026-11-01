package org.jsp.ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentAbove85 {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        String jpql = "select s from Student s where s.marks > ?1";

        List<Student> students = em.createQuery(jpql, Student.class)
                .setParameter(1, 85.0)
                .getResultList();

        if (students.isEmpty()) {
            System.out.println("No student found");
        } else {
            System.out.println("Students whose percentage is greater than 85:");

            for (Student student : students) {
                System.out.println(student);
            }
        }

        em.close();
        emf.close();
    }
}
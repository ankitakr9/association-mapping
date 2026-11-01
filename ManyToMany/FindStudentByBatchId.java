package org.jsp.ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentByBatchId {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter batch id:");
        int batchId = sc.nextInt();

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        String jpql = "select s from Student s join s.batch b where b.id = ?1";

        List<Student> students = em.createQuery(jpql, Student.class)
                .setParameter(1, batchId)
                .getResultList();

        if (students.isEmpty()) {
            System.out.println("No student found");
        } else {
            System.out.println("Students in batch ID " + batchId + ":");

            for (Student student : students) {
                System.out.println(student);
            }
        }

        em.close();
        emf.close();
        sc.close();
    }
}
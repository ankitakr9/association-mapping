package org.jsp.ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentsByTrainerAndBatchCode {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter trainer name:");
        String trainer = sc.nextLine();

        System.out.println("Enter batch code:");
        String code = sc.nextLine();

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        String jpql = "select s from Student s "
                + "join s.batch b "
                + "where b.trainer = ?1 and b.batch_code = ?2";

        List<Student> students = em.createQuery(jpql, Student.class)
                .setParameter(1, trainer)
                .setParameter(2, code)
                .getResultList();

        if (students.isEmpty()) {
            System.out.println("No student found");
        } else {
            System.out.println("Students:");

            for (Student student : students) {
                System.out.println(student);
            }
        }

        em.close();
        emf.close();
        sc.close();
    }
}
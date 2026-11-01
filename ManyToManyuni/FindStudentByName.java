package org.jsp.ManyToManyuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentByName {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Student student = em.createQuery(
                "select s from Student s where s.name = ?1",
                Student.class)
                .setParameter(1, "Ankita")
                .getSingleResult();

        System.out.println(student);

        em.close();
        emf.close();
    }
}
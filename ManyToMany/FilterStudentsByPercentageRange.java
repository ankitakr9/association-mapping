package org.jsp.ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FilterStudentsByPercentageRange {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        List<Student> students = em.createQuery(
                "select s from Student s where s.marks between ?1 and ?2",
                Student.class)
                .setParameter(1, 60.0)
                .setParameter(2, 80.0)
                .getResultList();

        for (Student s : students) {
            System.out.println(s);
        }

        em.close();
        emf.close();
    }
}
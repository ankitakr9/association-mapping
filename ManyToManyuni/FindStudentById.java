package org.jsp.ManyToManyuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentById {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, 1);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }

        em.close();
        emf.close();
    }
}
package org.jsp.ManyToManyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FilterStudentByBatchCode {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        List<Student> students = em.createQuery(
                "select s from Batch b join b.students s where b.batch_code = ?1",
                Student.class)
                .setParameter(1, "A18")
                .getResultList();

        for (Student s : students) {
            System.out.println(s);
        }

        em.close();
        emf.close();
    }
}
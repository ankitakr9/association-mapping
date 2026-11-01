package org.jsp.ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchBySubject {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        List<Batch> batches = em.createQuery(
                "select b from Batch b where b.subject = ?1",
                Batch.class)
                .setParameter(1, "Java")
                .getResultList();

        for (Batch b : batches) {
            System.out.println(b);
        }

        em.close();
        emf.close();
    }
}
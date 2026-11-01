package org.jsp.ManyToManyuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchByBatchCode {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Batch batch = em.createQuery(
                "select b from Batch b where b.batch_code = ?1",
                Batch.class)
                .setParameter(1, "M15")
                .getSingleResult();

        System.out.println(batch);

        em.close();
        emf.close();
    }
}
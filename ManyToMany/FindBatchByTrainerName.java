package org.jsp.ManyToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchByTrainerName {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Batch batch = em.createQuery(
                "select b from Batch b where b.trainer = ?1",
                Batch.class)
                .setParameter(1, "Mayank")
                .getSingleResult();

        System.out.println(batch);

        em.close();
        emf.close();
    }
}
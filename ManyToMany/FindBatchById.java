package org.jsp.ManyToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchById {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Batch batch = em.find(Batch.class, 1);

        if (batch != null) {
            System.out.println(batch);
        } else {
            System.out.println("Batch not found");
        }

        em.close();
        emf.close();
    }
}
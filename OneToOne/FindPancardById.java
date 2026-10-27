package org.com.OneToOne;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPancardById {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select p from Pancard p where p.id=?1");

        System.out.println("Enter the Pancard ID:");

        q.setParameter(1, new Scanner(System.in).nextInt());

        Pancard pancard = (Pancard) q.getSingleResult();

        System.out.println(pancard);

        em.close();
        emf.close();
    }
}
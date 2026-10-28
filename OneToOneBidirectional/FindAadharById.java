package org.jsp.OneToOneBidirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharById {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select a from AadharCard a where a.id=?1");

        System.out.println("Enter Aadhar ID:");

        int id = new Scanner(System.in).nextInt();

        q.setParameter(1, id);

        AadharCard a = (AadharCard) q.getSingleResult();

        System.out.println(a);

        em.close();
        emf.close();
    }
}
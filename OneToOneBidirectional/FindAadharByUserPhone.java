package org.jsp.OneToOneBidirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserPhone {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select u.card from User u where u.phone=?1");

        System.out.println("Enter User Phone:");

        long phone = new Scanner(System.in).nextLong();

        q.setParameter(1, phone);

        AadharCard a = (AadharCard) q.getSingleResult();

        System.out.println(a);

        em.close();
        emf.close();
    }
}
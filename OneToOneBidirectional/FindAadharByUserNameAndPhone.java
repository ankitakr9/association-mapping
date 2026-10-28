package org.jsp.OneToOneBidirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserNameAndPhone {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select u.card from User u where u.name=?1 and u.phone=?2");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter User Name:");
        String name = sc.next();

        System.out.println("Enter User Phone:");
        long phone = sc.nextLong();

        q.setParameter(1, name);
        q.setParameter(2, phone);

        AadharCard a = (AadharCard) q.getSingleResult();

        System.out.println(a);

        sc.close();
        em.close();
        emf.close();
    }
}
package org.jsp.OneToOneBidirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharNumber {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select u from User u where u.card.number=?1");

        System.out.println("Enter Aadhar Number:");

        long number = new Scanner(System.in).nextLong();

        q.setParameter(1, number);

        User u = (User) q.getSingleResult();

        System.out.println(u);

        em.close();
        emf.close();
    }
}
package org.jsp.OneToOneBidirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharNumberAndDob {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select u from User u where u.card.number=?1 and u.card.dob=?2");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Aadhar Number:");
        long number = sc.nextLong();

        System.out.println("Enter DOB:");
        String dob = sc.next();

        q.setParameter(1, number);
        q.setParameter(2, dob);

        User u = (User) q.getSingleResult();

        System.out.println(u);

        sc.close();
        em.close();
        emf.close();
    }
}
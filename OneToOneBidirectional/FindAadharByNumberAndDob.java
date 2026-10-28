package org.jsp.OneToOneBidirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByNumberAndDob {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select a from AadharCard a where a.number=?1 and a.dob=?2");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Aadhar Number:");
        long number = sc.nextLong();

        System.out.println("Enter DOB:");
        String dob = sc.next();

        q.setParameter(1, number);
        q.setParameter(2, dob);

        AadharCard a = (AadharCard) q.getSingleResult();

        System.out.println(a);

        sc.close();
        em.close();
        emf.close();
    }
}
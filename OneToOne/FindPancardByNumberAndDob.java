package org.com.OneToOne;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPancardByNumberAndDob {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select p from Pancard p where p.panNo=?1 and p.dob=?2");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the PAN Number:");
        q.setParameter(1, sc.next());

        System.out.println("Enter the DOB:");
        q.setParameter(2, sc.next());

        Pancard pancard = (Pancard) q.getSingleResult();

        System.out.println(pancard);

        em.close();
        emf.close();
        sc.close();
    }
}
package org.com.OneToOne;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPancardNumberDob {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select p from Person p where p.card.panNo=?1 and p.card.dob=?2");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Pancard Number:");
        q.setParameter(1, sc.next());

        System.out.println("Enter the DOB:");
        q.setParameter(2, sc.next());

        Person person = (Person) q.getSingleResult();

        System.out.println(person);

        em.close();
        emf.close();
        sc.close();
    }
}
package org.jsp.OneToOneBidirectional;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByPhone {
	public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select u from User u where u.phone=?1");

        System.out.println("Enter the User Phone:");

        q.setParameter(1, new Scanner(System.in).nextLong());

        User user = (User) q.getSingleResult();

        System.out.println(user);

        em.close();
        emf.close();
    }
}

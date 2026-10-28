package org.jsp.OneToOneBidirectional;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByName {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "select u from User u where u.name=?1");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the User Name:");

        q.setParameter(1, sc.next());

        List<User> users = q.getResultList();

        for (User user : users) {
            System.out.println(user);
        }

        em.close();
        emf.close();
        sc.close();
    }
}
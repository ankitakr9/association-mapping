package org.jsp.ManyToOneUni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAnswerById {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        AnswerData ad = em.find(AnswerData.class, 1);

        if (ad != null) {
            System.out.println(ad);
        } else {
            System.out.println("Answer not found");
        }

        em.close();
        emf.close();
    }
}
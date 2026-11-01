package org.jsp.ManyToOneUni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAnswerByQuestion {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        List<AnswerData> list = em
                .createQuery(
                    "select a from AnswerData a where a.qd.question=?1",
                    AnswerData.class)
                .setParameter(1, "What is the most important thing in you life")
                .getResultList();

        for (AnswerData ad : list) {
            System.out.println(ad);
        }

        em.close();
        emf.close();
    }
}
package org.jsp.ManyToOneUni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindQuestionByQuestion {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        QuestionData qd = em
                .createQuery(
                    "select q from QuestionData q where q.question=?1",
                    QuestionData.class)
                .setParameter(1, "What is the most important thing in you life")
                .getSingleResult();

        System.out.println(qd);

        em.close();
        emf.close();
    }
}
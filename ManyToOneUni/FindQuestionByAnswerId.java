package org.jsp.ManyToOneUni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindQuestionByAnswerId {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        QuestionData qd = em.createQuery(
                "select a.qd from AnswerData a where a.id=?1",
                QuestionData.class)
                .setParameter(1, 1)
                .getSingleResult();

        System.out.println(qd);

        em.close();
        emf.close();
    }
}